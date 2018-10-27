import java.util.Scanner;

public class DiceAnalyzer
{
   public static void main(String[] args)
   {
      final int SIDES = 6;
      DiceCounter counter = new DiceCounter(SIDES);
      System.out.println("Please enter values, Q to quit:");
      Scanner in = new Scanner(System.in);
      while (in.hasNextInt())
      {  
         int value = in.nextInt();
         if (1 <= value && value <= SIDES)
         {
            counter.addValue(value);
         }
         else
         {
            System.out.println(value + " is not a valid input.");
         }
      }
      counter.display();
   }
}
