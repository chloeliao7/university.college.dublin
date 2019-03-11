//
//  MentionTVC.swift
//  TweeterTags
//
//  Created by Gregoire Cousin on 06/03/2019.
//  Copyright © 2019 COMP47390-41550. All rights reserved.
//

import UIKit

class MentionTVC: UITableViewController {
    
    //section array which stores information using custom Section struct
    var sections: [Section] = []
    
    //tweet coming from search VC in prepareforsegue
    var tweet: TwitterTweet!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //dynamic height for tableview cell
        tableView.estimatedRowHeight = tableView.rowHeight
        tableView.rowHeight = UITableView.automaticDimension
        
        //title as screenname of user
        self.title = "@" + tweet.user.screenName
        
        //check for each sesion in main tweet and append section if it's available
        //this is to reduce complexity in cellForRow
        if !tweet.media.isEmpty {
            sections.append(Section(title: "Images", items: tweet.media))
        }
        if !tweet.urls.isEmpty {
            sections.append(Section(title: "URLs", items: tweet.urls))
        }
        if !tweet.hashtags.isEmpty{
            sections.append(Section(title: "Hashtags", items: tweet.hashtags))
        }
        if !tweet.userMentions.isEmpty {
            sections.append(Section(title: "Users", items: tweet.userMentions))
        }
    }
    
    // MARK: - Table view data source
    override func numberOfSections(in tableView: UITableView) -> Int {
        return sections.count
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return sections[section].items.count
    }
    
    override func tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {
        return sections[section].title
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let section = sections[indexPath.section]
        
        //check if the section is for Imges, then show the image
        //otherwise show the urls,hashtags and mentions for each section
        if section.title == "Images" {
            let cell = tableView.dequeueReusableCell(withIdentifier: "imageCell", for: indexPath) as! TweetImageCell
            let media = section.items[indexPath.row] as! TwitterMedia
            
            //aspect ratio to show image without cutting it
            cell.aspectRatio = media.aspectRatio
            
            //assign image to be shown
            cell.imageurl = media.url
            
            return cell
        }
        else {
            let cell = tableView.dequeueReusableCell(withIdentifier: "sectionCell", for: indexPath)
            let mentions = section.items[indexPath.row] as! TwitterMention
            cell.textLabel?.text = mentions.keyword
            return cell
        }
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        
        //check if the title is not images
        //if not, then either open urls or search screen based on what user clicks on
        if(sections[indexPath.section].title != "Images"){
            
            let selectedText = sections[indexPath.section].items[indexPath.row] as! TwitterMention
            //check if the cell clicked has a URL in it
            //if it is, open safari with the URL
            //otherwise segue to the search screen
            if(sections[indexPath.section].title == "URLs"){
                guard let url = URL(string: selectedText.keyword) else { return }
                UIApplication.shared.open(url)
            }
            else{
                self.performSegue(withIdentifier: "searchTweetVC", sender: self)
                self.tableView.deselectRow(at: indexPath, animated: true)
            }
        }
        
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        
        //check for relevant segue Identifier and send the information to the desitnation VC
        if segue.identifier == "tweetImageVC"{
            if let destination = segue.destination as? TweetImageVC{
                let indexPath = IndexPath(row: 0, section: 0)
                let cell = self.tableView.cellForRow(at: indexPath) as! TweetImageCell
                destination.imageURL = cell.imageurl
                destination.title = "@" + tweet.user.screenName
            }
        }
        
        if segue.identifier == "searchTweetVC"{
            if let destination = segue.destination as? TweetsTVC{
                if let index = self.tableView.indexPathForSelectedRow{
                    let selectedText = sections[index.section].items[index.row] as! TwitterMention
                    destination.twitterQueryText = selectedText.keyword
                }
            }
        }
    }
    
}
