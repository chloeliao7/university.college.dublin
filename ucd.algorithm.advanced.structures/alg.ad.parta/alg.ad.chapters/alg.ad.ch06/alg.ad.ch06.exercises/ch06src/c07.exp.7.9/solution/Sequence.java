/**
   This class marks "runs", i.e., adjacent repeated values, by
   including them in parenthesis.

   For example:
      1 2 (5 5) 3 1 2 4 3 (2 2 2 2) 3 6 (5 5) 6 3 1
*/
public class Sequence
{
   private int[] values;
   private int size;

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

   /**
      Returns the string of values, with runs enclosed in parentheses.
      @return the string of values with the runs marked, for example 
      "1 2 (5 5) 3 1 2 4 3 (2 2 2 2) 3 6 (5 5) 6 3 1"
   */
   public String markRuns()
   {
      /* keeps track of when we are in the middle of a sequence */
      boolean inRun = false;
      String r = "";
      /* look for runs of numbers */
      for (int i = 0; i < values.length; i++)
      {
         if (inRun)
         {
            if (values[i] != values[i - 1])
            {
               r = r + ")";
               inRun = false;
            }
         }
         if (i > 0) r = r + " ";
         if (!inRun)
         {
            if (i < values.length - 1 && values[i] == values[i + 1])
            {
               r = r + "(";
               inRun = true;
            }
         }
         r = r + values[i];
      }

      /* check for possible final run */
      if (inRun)
         r = r + ")";
      return r;
   }
}
