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
      b.addCoin("Dime");
      b.addCoin("Nickel");      
      
      a.transfer(b);
      
      System.out.println(a.toString());
      System.out.println("Expected: Purse[Quarter,Dime,Nickel,Dime,Dime,Nickel]");
      System.out.println(b.toString());
      System.out.println("Expected: Purse[]");
   }
}
