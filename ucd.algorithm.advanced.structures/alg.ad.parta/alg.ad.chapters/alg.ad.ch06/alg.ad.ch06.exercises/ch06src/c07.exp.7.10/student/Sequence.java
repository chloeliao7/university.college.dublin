/**
   This class finds the longest "run", i.e., adjacent repeated values, 
   in a sequence.
*/
public class Sequence
{
   private int[] values;
   private int size;
   private int longestStart;
   private int longestSize;

   public Sequence(int capacity)
   {
      values = new int[capacity];
      size = 0;
   }

   public void add(int value)
   {
      if (size < values.length)
      {
         values[size] = value;
         size++;
      }
   }
   
   public int get(int index)
   {
       if (0 <= index && index < values.length) return values[index];
       else return 0;
   }

   /**
      Finds the longest run in a sequence and sets the longestStart
      and longestSize fields. If there are multiple runs of
      maximum length, the first one is found. Call getLongestStart
      and getLongestSize after calling findLongestRun.
   */
   public void findLongestRun()
   {
      . . .
   }
   
   /**
      Gets the start of the longest run. Call findLongestRun before
      calling this method.
      @return the start of the longest run, or -1 if there was no run
   */
   public int getLongestStart()
   {
      return longestStart;
   }
   
   /**
      Gets the size of the longest run. Call findLongestRun before
      calling this method.
      @return the size of the longest run, or 0 if there was no run
   */
   public int getLongestSize()
   {
      return longestSize;
   }
}
