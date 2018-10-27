import java.util.Scanner;

/**
   This program reads an eight digit credit card number and
   verifies the check digit.
*/
public class CreditCardCheck
{
   public static void main(String[] args)
   {  
      Scanner in = new Scanner(System.in);

      System.out.print("Enter 8 digit credit card number: ");
      int cardNumber;
      cardNumber = in.nextInt();

      /* 
         next add up every other digit, right to left
         for example: d8 d7 d6 d5 d4 d3 d2 d1
         add the digits d1 + d3 + d5 + d7
      */
      int sum1 = 0;
      int temp1 = cardNumber;

      for (int i = 1; i < 8; i += 2)
      {
         sum1 += temp1 % 10;
         temp1 /= 100;   // move left two digits, base ten
      }

      /*
         next double each of the digits not included in the previous step
         and add the digits of the resulting numbers.
         for example: d8 d7 d6 d5 d4 d3 d2 d1
         double each of the digits d2, d4, d6, and d8
         then add the individual digits of each number

         since the largest number possible is 18 (9 x 9), we can
         add digits d2 + d1
      */
      int sum2 = 0;
      int temp2 = cardNumber / 10;  // start with d2

      for (int i = 1; i < 8; i += 2)
      {
         int digit = (temp2 % 10) * 2;   // don't forget to double the value
         sum2 += digit % 10;   // the ones digit
         digit /= 10;
         sum2 += digit % 100;   // the tens digit
         temp2 /= 100;   // move left two digits, base ten
      }
 
      /*
         finally, add the sums together; if the last digit of the
         result is 0, then the number is valid, otherwise, print the
         the number that would make it valid.
      */
      int finalSum = sum1 + sum2;

      if (finalSum % 10 == 0)
         System.out.println("The credit card number is valid.");
      else
      {
         System.out.println("The credit card number is not valid.");
         System.out.println("The last digit should be " + ((cardNumber - finalSum + 10) % 10));
      }
   }
}
