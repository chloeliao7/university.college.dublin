import java.util.Scanner;

/**
   This program calculates a simple tax return.
*/
public class TaxCalculator
{  
   public static void main(String[] args)
   {  
      Scanner in = new Scanner(System.in);

      System.out.println("Please enter your income: ");
      double income = in.nextDouble();

      System.out.println("Are you married? (Y/N)");
      String input = in.next();
      int status;
      if (input.equalsIgnoreCase("Y")) 
         status = TaxReturn.MARRIED;
      else  
         status = TaxReturn.SINGLE;

      TaxReturn aTaxReturn = new TaxReturn(income, status);

      System.out.println("Tax: " + aTaxReturn.getTax());
   }
}
