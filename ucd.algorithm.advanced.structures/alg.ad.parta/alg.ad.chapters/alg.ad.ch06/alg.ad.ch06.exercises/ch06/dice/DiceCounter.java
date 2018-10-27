/**
   This class counts how often dice values occur.
*/
public class DiceCounter
{
   private int[] counters;

   /**
      Constructs a dice counter suitable for dice with a given number
      of sides.
      @param sides the number of sides of the dice to be counted
   */
   public DiceCounter(int sides)
   {
      counters = new int[sides + 1];
   }

   /**
      Adds a die value to this counter.
      @param value the value. Must be between 1 and the number of sides.
   */
   public void addValue(int value)
   {
      counters[value]++;
   }

   /**
      Displays all counts.
   */
   public void display()
   {
      for (int j = 1; j < counters.length; j++)
      {
         System.out.println(j + ": " + counters[j]);
      }
   }
}
