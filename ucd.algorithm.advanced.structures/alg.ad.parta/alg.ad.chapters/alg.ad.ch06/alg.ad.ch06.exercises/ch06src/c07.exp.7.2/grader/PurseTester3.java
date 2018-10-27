/**
   This class tests the Purse class.
*/
public class PurseTester3
{
   public static void main(String[] args)
   {
      Purse p = new Purse();
      p.addCoin("Quarter");
      p.addCoin("Quarter");
      p.addCoin("Nickel");
      p.addCoin("Dime");
      p.addCoin("Half Dollar");
      p.addCoin("Penny");
      p.addCoin("Penny");
      p.addCoin("Penny");
      
      System.out.println("Original purse: " + p.toString());
      System.out.println("Expected: Purse[Quarter,Quarter,Nickel,Dime,Half Dollar,Penny,Penny,Penny]");
      p.reverse();
      System.out.println("Reversed purse: " + p.toString());
      System.out.println("Expected: Purse[Penny,Penny,Penny,Half Dollar,Dime,Nickel,Quarter,Quarter]");

    }
}
