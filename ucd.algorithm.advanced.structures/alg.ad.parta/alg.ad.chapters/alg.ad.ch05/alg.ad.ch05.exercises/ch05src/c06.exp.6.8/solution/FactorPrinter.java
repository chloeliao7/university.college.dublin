import java.util.Scanner;

/**
   Prints the factors of an integer.
*/
public class FactorPrinter
{
   public static void main (String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter an integer: ");
      int num = in.nextInt();

      FactorGenerator generator = new FactorGenerator(num);

      while (generator.hasMoreFactors())
         System.out.println(generator.nextFactor());
   }
}
