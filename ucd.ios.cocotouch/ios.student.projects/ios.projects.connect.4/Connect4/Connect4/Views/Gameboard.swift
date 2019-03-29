//
//  Gameboard.swift
//  Connect4
//
//  Created by Gregoire Cousin on 16/03/2019.
//  Copyright © 2019 UCD. All rights reserved.
//

import UIKit

class Gameboard: UIView {
    //views
    public var view = UIView()
    public var boardView = UIView()
    //attributes
    private var diskSize : CGFloat = 0.0
    public var userType = C4GameUserType.user //bringing in player
    //discs and disc behavior
    var diskBehavior = DiscBehaviour()
    private var gameDisks = [UIView]()
    //players
    var winningActionPlayedBy : C4GameUserType!
    var previousActionPlayedBy : C4GameUserType!
    var startedBy : C4GameUserType?
    //animation checker
    var isAnimating : Bool {
        return self.diskBehavior.animator.isRunning
    }
    
    /*
     Only override draw() if you perform custom drawing. An empty implementation adversely affects performance during animation. override func draw(_ rect: CGRect) {}
    */
    
    //draw rectangle init with user select
    init(startedBy : C4GameUserType){
        super.init(frame: CGRect(x: 0, y: 0, width: 0, height: 0))
        self.startedBy = startedBy
    }
    
    //draw rectangle
    init(){
       super.init(frame: CGRect(x: 0, y: 0, width: 0, height: 0))
    }

    
    //INFO: NSCoder enables archiving and distribution of other objects. checking for errors on init
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    //overlay for main view for discs to apear
    func createOverlay(frame: CGRect) {
        var xOffset : CGFloat = 0
        var yOffset : CGFloat = 0
        self.diskSize = (frame.width - 101) / 7

        //setting the frame in the method
        self.boardView.frame = frame
        var name = 0
        
        //calculations for offsets
        for i in 1...6{
            if(i == 1){
               yOffset += 10
            }else{
                //left and righ distance = 40px
                yOffset += frame.height / CGFloat(6.0)
            }
            xOffset  = 0
            for j in 1...7{
                if(j == 1){
                    xOffset += 20
                }else{
                    //.left and righ distance = 40px
                    xOffset += (frame.width - 40) / 7.0
                }
                
                //creation of the disk path and shape
                let diskFrame = CGRect(x: 0, y: 0, width: diskSize, height: diskSize)
                let diskPath = UIBezierPath(ovalIn: diskFrame)
                let diskShape = CAShapeLayer()
                
                //setting for the disk shape and color
                diskShape.path = diskPath.cgPath
                diskShape.fillColor = UIColor.white.cgColor
                diskShape.strokeColor = UIColor.brown.cgColor
                diskShape.lineWidth = 1.0
                
                name += 1
                diskShape.name = String(name)

                //creation of the disk's view and putting the shape in it
                let diskView = UIView(frame: CGRect(x: xOffset, y: yOffset, width: diskSize, height: diskSize))
                diskView.tag = name

                diskView.layer.addSublayer(diskShape)
                boardView.addSubview(diskView)
            }
        }
        boardView.backgroundColor = UIColor.red
        self.view.addSubview(boardView)
    }
    
    //method to get the frame of the diskspace so the disk falls at the right space.
    func getFrame(tag : Int) -> CGRect?{
        var frame : CGRect?
        let subViews = self.view.subviews.first?.subviews
        for view in subViews ?? [] {
            if (view.tag == tag){
                frame = view.frame
            }
        }
        return frame
    }
    
     //get the column number by giving it the tag number of the view from 1-42
    func getColumn(tag : Int) -> Int {
        let subViews = self.view.subviews.first?.subviews
        var column = 0
        let columns = [[1,8,15,22,29,36],
                       [2,9,16,23,30,37],
                       [3,10,17,24,31,38],
                       [4,11,18,25,32,39],
                       [5,12,19,26,33,40],
                       [6,13,20,27,34,41],
                       [7,14,21,28,35,42]]
        
        for view in subViews ?? [] {
            if (view.tag == tag){
                _ = columns.enumerated().map{
                    if($0.element.contains(tag)){
                        column = $0.offset
                    }
                }
            }
        }
        return column
    }
    
