//
//  HistoryTVC.swift
//  TweeterTags
//
//  Created by Gregoire Cousin on 06/03/2019.
//  Copyright © 2019 COMP47390-41550. All rights reserved.
//

import UIKit

class HistoryTVC: UITableViewController {
    
    //history array that returns the search strings
    var historyArray:[String]? {
        get {
            let history = UserDefaults.standard.object(forKey: "history") as? [String]
            
            //reverse the array to get the latest searched string at the top
            return history?.reversed()
        }
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        if ( historyArray != nil) {
            return  historyArray!.count
        } else {
            return 0
        }
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "historyCell" , for: indexPath)
        cell.textLabel?.text =  historyArray![indexPath.row]
        return cell
    }
    
    override func viewWillAppear(_ animated: Bool) {
        tableView.reloadData()
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if let destination =  segue.destination as? TweetsTVC{
            if let StringSender =  sender as? UITableViewCell{
                destination.twitterQueryText = (StringSender.textLabel?.text)!
            }
        }
    }
    
    override func viewDidLoad() {
        self.title="Search History"
    }   
}
