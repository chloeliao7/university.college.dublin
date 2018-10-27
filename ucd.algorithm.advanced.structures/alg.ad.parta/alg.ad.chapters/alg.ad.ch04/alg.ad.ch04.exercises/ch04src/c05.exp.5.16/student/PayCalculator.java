import java.util.Scanner;

/**
   This program calculates the pay of an employee.
*/
public class PayCalculator
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      
      System.out.println("Hourly wage: ");
      double hourlyWage = in.nextDouble();

      System.out.println("Hours worked: ");
      double hours = in.nextDouble();

      PayCheck aPayCheck = new PayCheck(hourlyWage, hours);

      System.out.println("Pay: " + aPayCheck.getPay());
   }
}
