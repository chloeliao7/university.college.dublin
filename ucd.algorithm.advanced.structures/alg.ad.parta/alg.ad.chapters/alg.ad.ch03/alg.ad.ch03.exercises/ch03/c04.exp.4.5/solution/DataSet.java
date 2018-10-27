/**
   A DataSet computes the total and average value of a collection of numbers.
*/
public class DataSet
{
   private int total;
   private int count;

   /**
      Constructs an empty data set.
   */
   public DataSet()
   {
      total = 0;
      count = 0;
   }

   /**
      Adds a value to this data set.
      @param x the value to be added
   */
   public void addValue(int x)
   {
      count++;
      total = total + x;
   }

   /**
      Computes the sum of the values.
      @return the sum of the values
   */
   public int getSum()
   {
      return total;
   }

   /**
      Computes the average of the values.
      @return the average of the values
   */
   public double getAverage()
   {
      return (double) (total) / count;
   }
}
