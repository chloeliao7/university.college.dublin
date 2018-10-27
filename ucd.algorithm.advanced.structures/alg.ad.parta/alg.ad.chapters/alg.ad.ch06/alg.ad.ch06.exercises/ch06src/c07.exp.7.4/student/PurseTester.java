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
      
      Purse b = new Purse();
      b.addCoin("Quarter");
      b.addCoin("Dime");
      
      System.out.println(a.sameContents(b));
      System.out.println("Expected: true");
      
      Purse c = new Purse();      
      c.addCoin("Nickel");
      c.addCoin("Dime");
      c.addCoin("Nickel");
      
      Purse d = new Purse();      
      d.addCoin("Nickel");
      d.addCoin("Dime");
      d.addCoin("Quarter");
      
      System.out.println(c.sameContents(d));
      System.out.println("Expected: false");

      Purse e = new Purse();      
      e.addCoin("Nickel");
      e.addCoin("Dime");
      e.addCoin("Nickel");
      
      Purse f = new Purse();      
      f.addCoin("Nickel");
      f.addCoin("Dime");
      
      System.out.println(e.sameContents(f));
      System.out.println("Expected: false");
   }
}
