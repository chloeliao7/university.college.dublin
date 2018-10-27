import java.util.Scanner;

/**
   This program compares two military times and
   determines which comes first.
*/
public class TimeComparer
{
   public static void main(String[] args)
   {  
      Scanner in = new Scanner(System.in);

      System.out.println("Please enter the first time in military time (hour minute): ");
      int hour1 = in.nextInt();
      int minute1 = in.nextInt();

      System.out.println("Please enter the second time in military time (hour minute): ");
      int hour2 = in.nextInt();
      int minute2 = in.nextInt();
      
      Time time1 = new Time(hour1, minute1);
      Time time2 = new Time(hour2, minute2);
      
      String comp = time1.compareWith(time2);
      System.out.println("The first time is " + comp + " the second time.");      
   }
}
