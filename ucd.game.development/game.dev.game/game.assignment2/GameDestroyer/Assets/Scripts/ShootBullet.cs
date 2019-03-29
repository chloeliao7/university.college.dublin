using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ShootBullet : MonoBehaviour {

    Transform _transform;
    public GameObject Bullet;
    public float Bullet_Forward_Force, ShootAccuracy;
    public bool randomShoot;
    public MyDoneController PlayerDroneController;
    bool parentCrashed = false, Playercrashed = false;

    //use this for initialization
    void Awake() {
        _transform = this.gameObject.GetComponent<Transform>();
        StartCoroutine(RandomizeShoot());
    }
    //to instantiate a bullet and shoot in the direction where launcher is facing
    void shootBullet(float multiplier) {
        //the bullet instantiation happens here.
        GameObject Temporary_Bullet_Handler;
        Temporary_Bullet_Handler = Instantiate(Bullet, _transform.position, _transform.rotation)as GameObject;

        //sometimes bullets may appear rotated incorrectly due to the way its pivot was set from the original modeling package.
        //this is easily corrected here, you might have to rotate it from a different axis and or angle based on your particular mesh.
        Temporary_Bullet_Handler.transform.Rotate(Vector3.left * 90);

        //retrieve the rigidbody component from the instantiated bullet and control it.
        Rigidbody Temporary_RigidBody;
        Temporary_RigidBody = Temporary_Bullet_Handler.GetComponent<Rigidbody>();

        float rel_force = Bullet_Forward_Force;
        
        //decide on the relative force to be applied depending on drones movement
        if(multiplier > 0)
            rel_force = Bullet_Forward_Force * 4 * Mathf.Abs(multiplier);
        else if(multiplier < 0)
            rel_force = Bullet_Forward_Force * Mathf.Abs(multiplier) * 0.09f;
        Temporary_RigidBody.AddForce(_transform.transform.forward * rel_force);
        //destroy in 3 seconds
        Destroy(Temporary_Bullet_Handler, 3f);

    }
    //this handles shooting for both criminal and player drone
    IEnumerator RandomizeShoot() {

        while(true) {
            //this script is applied on launcher child, to check if the criminal drone has crashed, we need to know its parent is crashed or not
            //we append "crashed" in the gameobject name if it is crashed
            parentCrashed = _transform.root.name.Contains("crashed");
            Playercrashed = PlayerDroneController.gameObject.name.Contains("crashed");
            if(!parentCrashed && !Playercrashed) {
                //this is to allow player drone to shoot on pressing spacebar
                float multiplier = Random.Range(.5f, 1f);
                if(Input.GetKeyDown(KeyCode.Space) && !randomShoot) {
                    multiplier = Input.GetAxis("Vertical");
                    shootBullet(multiplier);
                }
                //to allow criminal drones to shoot randomly
                else if(randomShoot) {
                    yield return new WaitForSeconds(multiplier * 5f);
                    //if we press w/s,relative velocity is calculated to adjust the velocity of bullet else it is shot with velocty of 0.3
                    float rel_vel = Input.GetAxis("Vertical") == 0?.3f : Mathf.Abs(PlayerDroneController.vel_z) * ShootAccuracy / 2 * 0.1f;

                    shootBullet(rel_vel);

                }
            }
            yield return null;
        }
    }
}