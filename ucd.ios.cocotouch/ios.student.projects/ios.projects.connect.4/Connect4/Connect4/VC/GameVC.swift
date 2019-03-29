import UIKit

// CONNECT4 FRAMEWORK WITH DEEP LEARNING BOT
import Alpha0Connect4


//characters in the game
enum C4GameUserType : String {
    case user = "user"
    case bot  = "bot"
    
    static func convert(value: String) -> C4GameUserType {
        if(value == "user"){
            return C4GameUserType.user
        }else{
            return C4GameUserType.bot
        }
    }
}

class GameVC: UIViewController {
    @IBOutlet weak var infoLabel: UILabel!
    @IBOutlet weak var turnLabel: UILabel!
    @IBOutlet weak var centerBG: UIView!
    
    var gameboard = Gameboard()
    var gameSession = GameSession()
    var c4GameSession = C4GameSession()
    
    var botTimer : Timer?
    var userType : C4GameUserType!
    
    var animateReplayTimer : Timer?
    var animationIndex = 0
    
    let BOT_TEXT =  "Alpha0 is Playing"
    let USER_TEXT = "Your Turn"
    
    var replay = false
    
    var isRunning : Bool {
        return !self.gameSession.done
    }
    
  override func viewDidLoad() {
    super.viewDidLoad()
    
    if(self.replay == false){
        self.setupGame()
    }else{
        self.setupReplay()
    }
  }
    
    override func viewWillDisappear(_ animated: Bool) {
        if(self.animateReplayTimer?.isValid == true){
             self.animateReplayTimer?.invalidate()
        }
    }
    
