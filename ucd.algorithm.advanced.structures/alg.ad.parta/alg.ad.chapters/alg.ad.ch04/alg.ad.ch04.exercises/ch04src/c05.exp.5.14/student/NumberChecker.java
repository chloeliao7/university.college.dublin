import java.util.Scanner;

/**
   This program checks whether two floating-point numbers are almost the same.
*/
public class NumberChecker
{
   public static void main(String[] args)
   {
      Comparer c = new Comparer(2);
      Scanner in = new Scanner(System.in);
      
      System.out.println("Enter two floating-point numbers:");
      double x1 = in.nextDouble();
      double x2 = in.nextDouble();

      System.out.print("They are ");
      if (c.roundToSame(x1, x2))
         System.out.print("the same ");
      else
         System.out.print("different ");
      System.out.println("when rounded to two decimal places.");
      System.out.print("They differ by ");
      if (c.areClose(x1, x2))
         System.out.print("less than ");
      else
         System.out.print("at least ");
      System.out.println("0.01.");
   }
}
