/**
   This class tests the Purse class.
*/
public class PurseTester
{
   public static void main(String[] args)
   {
      Purse p = new Purse();
      p.addCoin("Quarter");
      p.addCoin("Dime");
      p.addCoin("Nickel");
      p.addCoin("Dime");
      
      System.out.println("Original purse: " + p.toString());
      System.out.println("Expected: Purse[Quarter,Dime,Nickel,Dime]");
      p.reverse();
      System.out.println("Reversed purse: " + p.toString());
      System.out.println("Expected: Purse[Dime,Nickel,Dime,Quarter]");
   }
}
