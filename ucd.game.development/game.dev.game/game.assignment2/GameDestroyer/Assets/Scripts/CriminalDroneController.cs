using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class CriminalDroneController : MonoBehaviour {
    Transform _transform;
    Rigidbody _rigidbody, PlayerDrone_rigidbody;
    public GameObject _propellers;
    public Transform PlayerDrone;
    float stability = 1f, stability_speed = 4f;
    bool shouldChase;
    public float SideDistanceFromPLayerDrone;
    public float distanceFromPlayerDrone, chaseSpeed, chase_radius;
    int LastHitGameObject = -1;
    bool isCrashed = false;
    public Text CriminalsCrashedCountUI;
    string originalName;
    
    //use this for initialization
    Transform PlayerBullet;
    Vector3 OriginalPosition;
    
    void Awake() {
        _transform = this.gameObject.GetComponent<Transform>();
        _rigidbody = this.gameObject.GetComponent<Rigidbody>();
        PlayerDrone_rigidbody = PlayerDrone.GetComponent<Rigidbody>();
        originalName = _transform.name;
        OriginalPosition = _transform.position;
        StartCoroutine(ControlDrone());

    }
    
    //called when a collision is detected
    private void OnCollisionEnter(Collision collision) {
        //same logic applied for mydrone
        int other_id = collision.transform.root.GetInstanceID();
        if(LastHitGameObject != other_id && !isCrashed) {
            LastHitGameObject = other_id;
            if(collision.transform.root.CompareTag("PlayerBullet")) {
                //objective is to make the criminal drone crash if player bullet hits criminal drone
                //increase the killcount on ui banner
                int killCount = int.Parse(CriminalsCrashedCountUI.text);
                CriminalsCrashedCountUI.text =(killCount + 1).ToString();
                //apply gravity to make it fall
                _rigidbody.useGravity = true;
                isCrashed = true;
                //update the name
                _transform.name += "_crashed";
                //tangle rope to the drone rotor
                PlayerBullet = collision.transform.root;
                //call revive drone
                StartCoroutine(ReviveDrone());

            }
        }
    }
    //this is called once drone is crashed
    IEnumerator ReviveDrone() {
        int r = Random.Range(20, 40);
        //wait for random seconds in range [20, 40]
        yield return new WaitForSeconds(r);
        //reset values to revive drone
        isCrashed = false;
        _rigidbody.useGravity = false;
        _transform.name = originalName;
    }

    //facilitate controls of criminal drones
    IEnumerator ControlDrone() {
        //make a list for 4 propellers discs
        List<Transform> discs_transform = new List<Transform>();
        int total_children = _propellers.transform.childCount;
        for(int i = 0; i < total_children; i++) {
            discs_transform.Add(_propellers.transform.GetChild(i)); //discs are indexed from 0-3
        }

        while(true) {
            //if criminal drone is not crashed and player drone is not crashed
            if(!isCrashed) {
                float chase_distance_x = Mathf.Abs(PlayerDrone.position.x - _transform.position.x);
                float chase_distance_z = Mathf.Abs(PlayerDrone.position.z - _transform.position.z);
                //chase radius defines the detection range where player drone is detected by criminal drone
                //-530 and -300, are the upper and lower bounds to make drone only follow player drone near runway.
                //if player drone is crashed, criminal drones go back to original position again and start obstructing planes
                if(chase_distance_x <= chase_radius && _transform.position.x >= -530f && _transform.position.x <= -300 && !PlayerDrone.name.Contains("crashed")) {
                    //rotate to look at the player

                    Vector3 target_look_position = PlayerDrone.position + PlayerDrone.forward * Mathf.Abs(PlayerDrone_rigidbody.velocity.z) * Mathf.Sign(Input.GetAxis("Vertical")) * 0.1f;
                    _transform.LookAt(target_look_position);

                    //follow the player drone position
                    Vector3 target_position = PlayerDrone.position + PlayerDrone.forward * distanceFromPlayerDrone + SideDistanceFromPLayerDrone * PlayerDrone.right;

                    //if criminal drone is too far, it will chase with 2x speed to catchup with the player drone
                    if(chase_distance_z > chase_radius)
                        _transform.position = Vector3.Lerp(_transform.position, target_position, chaseSpeed * 2 * Time.deltaTime);
                    else
                        _transform.position = Vector3.Lerp(_transform.position, target_position, chaseSpeed * Time.deltaTime);

                } else {
                    //stabilize the criminal drone 
                    //angleaxis is reponsiblr for creating a rotation around an axis
                    //we want to move drone stabilize, by moving its up/y vector to point at world up.
                    //stability 1 means it will align accurately and 0,0,0 will be the target rotation
                    //stability_speed defines how fast to achieve the stability
                    Vector3 predictedUp = Quaternion.AngleAxis(
                        _rigidbody.angularVelocity.magnitude * Mathf.Rad2Deg * stability / stability_speed,
                        _rigidbody.angularVelocity) * _transform.up;
                    //apply rotation force(torque) using cross product of calculated predicted up and world vector3 up
                    Vector3 torqueVector = Vector3.Cross(predictedUp, Vector3.up);
                    _rigidbody.AddTorque(torqueVector * stability_speed);

                    //go back to original position
                    _transform.position = Vector3.MoveTowards(_transform.position, OriginalPosition, Time.deltaTime * 10);
                }
            } else {
                //this sticks the rope to drone rotor and while drone crashes
                if(PlayerBullet != null)
                    PlayerBullet.position = _transform.position;
            }
            yield return null;
        }
    }
}