    //method to highlight the disks that are part of winning sequence
    func showResult(index : [Int]){
        if(userType == .bot){
            winningActionPlayedBy = .user
        }else if(userType == .user){
            winningActionPlayedBy = .bot
        }
        
        let subViews = self.view.subviews.first?.subviews
        for view in subViews ?? [] {
            print(view.tag)
            if (index.contains(view.tag - 100)){
                view.layer.borderColor = UIColor.blue.cgColor
                view.layer.borderWidth = 3.0
                view.layer.cornerRadius = view.frame.height / 2
            }
        }
        print(index)   
    }
    
     //method to create the disk that falls from top
    func createdisk(tag : Int ,  index : Int , replay : Bool = false){
        var frame : CGRect!
        
         //check if it's a replay or not.
        //tag number not coming from replay is between 0-41 so we have to increase it one to save it in database for our use.
        if(replay){
            frame = getFrame(tag: tag)
        }else{
            frame = getFrame(tag: tag + 1)
        }
        guard frame != nil else {
            return
        }
        
         //creation of the disk path and shape
        var diskName =  100
        let diskFrame = CGRect(x: 0, y: 0, width: diskSize, height: diskSize)
        let diskPath = UIBezierPath(ovalIn: diskFrame)
        let diskShape = CAShapeLayer()
        diskShape.path = diskPath.cgPath
        
        
        //setting for the disk shape and color based on user
        if(userType == .user){
            diskShape.fillColor = UIColor.yellow.cgColor
            diskShape.strokeColor = UIColor.brown.cgColor
        }else{
            diskShape.fillColor = UIColor.green.cgColor
            diskShape.strokeColor = UIColor.brown.cgColor
        }
        diskShape.lineWidth = 1.0
        if(replay){
            diskName += (tag)
        }else{
            diskName += (tag + 1)
        }
        diskShape.name = String(tag)
        
         //creation of the disk's view and putting the shape in it
        let diskView = UIView(frame: CGRect(x: frame.origin.x, y: -200, width: diskSize, height: diskSize))
        
        //diskView.backgroundColor = UIColor.gray
        diskView.clipsToBounds = true
        diskView.tag = diskName
        diskView.layer.addSublayer(diskShape)
        
        let diskLabel  = UILabel(frame: CGRect(x: 0, y: 0, width: diskSize, height: diskSize))
        diskLabel.text = String(index)
        diskLabel.textAlignment = .center
        diskLabel.textColor = UIColor.brown
        diskView.addSubview(diskLabel)
        
        boardView.addSubview(diskView)
        gameDisks.append(diskView)
        
        let position = CGPoint(x: frame!.midX , y: frame!.midY)
        diskBehavior = DiscBehaviour(disk: diskView, reference: self.view)
        
        let snap = UISnapBehavior(item: diskView, snapTo: position)
        diskBehavior.addChildBehavior(snap)
        
        self.diskBehavior.animator.delegate = self;
        if(userType == .bot){
            previousActionPlayedBy  = userType
            userType = .user
        }else if(userType == .user){
            previousActionPlayedBy  = userType
            userType = .bot
        }
        
    }
    
    //reset the gameboard by adding the gravity behaviour to remove disks
    //the collision is not working because it's not dropping on a plane so can be removed (check if it works)
    func resetGame(){
        self.diskBehavior.animator.delegate = self;
        let collision = UICollisionBehavior(items: gameDisks)
        let gravity = UIGravityBehavior(items: gameDisks)

        self.diskBehavior.addChildBehavior(collision)
        self.diskBehavior.addChildBehavior(gravity)

        self.userType = self.startedBy!
        self.gameDisks.removeAll()
    }
}

//MARK:- UIDynamicAnimator Delegate
extension Gameboard : UIDynamicAnimatorDelegate {
    func dynamicAnimatorDidPause(_ animator: UIDynamicAnimator) {
        print("Animation Paued")
        self.view.isUserInteractionEnabled = true
        self.boardView.isUserInteractionEnabled = true
    }

}
