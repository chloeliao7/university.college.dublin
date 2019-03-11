//
//  TweetImageVC.swift
//  TweeterTags
//
//  Created by Gregoire Cousin on 06/03/2019.
//  Copyright © 2019 COMP47390-41550. All rights reserved.
//

import UIKit

class TweetImageVC: UIViewController, UIScrollViewDelegate {
    
    private var imageView = UIImageView()

    //image to be shown in scrollview
    private var image: UIImage? {
        get {
            //return image in imageView
            return imageView.image
        }
        set {
            
            //set image in imageView
            imageView.image = newValue
            
            //resize the current imageview so that it uses the most appropriate amount of space
            imageView.sizeToFit()
            imageView.frame = CGRect(origin: CGPoint.zero, size: imageView.frame.size)
            scrollView?.contentSize = imageView.frame.size
        }
    }
    
    open var  imageURL: URL? {
        didSet {
            image = nil
            if view.window != nil {
                fetchImage()
            }
        }
    }
    
    //set contentsize of scrollview to the size of imageview
    //set delegate of scrollview to self
    @IBOutlet weak var scrollView: UIScrollView! {
        didSet {
            scrollView.contentSize = imageView.frame.size
            scrollView.delegate = self
        }
    }

    override func viewDidLayoutSubviews() {
        super.viewDidLayoutSubviews()
        
        //scrollview settings to set zoom scale for min and max values
        scrollView?.minimumZoomScale = min(0.2, scrollView.bounds.size.width / scrollView.contentSize.width)
        scrollView?.maximumZoomScale = 1.0
        scrollView?.zoomScale = scrollView.maximumZoomScale
    }
    
    func viewForZooming(in scrollView: UIScrollView) -> UIView? {
        return imageView
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        if image == nil {
            fetchImage()
        }
    }
    
    //fetch the image using extention function and assign it to self.image
    private func fetchImage() {
        if let url = imageURL {
            self.getImage(url: url, completion: { image in
                self.image = image
            })
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //add imageview to the subview of scrollview
        scrollView.addSubview(imageView)
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
}
