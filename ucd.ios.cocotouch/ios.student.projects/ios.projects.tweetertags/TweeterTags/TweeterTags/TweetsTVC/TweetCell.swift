//
//  TweetCell.swift
//  TweeterTags
//
//  Created by Gregoire Cousin on 04/03/2019.
//  Copyright © 2019 COMP47390-41550. All rights reserved.
//

import UIKit

class TweetTVCell: UITableViewCell {

    //single tweet object for each cell
    //when the tweet is assigned to this variable
    //it will run the showTweetInformation method
    var tweet: TwitterTweet? {
        didSet {
            showTweetInformation()
        }
    }
    
    @IBOutlet weak var profilePicture: UIImageView!
    @IBOutlet weak var screenName: UILabel!
    @IBOutlet weak var date: UILabel!
    @IBOutlet weak var tweetText: UILabel!

    override func awakeFromNib() {
        super.awakeFromNib()
        //initialization code
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
        //configure the view for the selected state
    }
    
    func showTweetInformation() {
        //check if tweet is not nil
        if let tweet = self.tweet {
            if let imageURL = tweet.user.profileImageURL {
                //load the image using extention function
                self.profilePicture?.load(url: imageURL)
            }
					
            //date formatter to show
            let formatter = DateFormatter()
					
            //check if it's in last 24 hours
            //if it is, show time liek this : 03:12pm
            //else show it like this : 3/4/19
            if Date().timeIntervalSince(tweet.created) > 24*60*60 {
                formatter.dateStyle = DateFormatter.Style.short
            } else {
                formatter.timeStyle = DateFormatter.Style.short
            }
            date?.text = formatter.string(from: tweet.created)
            
            //important
            self.screenName?.text = "\(tweet.user)"
            self.tweetText?.text = tweet.text
            
            //highlighting hashtag, url and mentions
            let hashtags = tweet.hashtags
            let urls = tweet.urls
            let mentions = tweet.userMentions
            
            //to highlight, swift uses nsmutableattributedstring
            //we get the range of each word we wanna highlight and perform some action
            //assign that attributed string to the tweettext.attributedtext
            let attributedString = NSMutableAttributedString(string:tweet.text)
            
            for hashtag in hashtags{
                let range = (tweet.text as NSString).range(of: hashtag.keyword)
                attributedString.addAttribute(NSAttributedString.Key.foregroundColor, value: UIColor.blue , range: range)
            }
            for url in urls{
                let range = (tweet.text as NSString).range(of: url.keyword)
                attributedString.addAttribute(NSAttributedString.Key.foregroundColor, value: UIColor.red , range: range)
            }
            for mention in mentions{
                let range = (tweet.text as NSString).range(of: mention.keyword)
                attributedString.addAttribute(NSAttributedString.Key.foregroundColor, value: UIColor.green , range: range)
            }
            tweetText?.attributedText = attributedString
            
        }

    }

}
