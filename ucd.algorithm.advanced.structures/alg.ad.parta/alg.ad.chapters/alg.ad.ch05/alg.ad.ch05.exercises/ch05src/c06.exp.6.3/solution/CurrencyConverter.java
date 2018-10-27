import java.util.Scanner;

/**
   This program converts dollar to euros.
*/
public class CurrencyConverter
{
   public static void main (String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.print("How many euros is one dollar: ");
      double rate = in.nextDouble();

      boolean done = false;
      while (!done)
      {
         System.out.print("Dollar value (Q to quit): ");
         String input = in.next();
         if (input.equalsIgnoreCase("Q"))
            done = true;
         else
         {
            double amount = Double.parseDouble(input);

            double exchange = amount * rate;
            System.out.printf("%.2f dollar = %.2f euro\n", amount, exchange);
         }
      }
   }
}
