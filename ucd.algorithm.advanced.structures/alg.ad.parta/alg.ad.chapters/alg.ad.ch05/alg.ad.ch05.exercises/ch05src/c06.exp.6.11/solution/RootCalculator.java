import java.util.Scanner;

/**
   This program calculates a nth root without calling Math.pow.
*/
public class RootCalculator
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.print("Please enter a number: ");
      double a = in.nextDouble();

      System.out.print("Extract which root? ");
      int n = in.nextInt();
      double epsilon = 1E-12;

      RootApproximator r = new RootApproximator(a, n, epsilon);

      while (r.hasMoreGuesses())
         System.out.println(r.nextGuess());
   }
}
