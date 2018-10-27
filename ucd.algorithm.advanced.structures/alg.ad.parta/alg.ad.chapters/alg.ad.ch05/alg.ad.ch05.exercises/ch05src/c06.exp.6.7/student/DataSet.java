/**
   This class is used to calculate the average and standard deviation
   of a data set.
*/
public class DataSet
{
   private double sum;
   private double sumSquare;
   private int n;

   /**
      Constructs a DataSet object to hold the total number of inputs,
      the sum, and the sum of square.
   */
   public DataSet()
   {
      . . .
   }

   /**
      Adds a value to this data set.
      @param x the input value
   */
   public void add(double x)
   {
      sum = sum + x;
      sumSquare = sumSquare + x * x;
      n++;
   }

   /**
      Method used to calculate the average of the data set.
      @return average the average of the data set
   */
   public double getAverage()
   {
      . . .
   }

   /**
      Method used to calculate the standard deviation.
      @return stddev the standard deviation of data set
   */
   public double getStandardDeviation()
   {
      . . .
   }

   /**
      Gets the total number of input values.
      @return n the total number of inputs
   */
   public int getCount()
   {
      . . .
   }
}
