using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlaneTakeOff : MonoBehaviour {
    Rigidbody _rigidbody;
    Transform _transform;
    Vector3 TargetPostition, InitialPosition, InitialRotation;
    float velocity;
    private void Awake() {
        _rigidbody = this.gameObject.GetComponent<Rigidbody>();
        _transform = this.gameObject.GetComponent<Transform>();
        InitialPosition = _transform.position;
        InitialRotation = _transform.eulerAngles;
        StartCoroutine(RandomizeTakeOff());
    }

    IEnumerator RandomizeTakeOff() {
        float r;
        while(true) {
            velocity = 0;
            r = Random.Range(5, 10);
            yield return new WaitForSeconds(r);
            //horizontal acceleration on runway and makes plane run on runway until its velocity is smaller than 600
            while(velocity < 600) {
                _rigidbody.AddForce(_transform.forward * velocity, ForceMode.Acceleration);
                velocity += 10f;
                yield return new WaitForSeconds(.1f);
            }
            //takeoff from runway and fly when velocity is greater than 600
            while(velocity < 900) {
                _rigidbody.AddForce((_transform.forward + _transform.up) * velocity, ForceMode.Acceleration);
                //add rotation to look upwards
                _rigidbody.AddTorque(_transform.right * -300f);
                velocity += 10f;
                yield return new WaitForSeconds(.1f);
            }
            //dampen momentum of the drone
            _rigidbody.velocity = Vector3.zero;
            _rigidbody.angularVelocity = Vector3.zero;
            
            //reset rotation and position of plane to takeoff again
            _transform.position = InitialPosition;
            _transform.eulerAngles = InitialRotation;
        }
    }
}