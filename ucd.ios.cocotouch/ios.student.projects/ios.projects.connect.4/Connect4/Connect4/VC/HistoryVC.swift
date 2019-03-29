//
//  HistoryVC.swift
//  Connect4
//
//  Created by Gregoire Cousin on 20/03/2019.
//  Copyright © 2019 UCD. All rights reserved.
//

import UIKit
import CoreData

class HistoryVC: UITableViewController {
    var sessions = [C4GameSession]()
    var session  : C4GameSession!
    let REPLAY_GAMEVC_SEGUE = "replayGameVC"
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //cool things about the history: 
        //uncomment the following line to preserve selection between presentations
        //self.clearsselectiononviewwillappear = false

        //uncomment the following line to display an edit button in the navigation bar for this view controller.
        //self.navigationitem.rightbarbuttonitem = self.editbuttonitem
    }
    
    override func viewWillAppear(_ animated: Bool) {
        self.sessions = C4GameSession.getAllSessions().reversed()
        self.tableView.reloadData()
    }
    
    // MARK: Table view data source
    override func numberOfSections(in tableView: UITableView) -> Int {
        //#warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        //#warning Incomplete implementation, return the number of rows
        return self.sessions.count
    }

    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let CELL_IDENTIDIER = "historyCell"
        let cell = tableView.dequeueReusableCell(withIdentifier: CELL_IDENTIDIER, for: indexPath) as! HistoryCell
        cell.configure(session: self.sessions[indexPath.row] ,  gameNumber : indexPath.row + 1)
        return cell
    }
 
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        self.session = self.sessions[indexPath.row]
        self.performSegue(withIdentifier: REPLAY_GAMEVC_SEGUE, sender: nil)
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == REPLAY_GAMEVC_SEGUE {
            let vc = segue.destination as! GameVC
            vc.replay = true
            vc.c4GameSession = self.session
        }
    }
}
