using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LauncherController : MonoBehaviour {
    //transform component for this gameobject
    Transform _transform;

    //use this for initialization
    void Awake() {
        _transform = this.gameObject.GetComponent<Transform>();
        //when a yield statement is used, the coroutine will pause execution and automatically resume at the next frame
        StartCoroutine(ControlLauncher());
    }

    IEnumerator ControlLauncher() {
        while(true) {

            float leftRight = Input.GetAxis("ArrowsHorizontal"); //a/d controls
            float target_y = 0, target_z = 0;
            Vector3 euler = _transform.localEulerAngles;

            //handle tilting and rotation
            if(leftRight != 0) {
                //set the target left/right deviation limit to 30 degrees. 
                //sign provides the direction based on the key pressed.
                //if left is pressed, value < 0; if right is pressed, value > 0, if none, value == 0
                target_y = 30 * Mathf.Sign(leftRight);
                euler.y = Mathf.LerpAngle(euler.y, target_y, 2 * Time.deltaTime);

                //set the target up/down tilt  limit to 45 degrees. sign provides the direction based on the key pressed.
                target_z = -45 * Mathf.Sign(leftRight);
                euler.z = Mathf.LerpAngle(euler.z, target_z, 2 * Time.deltaTime);

            } else {
                //this code gradually resets the rotation as target is now 0 degrees
                euler.z = Mathf.LerpAngle(euler.z, 0, 1 * Time.deltaTime);
                euler.y = Mathf.LerpAngle(euler.y, 0, 1 * Time.deltaTime);
            }
            _transform.localEulerAngles = euler;
            yield return new WaitForSeconds(.01f);
        }
    }
}