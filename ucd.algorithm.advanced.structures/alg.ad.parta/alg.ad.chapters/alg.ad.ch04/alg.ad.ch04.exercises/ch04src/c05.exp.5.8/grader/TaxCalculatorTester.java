import java.util.Scanner;

/**
   This program calculates taxes based on the original
   U.S. income tax schedule in 1913.
*/
public class TaxCalculatorTester
{
   public static void main(String[] args)
   {  
      double income = 600000;

      TaxReturn aTaxReturn = new TaxReturn(income);

      System.out.println("Tax: " + aTaxReturn.getTax());
      System.out.println("Expected: 26250");

      income = 1000;
      aTaxReturn = new TaxReturn(income);

      System.out.println("Tax: " + aTaxReturn.getTax());
      System.out.println("Expected: 10");

      income = 117000;
      aTaxReturn = new TaxReturn(income);

      System.out.println("Tax: " + aTaxReturn.getTax());
      System.out.println("Expected: 2430");
   }
}
