//
//  CDGameSequence+CoreDataProperties.swift
//  Connect4
//
//  Created by Gregoire Cousin on 22/03/2019.
//  Copyright © 2019 UCD. All rights reserved.
//

import Foundation
import CoreData


//
extension CDGameSequence {
    @nonobjc public class func fetchRequest() -> NSFetchRequest<CDGameSequence> {
        return NSFetchRequest<CDGameSequence>(entityName: "CDGameSequence")
    }

    @NSManaged public var action: Int64
    @NSManaged public var index: Int64
    @NSManaged public var userType: String
    @NSManaged public var session: CDGameSession?

}
