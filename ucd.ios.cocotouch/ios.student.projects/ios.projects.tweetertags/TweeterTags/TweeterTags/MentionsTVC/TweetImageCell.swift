//
//  TweetImageCell.swift
//  TweeterTags
//
//  Created by Gregoire Cousin on 06/03/2019.
//  Copyright © 2019 COMP47390-41550. All rights reserved.
//

import UIKit

class TweetImageCell: UITableViewCell {

    @IBOutlet weak var tweetImage: UIImageView!
    var aspectRatio = Double()
    
    var imageurl: URL? {
        didSet{
            self.showImage()
        }
    }
    
    func showImage(){
        self.tweetImage.load(url: imageurl!)
        tweetImage.frame = CGRect(x: 0, y: 0, width: self.frame.width, height: self.frame.width / CGFloat(aspectRatio))
        tweetImage.contentMode = UIView.ContentMode.scaleAspectFit
    }
    
    override func awakeFromNib() {
        super.awakeFromNib()
        //initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
        //configure the view for the selected state
    }

}
