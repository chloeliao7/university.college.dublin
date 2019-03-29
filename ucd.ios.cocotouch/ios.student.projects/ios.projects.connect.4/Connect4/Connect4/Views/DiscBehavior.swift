//
//  DiscBehavious.swift
//  Connect4
//
//  Created by Gregoire Cousin on 18/03/2019.
//  Copyright © 2019 UCD. All rights reserved.
//

import UIKit

//disc behavior
class DiscBehaviour: UIDynamicBehavior {
    var animator = UIDynamicAnimator()
    var disk : UIView!
    var reference : UIView!
    
    //Initializing eachs discs
    init(disk : UIView ,  reference : UIView) {
        self.disk = disk
        self.reference = reference
    }
    
    override init(){}
    
    override func addChildBehavior(_ behavior: UIDynamicBehavior) {
        //setting scope to only trigger when in UISnapBehavior
        if(type(of: behavior) == UISnapBehavior.self){
            animator = UIDynamicAnimator(referenceView: reference)
            //giving spring like motion and damping
            let snap = behavior as! UISnapBehavior
            snap.damping = 1.0
            animator.addBehavior(behavior)
            snap.action = { print("Snap Animation Stopped") }
        }
        
        //gives gravity to each disc and drops them at specific rates
        if(type(of: behavior) == UIGravityBehavior.self ){
            animator = UIDynamicAnimator(referenceView: reference)
            let gravity = behavior as! UIGravityBehavior
            let directtion = CGVector(dx: 0.0, dy: 1.0)
            gravity.gravityDirection = directtion
            gravity.magnitude = 1.0
            
            //stops the gravity of the discs
            gravity.action = {
                if(self.disk.frame.origin.y > 2000){
                    print("Gravity Animation Stopped")
                    self.animator.removeBehavior(gravity) //remove gravity
                }
            }
            animator.addBehavior(gravity)
        }
        
    }
    
}
