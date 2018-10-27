import org.junit.Test;
import org.junit.Assert;

public class TaxReturnTest
{
   final double EPSILON = 1E-14;

   @Test public static void testSingleRate1()
   {
      int status = TaxReturn.SINGLE;
      double income = 10000.0;
      TaxReturn aTaxReturn = new TaxReturn(income, status);

      double expected = 1000.0;
      Assert.assertEquals(expected, aTaxReturn.getTax());
   }

   @Test public static void testSingleRate2()
   {
      int status = TaxReturn.SINGLE;
      double income = 52000.0;
      TaxReturn aTaxReturn = new TaxReturn(income, status);

      double expected = 8200.0;
      Assert.assertEquals(expected, aTaxReturn.getTax());
   }

   @Test public static void testMarriedRate2()
   {
      int status = TaxReturn.MARRIED;
      double income = 91000.0;
      TaxReturn aTaxReturn = new TaxReturn(income, status);

      double expected = 13150.0;
      Assert.assertEquals(expected, aTaxReturn.getTax());
   }

   public static void main (String[] args) {
      org.junit.runner.JUnitCore.runClasses(TaxReturnTest.class);
   }
}