import java.util.Scanner;

/**
   This program calculates the season for a given month and day.
*/
public class Seasons
{  
   public static void main(String[] args)
   {  
      String season;
      Scanner in = new Scanner(System.in);

      System.out.print("Please enter a date (month and day): " );
      int month = in.nextInt();
      int day = in.nextInt();
      Season s = new Season(month, day);
      System.out.println("Season: " + s.getDescription());
   }
}
