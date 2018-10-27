/**
   This class tests the Purse class.
*/
public class PurseTester2
{
   public static void main(String[] args)
   {
      Purse a = new Purse();
      a.addCoin("Quarter");
      a.addCoin("Quarter");
      a.addCoin("Nickel");
      a.addCoin("Dime");
      
      Purse b = new Purse();
      b.addCoin("Dime");
      b.addCoin("Nickel");      
      
      b.transfer(a);
      
      System.out.println(a.toString());
      System.out.println("Expected: Purse[]");
      System.out.println(b.toString());
      System.out.println("Expected: Purse[Dime,Nickel,Quarter,Quarter,Nickel,Dime]");

   }
}
