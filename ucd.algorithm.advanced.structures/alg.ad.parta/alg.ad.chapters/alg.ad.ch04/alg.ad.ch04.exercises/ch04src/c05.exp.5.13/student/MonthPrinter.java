import java.util.Scanner;

/**
   This program prints the months in a given year.
*/
public class MonthPrinter
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);      
      System.out.println("Enter a month (1-12):");
      int month = in.nextInt();
      Month m = new Month(month);
      int days = m.getDays();
      System.out.println(days + " days");
   }
}
