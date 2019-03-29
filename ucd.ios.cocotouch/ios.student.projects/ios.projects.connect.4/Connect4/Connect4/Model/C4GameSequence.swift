//
//  C4GameSequence.swift
//  Connect4
//
//  Created by Gregoire Cousin on 20/03/2019.
//  Copyright © 2019 UCD. All rights reserved.
//

import Foundation

class C4GameSequence: NSObject {
    var index = 0
    var action = 0
    var userType : C4GameUserType?
    
    init(index : Int , action : Int ,  userType : C4GameUserType) {
        super.init()
        self.index = index
        self.action = action
        self.userType = userType
    }
}
