/**
   A DataSet computes the largest and smallest of a set of integers.
*/
public class DataSet
{
   private int smallest;
   private int largest;

   /**
      Constructs an empty data set.
   */
   public DataSet()
   {
      smallest = Integer.MAX_VALUE;
      largest = Integer.MIN_VALUE;
   }

   /**
      Compare the smallest and largest number to the input
      @param x the value to be compared
   */
   public void addValue(int x)
   {
      largest = Math.max(x, largest);
      smallest = Math.min(x, smallest);
   }

   /**
      Computes the largest of the values.
      @return the largest of the values
   */
   public int getLargest()
   {
      return largest;
   }

   /**
      Computes the smallest of the values.
      @return the smallest of the values
   */
   public int getSmallest()
   {
      return smallest;
   }
}
