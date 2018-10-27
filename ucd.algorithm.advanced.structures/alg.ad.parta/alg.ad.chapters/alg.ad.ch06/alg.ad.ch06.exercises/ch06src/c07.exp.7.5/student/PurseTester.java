/**
   This class tests the Purse class.
*/
public class PurseTester
{
   public static void main(String[] args)
   {
      Purse a = new Purse();
      a.addCoin("Quarter");
      a.addCoin("Dime");
      a.addCoin("Nickel");
      a.addCoin("Dime");        
      
      Purse b = new Purse();    
      b.addCoin("Nickel");
      b.addCoin("Dime");   
      b.addCoin("Dime");      
      b.addCoin("Quarter"); 
      
      System.out.println(a.sameCoins(b));
      System.out.println("Expected: true");
             
      Purse c = new Purse();
      c.addCoin("Quarter");
      c.addCoin("Penny");
      c.addCoin("Nickel");
      c.addCoin("Dime");        
      
      Purse d = new Purse();    
      d.addCoin("Nickel");
      d.addCoin("Dime");   
      d.addCoin("Dime");         
      d.addCoin("Quarter");

      System.out.println(c.sameCoins(d));
      System.out.println("Expected: false");
   }
}
