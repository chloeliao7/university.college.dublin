import java.util.Random;

/**
   This class generates randon die tosses and prints the longest
   run, by including it in parentheses.

   For example:
      1 2 5 5 3 1 2 4 3 (2 2 2 2) 3 6 6 6 6 3 1
*/
public class DieSequencePrinter
{
   public static void main(String[] args)
   {
      final int TOSSES = 20;
      Random die = new Random();
      Sequence seq = new Sequence(TOSSES);

      /* fill the array with random die tosses */
      for (int i = 1; i <= TOSSES; i++)
      {
         seq.add(. . .);
      }
      
      seq.findLongestRun();
      int start = seq.getLongestStart();
      int size = seq.getLongestSize();
      
      // Print the longest run
      . . .
   }
}
