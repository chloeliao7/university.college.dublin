//
//  CDGameSession+CoreDataProperties.swift
//  Connect4
//
//  Created by Gregoire Cousin on 22/03/2019.
//  Copyright © 2019 UCD. All rights reserved.
//

import Foundation
import CoreData

extension CDGameSession {
    @nonobjc public class func fetchRequest() -> NSFetchRequest<CDGameSession> {
        return NSFetchRequest<CDGameSession>(entityName: "CDGameSession")
    }

    @NSManaged public var winningSequence: [Int]
    @NSManaged public var wonBy: String
    @NSManaged public var sequence: NSSet
}

// MARK: Generated accessors for sequence
extension CDGameSession {
    @objc(addSequenceObject:)
    @NSManaged public func addToSequence(_ value: CDGameSequence)

    @objc(removeSequenceObject:)
    @NSManaged public func removeFromSequence(_ value: CDGameSequence)

    @objc(addSequence:)
    @NSManaged public func addToSequence(_ values: NSSet)

    @objc(removeSequence:)
    @NSManaged public func removeFromSequence(_ values: NSSet)

}
