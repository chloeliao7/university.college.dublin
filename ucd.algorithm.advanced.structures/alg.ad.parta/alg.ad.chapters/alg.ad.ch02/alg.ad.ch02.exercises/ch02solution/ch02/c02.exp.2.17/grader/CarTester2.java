/**
   This program tests the Car class.
*/
public class CarTester2
{ 
   public static void main(String [] args)
   { 
      Car myBeemer = new Car(20); // 20 miles per gallon 
      
      myBeemer.addGas(20); 
      myBeemer.drive(100); // consumes 5 gallons
      System.out.println(myBeemer.getGasInTank());
      System.out.println("Expected: 15");        

      myBeemer.addGas(20); 
      myBeemer.drive(200); // consumes 10 gallons
      System.out.println(myBeemer.getGasInTank());
      System.out.println("Expected: 25");        
   } 
}
