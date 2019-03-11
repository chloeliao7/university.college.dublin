//
//  Utility.swift
//  TweeterTags
//
//  Created by Gregoire Cousin on 07/03/2019.
//  Copyright © 2019 COMP47390-41550. All rights reserved.
//

import Foundation
import UIKit


struct Section {
    var title : String
    var items : [CustomStringConvertible]
    
    init(title: String, items : [CustomStringConvertible]) {
        self.title = title
        self.items = items
    }
}


extension UIViewController{
    func getImage(url: URL , completion: @escaping (_ image: UIImage) -> Void) {
        DispatchQueue.global().async {
            if let data = try? Data(contentsOf: url) {
                if let image = UIImage(data: data) {
                    DispatchQueue.main.async {
                        completion(image)
                    }
                }
            }
        }
    }
}

extension UIImageView {
    func load(url: URL) {
        DispatchQueue.global().async { [weak self] in
            if let data = try? Data(contentsOf: url) {
                if let image = UIImage(data: data) {
                    DispatchQueue.main.async {
                        self?.image = image
                    }
                }
            }
        }
    }
}
