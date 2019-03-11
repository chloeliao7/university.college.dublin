//
//  TweetsTVC.swift
//  TweeterTags
//
//  Created by Gregoire Cousin on 03/03/2019.
//  Copyright © 2019 COMP47390-41550. All rights reserved.

import UIKit

class TweetsTVC: UITableViewController,UITextFieldDelegate {

    //all tweets coming from twitter
    var tweets = [[TwitterTweet]]()
    
    //query text field for search
    //set delegate to self and assign the twitterQueryText to the text field
    //assigning the twitterQueryText will help update the textfield if it doesn't have # or @ sign
    @IBOutlet weak var twitterQueryTextField: UITextField! {
        didSet {
            self.twitterQueryTextField.delegate = self
            self.twitterQueryTextField.text = twitterQueryText
        }
    }
    
    //variable to store search string
    var twitterQueryText :
     String? = "#ucd" {
        didSet{
            //check if the variable has # in it
            //description says to search for hashtag or user to add # if it's a simple string
            //update the textfield too
            if !(twitterQueryText?.hasPrefix("#") == true || twitterQueryText?.hasPrefix("@") == true ){
                self.twitterQueryText!.insert("#", at: twitterQueryText!.startIndex)
                twitterQueryTextField.text = twitterQueryText   
            }
            saveHistory()
            tweets.removeAll()
            tableView.reloadData()
            refresh()
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //dynamic height for tableview cell
        tableView.estimatedRowHeight = tableView.rowHeight
        tableView.rowHeight = UITableView.automaticDimension
        
        //get tweets for search query
        refresh()
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        self.twitterQueryText = textField.text
        return true
    }
    
    // MARK: - Table view data source
    override func numberOfSections(in tableView: UITableView) -> Int {
        return self.tweets.count
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int{
        return self.tweets[section].count
    }
    
    //get tweets from tweitter and run it on a separate thread so it doesn't block main UI or thread
    private func refresh(){
        let request = TwitterRequest(search: self.twitterQueryText!, count: 20)
        DispatchQueue.main.async { () -> Void in
            request.fetchTweets { (tweets) -> Void in
                self.tweets.insert(tweets, at: 0)
                self.tableView.reloadData()
            }
        }
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let  CELL_IDENTIFIER = "tweetCell"
        let cell = tableView.dequeueReusableCell(withIdentifier: CELL_IDENTIFIER, for: indexPath) as! TweetTVCell
        cell.tweet = self.tweets[indexPath.section][indexPath.row]
        return cell
    }
 
    //header for section
    override func tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {
        return self.twitterQueryText!
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "tweetDetailVC"{
            if let destination =  segue.destination as? MentionTVC{
                
                //check for which row is clicked and get it's indexPath
                //get the tweet from the array using indexPath and assign it to destination VC
                if let index = self.tableView.indexPathForSelectedRow{
                    destination.tweet = tweets[index.section][index.row]
                }
            }
        }
    }

    //save each search query in UserDefaults
    func saveHistory(){
        let defaults = UserDefaults.standard
        var historyArray = [String]()
        
        //load old history in a temp array
        //remove last item from the array
        //add new search item in the array
        //store it back
        if let tempArray = defaults.object(forKey: "history") as? [String] {
            historyArray = tempArray
            if historyArray.count >= 100 {
                historyArray.removeLast()
            }
        }
        if( historyArray.last != twitterQueryText && twitterQueryText != "#ucd"){
             historyArray.append(twitterQueryText!)
        }
        defaults.set( historyArray, forKey: "history")
    }

}
