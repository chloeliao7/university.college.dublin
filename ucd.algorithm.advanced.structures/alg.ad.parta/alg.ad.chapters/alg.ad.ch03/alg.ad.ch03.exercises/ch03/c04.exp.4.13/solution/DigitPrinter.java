import java.util.Scanner;

/**
   This program prints the digits of a number in reverse order.
 */
public class DigitPrinter
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      
      System.out.print("Please enter a 5 digit integer: ");
      int digit = in.nextInt();

      DigitExtractor myExtractor = new DigitExtractor(digit);

      System.out.println(myExtractor.nextDigit());
      System.out.println(myExtractor.nextDigit());
      System.out.println(myExtractor.nextDigit());
      System.out.println(myExtractor.nextDigit());
      System.out.println(myExtractor.nextDigit());
   }
}

