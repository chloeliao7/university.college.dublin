import java.util.Scanner;

/**
   This program calculates the exponential function.
*/
public class ExpCalculator
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.print("x: ");
      double x = in.nextDouble();
      double epsilon = 1E-12;

      ExpApproximator exp = new ExpApproximator(x, epsilon);

      while(exp.hasMoreGuesses())
         System.out.println(exp.nextGuess());
   }
}
