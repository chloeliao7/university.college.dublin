import java.util.Scanner;

public class Dice
{
   public static void main(String[] args)
   {
      int[] counters = countInputs(6);
      printCounters(counters);
   }

   /**
      Reads a sequence of die toss values between 1 and sides (inclusive) 
      and counts how frequently each of them occurs.
      @return an array whose ith element contains the number of 
      times the value i occurred in the input. The 0 element is unused.
   */
   public static int[] countInputs(int sides)
   {
      int[] counters = new int[sides + 1];

      System.out.println("Please enter values, Q to quit:");
      Scanner in = new Scanner(System.in);
      while (in.hasNextInt())
      {  
         int value = in.nextInt();
         if (1 <= value && value <= sides)
         {
            counters[value]++;
         }
         else
         {
            System.out.println(value + " is not a valid input.");
         }
      }
      return counters;
   }

   /**
      Prints a table of die value counters.
      @param counters an array of counters.
      counters[0] is not printed.
   */
   public static void printCounters(int[] counters)
   {
      for (int j = 1; j < counters.length; j++)
      {
         System.out.println(j + ": " + counters[j]);
      }
   }
}

