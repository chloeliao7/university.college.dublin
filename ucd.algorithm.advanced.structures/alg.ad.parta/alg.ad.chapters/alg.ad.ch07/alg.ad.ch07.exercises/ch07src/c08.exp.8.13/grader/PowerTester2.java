/**
   This is a test driver for the intPower method.
*/
public class PowerTester2
{
   public static void main(String[] args)
   {
      System.out.println(Numeric.intPower(2, -5));
      System.out.println("Expected: 0.03125");
      System.out.println(Numeric.intPower(0, 10));
      System.out.println("Expected: 0");
      System.out.println(Numeric.intPower(-1, 3));
      System.out.println("Expected: -1");
   }
}
