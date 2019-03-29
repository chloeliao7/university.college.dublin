//
//  UserSelectVC.swift
//  Connect4
//
//  Created by Gregoire Cousin on 18/03/2019.
//  Copyright © 2019 UCD. All rights reserved.
//

import UIKit

class UserSelectVC: UIViewController {
    var gameUserType = C4GameUserType.user
    let GAMEVC_SEGUE = "gameVC"
    
    override func viewDidLoad() {
        super.viewDidLoad()
        //do any additional setup after loading the view.
    }
    
    @IBAction func selectUser(_ sender: Any) {
        gameUserType = .user
        self.performSegue(withIdentifier: GAMEVC_SEGUE, sender: nil)
    }
    
    @IBAction func selectBot(_ sender: Any) {
        gameUserType = .bot
        self.performSegue(withIdentifier: GAMEVC_SEGUE, sender: nil)
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == GAMEVC_SEGUE {
            let vc = segue.destination as! GameVC
            vc.userType = gameUserType
        }
    }
    
    /*
    MARK: - Navigation
    In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        Get the new view controller using segue.destination.
        Pass the selected object to the new view controller.
    }
    */
}
