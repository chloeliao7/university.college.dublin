import java.util.Scanner;

/**
   This program calculates a square root without calling Math.sqrt.
*/
public class RootCalculator
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter a number that you want a square root of: ");
      double a = in.nextDouble();
      final double EPSILON = 1E-12;
      
      RootApproximator r = new RootApproximator(a, EPSILON);

      while (r.hasMoreGuesses())
         System.out.println(r.nextGuess());      
   }
}