     //if coming from history screen, this method will setup the information for replay of the game
    //call animateReplay in a timer after 1.5 sec
    func setupReplay(){
        self.infoLabel.text = ""
        let frame = CGRect(x: 0, y: 0, width: self.centerBG.frame.width, height: self.centerBG.frame.height)
        gameboard = Gameboard()
        self.gameboard.createOverlay(frame: frame)
        self.centerBG.addSubview(gameboard.view)
        
        for seq in self.c4GameSession.sequence.reversed(){
            print("\(seq.index) ---- \(seq.action)")
        } // print(self.c4GameSession.sequence.map({$0.action}))
        self.animateReplayTimer = Timer.scheduledTimer(timeInterval: 1.5, target: self, selector: #selector(self.animateReplay), userInfo: nil, repeats: true)
    }
    
     //this method will be called after each 1.5 sec to animate the sequence of the game
    @objc func animateReplay(){
        if(animationIndex == self.c4GameSession.sequence.count){
            animateReplayTimer?.invalidate()
            self.gameboard.showResult(index: self.c4GameSession.winningSequence)
        }else{
           
            self.gameboard.userType = self.c4GameSession.sequence[self.animationIndex].userType!
            
            if(self.gameboard.userType == .bot){
                self.turnLabel.text = self.BOT_TEXT
            }else{
                self.turnLabel.text = self.USER_TEXT
            }
            
            let tag = self.c4GameSession.sequence[self.animationIndex].action
            let index = self.c4GameSession.sequence[self.animationIndex].index
            print("\(index) ---- \(tag)")
            self.gameboard.createdisk(tag: tag , index: index , replay: true)
            animationIndex += 1
            
        }
    }
    
    //setup the game board for the game play
    //call methods to craete gameoard and add it to subview
    func setupGame(){
        let frame = CGRect(x: 0, y: 0, width: self.centerBG.frame.width, height: self.centerBG.frame.height)
        gameboard = Gameboard(startedBy: self.userType)
        self.gameboard.createOverlay(frame: frame)
        self.gameboard.userType = self.userType
        self.centerBG.addSubview(gameboard.view)
        
        if(self.gameboard.userType == .bot){
            self.turnLabel.text = BOT_TEXT
            Timer.scheduledTimer(timeInterval: 2, target: self, selector: #selector(self.startGame), userInfo: nil, repeats: false)
            }else{
            self.turnLabel.text = USER_TEXT
        }
        
        let swipeDown = UISwipeGestureRecognizer(target: self, action: #selector(resetGame))
        swipeDown.direction = .down
        self.view.addGestureRecognizer(swipeDown)
    }
    
    //start the game using this method when the bot is selected to start.
    @objc func startGame(){
        gameSession.botStarts = true
        if gameSession.botStarts {
            if let move = gameSession.move {
                DispatchQueue.main.async {
                    self.gameboard.createdisk(tag: move.action, index: move.index)
                    self.c4GameSession.addSequence(index: move.index, action: move.action , userType: self.gameboard.previousActionPlayedBy)
                }
                self.gameStatus()
            }
        }
    }
    
    
     //reset the gameboard and allow the user to restart the game
    @objc func resetGame(){
        print("Reset Game")
        self.gameboard.resetGame()
        self.c4GameSession.resetSession()
        self.gameSession = GameSession()
        
        if(self.userType == .bot){
            self.turnLabel.text = self.BOT_TEXT
            Timer.scheduledTimer(withTimeInterval: 1.25, repeats: false, block: { _  in
                self.startGame()
            })
        }else{
            self.turnLabel.text = self.USER_TEXT
        }
    }
    
    
    //this method is called when the user is playing
    //column:Int is the column number where the user clicks on the board
    func userPlay(column : Int){
        if(botTimer?.isValid == true){
            botTimer?.invalidate()
        }
        
        if gameSession.userPlay(at: column) {
            if let move = gameSession.move {
                DispatchQueue.main.async {
                    self.gameboard.createdisk(tag: move.action, index: move.index)
                    self.c4GameSession.addSequence(index: move.index, action: move.action , userType: self.gameboard.previousActionPlayedBy)
                }
                self.gameStatus()
            }
            
            self.botTimer = Timer.scheduledTimer(timeInterval: 1.5, target: self, selector: #selector(self.botPlay), userInfo: nil, repeats: false)
        }
    }
    
    
    //methods for bot to play the game
    @objc func botPlay(){
        if let move = gameSession.move {
            DispatchQueue.main.async {
                self.gameboard.createdisk(tag: move.action, index: move.index)
                self.c4GameSession.addSequence(index: move.index, action: move.action , userType: self.gameboard.previousActionPlayedBy)
            }
            self.gameStatus()
        }
    }
    
     //show the turn message so the user knows it's their turn to play
    func turnMessage(){
        Timer.scheduledTimer(withTimeInterval: 1.25, repeats: false, block: { _  in
            print(self.gameboard.userType)
            if(self.gameboard.userType == .bot){
                self.turnLabel.text = self.BOT_TEXT
            }else{
                self.turnLabel.text = self.USER_TEXT
            }
        })
    }
    
    //chekc for game status after every move
    //if there is an outcome, show the result
    func gameStatus(){
        if let outcome = gameSession.outcome {
            DispatchQueue.main.async {
                
                let winningIndexes = outcome.winningPieces.map({$0 + 1})
                Timer.scheduledTimer(timeInterval: 3, target: self, selector: #selector(self.showResults), userInfo: ["winning" : winningIndexes,  "message" : outcome.message], repeats: false)
                
                if(self.botTimer?.isValid == true){
                   self.botTimer?.invalidate()
                }
            }
        }else{
            self.turnMessage()
        }
    }
    
     
    //Extract informaation for final result and save it in the coredata session
    @objc func showResults(timer:Timer){
        let userInfo = timer.userInfo as! Dictionary<String, AnyObject>
        self.gameboard.showResult(index: userInfo["winning"] as! [Int])
        self.turnLabel.text =  userInfo["message"] as? String
        self.c4GameSession.saveSession(wonBy: self.gameboard.winningActionPlayedBy, winningSequence: userInfo["winning"] as! [Int])
    }
      
    //check for where the user touches the screen
    //get the view which was touched
    //check if it's animating, game is running and is replay or not.
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        let touch = touches.first
        guard let point = touch?.location(in: self.centerBG) else { return }
        let subViews = self.centerBG.subviews.first?.subviews.first?.subviews
        for view in subViews ?? [] {
          if (view.frame.contains(point)){
                if(!self.gameboard.isAnimating && self.isRunning == true && self.replay == false){
                    if(gameboard.userType == .user){
                        let column = gameboard.getColumn(tag: view.tag)
                        self.userPlay(column : column)
                    }
                }
            }
        }
    }
}
