using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LevelSelector : MonoBehaviour {
    //list of criminal drones
    public Transform[] CriminalDrones;
    //store initial transforms
    readonly Transform[] InitialTransforms = new Transform[3];
    //menu parent object, to show/hide menu
    public GameObject Menu;
    //get player drone
    public GameObject PlayerDrone;
    //game object of game status banner
    public GameObject GameStatus;
    //get all scripts of launchers for criminal drones
    public ShootBullet[] ShootScripts;

    private void Awake() {
        //store initial transforms of all the criminal drones to allow reset using initial values
        for(int i = 0; i < 3; i++)
            InitialTransforms[i] = CriminalDrones[i];
    }


    public void ResetDrones() {
        //make all criminal drone inactive and reset transform position and rotation
        for(int i = 0; i < 3; i++) {
            CriminalDrones[i].gameObject.SetActive(false);
            CriminalDrones[i] = InitialTransforms[i];
        }
        PlayerDrone.SetActive(true);
        GameStatus.SetActive(true);
    }
    
    
    
    public void EasyMode() {
        ResetDrones();
        //make only first criminal drone active adn set detection zone to 30
        CriminalDrones[0].gameObject.SetActive(true);
        CriminalDrones[0].gameObject.GetComponent<CriminalDroneController>().chase_radius = 30f;
        //shoot accuracy range is from 0 to 1 where 1 stands for 80%
        ShootScripts[0].ShootAccuracy = 0.4f;
        //turn off menu screen
        Menu.SetActive(false);
    }



    public void MediumMode() {
        ResetDrones();
        //make first and second criminal drones active and set detection zone to 50
        for(int i = 0; i < 2; i++) {
            CriminalDrones[i].gameObject.SetActive(true);
            CriminalDrones[i].gameObject.GetComponent<CriminalDroneController>().chase_radius = 50f;
            //shoot accuracy range is from 0 to 1 where 1 stands for 80%
            ShootScripts[i].ShootAccuracy = 0.8f;
        }
        //turn off menu screen
        Menu.SetActive(false);
    }




    public void HardMode() {
        ResetDrones();
        //make all three criminal drones active and set detection zone to 70
        for(int i = 0; i < 3; i++) {
            CriminalDrones[i].gameObject.SetActive(true);
            CriminalDrones[i].gameObject.GetComponent<CriminalDroneController>().chase_radius = 70f;
            //shoot accuracy range is from 0 to 1 where 1 stands for 80%
            ShootScripts[i].ShootAccuracy = 1f;
        }
        //turn off menu screen
        Menu.SetActive(false);
    }

}