using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class MyDoneController : MonoBehaviour {

    Transform _transform;
    Rigidbody _rigidbody;
    public GameObject _propellers;
    public float stability;
    public float stability_speed;
    public float acceleration;
    public float rotation_speed;
    //velocity in z direction
    [HideInInspector]
    public float vel_z;
    //ui text variables
    public Text DroneStatusUI, RotorsDamagedUI;
    int RotorsDamaged = 0;
    //a list of status to print on ui
    string[] HealthStatus = new string[] { "Excellent", "Good", "Moderate", "Critical" };
    int LastHitGameObject = -1;
    //to check if drone is crashed or not
    [HideInInspector]
    public bool isCrashed = false;

    bool InsideRepairZone = false;
    //use this for initialization
    void Awake() {
        _transform = this.gameObject.GetComponent<Transform>();
        _rigidbody = this.gameObject.GetComponent<Rigidbody>();
        StartCoroutine(ControlDrone());
    }

    //when a object collides, this is called
    private void OnCollisionEnter(Collision collision) {
        //get id of the root object(outer most parent) collided with drone
        int other_id = -1;
        if(collision.transform.root.CompareTag("CriminalBullet"))
            other_id = collision.transform.root.GetInstanceID();
        else
            other_id = collision.transform.GetInstanceID();
        //to avoid multiple detection of same object collision
        if(LastHitGameObject != other_id && isCrashed == false) {
            LastHitGameObject = other_id;
            //print(collision.gameobject);
            if(collision.transform.root.CompareTag("CriminalBullet") || collision.gameObject.CompareTag("AirportPlane")) {
                //do following if drone is hit by criminal's bullet
                RotorsDamaged += 1;
                RotorsDamagedUI.text = "Rotors Damaged: " + RotorsDamaged.ToString();
                DroneStatusUI.text = "Drone Health: " + HealthStatus[(int)(RotorsDamaged / 4)];

                //crashed, if all 12 rotors are damaged
                if(RotorsDamaged >= 12) {
                    isCrashed = true;
                    _rigidbody.useGravity = true;
                    _transform.name += "_crashed";
                    DroneStatusUI.text = "Drone Crashed - Game Over! ";
                }
            } else if(collision.gameObject.CompareTag("RepairZone") && RotorsDamaged < 12) {
                InsideRepairZone = true;
                StartCoroutine(RepairDrone());
            }
        }
    }

    private void OnCollisionExit(Collision collision) {
        //to avoid multiple detection of same object collision
        if(collision.gameObject.CompareTag("RepairZone")) {
            InsideRepairZone = false;
        }
    }

    IEnumerator RepairDrone() {
        while(RotorsDamaged > 0) {
            if(InsideRepairZone == false)
                break;

            //update the drone repair status
            DroneStatusUI.text = "Repairing Drone in " + RotorsDamaged.ToString() + "secs";
            //decrement damaged rotors as 1 rotor gets repaired in 1 second
            RotorsDamaged -= 1;
            //update rotors damaged ui
            RotorsDamagedUI.text = "Rotors Damaged: " + RotorsDamaged.ToString();

            //wait for 1 second
            yield return new WaitForSeconds(1);

        }
        DroneStatusUI.text = "Drone Health: " + HealthStatus[(int)(RotorsDamaged / 4)];
        yield return null;
    }
    IEnumerator ControlDrone() {

        //make a list for 4 propellers discs
        List<Transform> discs_transform = new List<Transform>();
        int total_children = _propellers.transform.childCount;
        for(int i = 0; i < total_children; i++) {
            discs_transform.Add(_propellers.transform.GetChild(i)); //discs are indexed from 0-3
        }

        while(!isCrashed) {

            float upDown = Input.GetAxis("Vertical"); // w/s controls
            float arrowsUpDown = Input.GetAxis("ArrowsVertical"); //up arrow/down arrow tilt
            float leftRight = Input.GetAxis("Horizontal"); //a/d controls
            float vel_x = _rigidbody.velocity.x;
            float vel_y = _rigidbody.velocity.y;
            vel_z = _rigidbody.velocity.z;
            Vector3 euler = _transform.eulerAngles;
            float target_z = 0, target_y = 0, target_x = 0;
            if(arrowsUpDown != 0) {
                target_x = 45 * Mathf.Sign(arrowsUpDown);
                euler.x = Mathf.LerpAngle(euler.x, target_x, 2 * Time.deltaTime);
                _transform.eulerAngles = euler;
                _rigidbody.AddForce(Vector3.up * Mathf.Sign(arrowsUpDown) * -20, ForceMode.Acceleration);
            }
            if(upDown != 0 && Mathf.Abs(vel_x) < 50 && Mathf.Abs(vel_y) < 50 && Mathf.Abs(vel_z) < 50) {
                //handle acceleration
                _rigidbody.AddForce(_transform.forward * upDown * acceleration, ForceMode.Acceleration);

            } else {
                //dampen momentum of the drone
                //reduce the velocity gradually to make it stop and not keep on going
                _rigidbody.velocity *= 0.99f;
                _rigidbody.angularVelocity *= 0.99f;
            }

            if(leftRight != 0) {
                //set target rotation and apply them based on a/d pressed
                target_z = -45 * Mathf.Sign(leftRight);
                target_y = euler.y + 10 * Mathf.Sign(leftRight) * Mathf.Sign(upDown);
                euler.z = Mathf.LerpAngle(euler.z, target_z, rotation_speed * Time.deltaTime);
                euler.y = Mathf.LerpAngle(euler.y, target_y, rotation_speed * Time.deltaTime);
                _transform.eulerAngles = euler;

            }
            //if no key is pressed, stabilize the z rotation back to 0
            else if(leftRight == 0 && arrowsUpDown == 0) {
                euler.z = Mathf.LerpAngle(euler.z, 0, 1 * Time.deltaTime);
                _transform.eulerAngles = euler;
            }

            //handle propeller rotations
            for(int i = 0; i < discs_transform.Count; i++) {
                //rotate odd rotors in anticlockwise
                if(i % 2 == 1)
                    discs_transform[i].Rotate(0, 0, 300 *(Mathf.Abs(upDown) + 1));
                //rotate even rotors in clockwise
                else
                    discs_transform[i].Rotate(0, 0, -300 *(Mathf.Abs(upDown) + 1));
            }

            if(leftRight == 0 && arrowsUpDown == 0) {
                
                //stabilize the criminal drone 
                //angleaxis is reponsiblr for creating a rotation around an axis
                //we want to move drone stabilize, by moving its up/y vector to point at world up.
                //stability 1 means it will align accurately and 0,0,0 will be the target rotation
                //stability_speed defines how fast to achieve the stability
                Vector3 predictedUp = Quaternion.AngleAxis(
                    _rigidbody.angularVelocity.magnitude * Mathf.Rad2Deg * stability / stability_speed,
                    _rigidbody.angularVelocity) * _transform.up;

                Vector3 torqueVector = Vector3.Cross(predictedUp, Vector3.up);
                _rigidbody.AddTorque(torqueVector * stability_speed * stability_speed);
            }

            yield return new WaitForSeconds(.01f);
        }
    }
}