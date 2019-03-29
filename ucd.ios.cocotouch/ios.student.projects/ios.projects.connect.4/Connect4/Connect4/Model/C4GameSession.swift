//
//  C4GameSession.swift
//  Connect4
//
//  Created by Gregoire Cousin on 20/03/2019.
//  Copyright © 2019 UCD. All rights reserved.
//

import Foundation
import CoreData
import UIKit

class C4GameSession: NSObject {
    var wonBy : C4GameUserType?
    var sequence = [C4GameSequence]()
    var winningSequence = [Int]()
    
    override init(){
        super.init()
    }
    
    func addSequence(index : Int , action : Int , userType : C4GameUserType){
        let sequence = C4GameSequence(index: index, action: action , userType : userType)
        print("\(sequence.index) ---- \(sequence.action) ---- \(sequence.userType!.rawValue)")
        self.sequence.append(sequence)
    }
    
    func saveSession(wonBy : C4GameUserType ,  winningSequence : [Int]){
        self.wonBy = wonBy
        self.winningSequence = winningSequence

        for seq in self.sequence{
            print("\(seq.index) ---- \(seq.action)")
        }
        self.saveSession()
    }
    
    func saveSession(){
        
        //as we know that container is set up in the appdelegates so we need to refer that container.
        guard let appDelegate = UIApplication.shared.delegate as? AppDelegate else { return }
        
        //we need to create a context from this container
        let managedContext = appDelegate.persistentContainer.viewContext
        
        //now let’s create an entity and new user records.
        let sessionEntity = NSEntityDescription.entity(forEntityName: "CDGameSession", in: managedContext)!
        let sequenceEntity = NSEntityDescription.entity(forEntityName: "CDGameSequence", in: managedContext)!
        
        //final, we need to add some data to our newly created record for each keys using
        //here adding 5 data with loop
        let session = NSManagedObject(entity: sessionEntity, insertInto: managedContext) as! CDGameSession
        session.wonBy = self.wonBy!.rawValue
        session.winningSequence = self.winningSequence
        session.sequence = []
        
        var sequenceArray = [CDGameSequence]()
        for singleSequence in self.sequence{
            let sequenceData = NSManagedObject(entity: sequenceEntity, insertInto: managedContext) as! CDGameSequence
            sequenceData.action = Int64(singleSequence.action)
            sequenceData.index = Int64(singleSequence.index)
            sequenceData.userType = singleSequence.userType!.rawValue
            sequenceArray.append(sequenceData)
        }
        
        session.sequence = NSSet(array: sequenceArray)

        //now we have set all the values. the next step is to save them inside the core data
        do {
            try managedContext.save()
        } catch let error as NSError {
            print("Could not save. \(error), \(error.userInfo)")
        }
    }
    
    class func getAllSessions() -> [C4GameSession]{
        //as we know that container is set up in the appdelegates so we need to refer that container.
        guard let appDelegate = UIApplication.shared.delegate as? AppDelegate else { return [] }
        
        //we need to create a context from this container
        let managedContext = appDelegate.persistentContainer.viewContext
        let fetchRequest = NSFetchRequest<NSFetchRequestResult>(entityName: "CDGameSession")
        var c4GameSessions = [C4GameSession]()
        
        do {
            let result = try managedContext.fetch(fetchRequest)
            print("Complete")
            
            for data in result as! [NSManagedObject] {
                let session = data as! CDGameSession
                let c4GameSession = C4GameSession.convertCoreDataToClass(session: session)
                c4GameSessions.append(c4GameSession)
            }
        } catch {
           print("Could not save. \(error))")
        }
        return c4GameSessions
    }
    
    func resetSession(){
        self.sequence.removeAll()
        self.winningSequence.removeAll()
        self.wonBy = nil
    }
    
    func sessionHistory(){}
    
    class func convertCoreDataToClass(session : CDGameSession) -> C4GameSession{
        let gameSession = C4GameSession()
        gameSession.wonBy = C4GameUserType.convert(value: session.wonBy)
        gameSession.winningSequence = session.winningSequence
        
        let sequences = (session.sequence.allObjects as! [CDGameSequence]).sorted(by: { $0.index < $1.index })
        sequences.enumerated().forEach({ (index , sequence) in //print("sequence index - \(sequence.index)")
            let gameSequence = C4GameSequence(index: Int(sequence.index), action: Int(sequence.action + 1), userType: C4GameUserType.convert(value: sequence.userType))
            gameSession.sequence.append(gameSequence)
        })
        return gameSession
    }
    
}
