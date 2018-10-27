/**
   This class tests the Purse class.
*/
public class PurseTester2
{
   public static void main(String[] args)
   {
      Purse p = new Purse();
      p.addCoin("Quarter");
      p.addCoin("Quarter");
      p.addCoin("Nickel");
      p.addCoin("Dime");
      
      System.out.println(p.toString());
      System.out.println("Expected: Purse[Quarter,Quarter,Nickel,Dime]");
   }
}
