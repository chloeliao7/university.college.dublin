//
//  HistoryCell.swift
//  Connect4
//
//  Created by Gregoire Cousin on 20/03/2019.
//  Copyright © 2019 UCD. All rights reserved.
//

import UIKit

class HistoryCell: UITableViewCell {
    @IBOutlet weak var gameNumber: UILabel!
    @IBOutlet weak var wonBy: UILabel!
    @IBOutlet weak var totalActions: UILabel!
    @IBOutlet weak var winningSequence: UILabel!

    //initialization code
    override func awakeFromNib() {
        super.awakeFromNib()
    }
    
    //configure the view for the selected state
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
    }
    
    //configure the view for winner
    func configure(session : C4GameSession , gameNumber : Int){
        self.wonBy.text = "Won By : " + session.wonBy!.rawValue.capitalized
        let winningSequenceText = session.winningSequence.map({String($0)}).joined(separator: ",")
        self.winningSequence.text = "Winning Sequence : " + winningSequenceText
        self.totalActions.text = "Total Actions : " + String(session.sequence.count)
        self.gameNumber.text = String(gameNumber)
    }
}
