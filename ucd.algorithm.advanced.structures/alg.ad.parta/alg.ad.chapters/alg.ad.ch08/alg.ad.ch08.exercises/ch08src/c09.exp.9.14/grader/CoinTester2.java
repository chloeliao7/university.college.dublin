/**
   This program tests the use of the Comparable interface
   in the coin class.
*/
public class CoinTester2
{  
   public static void main(String[] args)
   {  
      Coin c1 = new Coin(0.05, "nickel");
      Coin c2 = new Coin(0.01, "penny");

      int b = c2.compareTo(c1);
      
      if (b < 0)
         System.out.println("less");
      else if (b > 0)
         System.out.println("more");
      else
         System.out.println("equal");
      System.out.println("Expected: less");
      
      b = c2.compareTo(c2);
      
      if (b < 0)
         System.out.println("less");
      else if (b > 0)
         System.out.println("more");
      else
         System.out.println("equal");
      System.out.println("Expected: equal");
   }
}
