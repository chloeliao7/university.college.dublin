/**
   This class finds the smallest, middle, and largest of 
   three numbers.
*/
public class DataSet
{
   private double x1;
   private double x2;
   private double x3;

   /**
      Constructs a data set that processes three numbers.
      @param num1 the first number to sort
      @param num2 the second number to sort
      @param num3 the third number to sort
   */
   public DataSet(double num1, double num2, double num3)
   {
      x1 = num1;
      x2 = num2;
      x3 = num3;
   }

   /**
      Gets the smallest number in the data set.
      @return smallest the smallest of three numbers
   */
   public double getSmallest()
   {
      return Math.min(Math.min(x1, x2), x3);
   }

   /**
      Gets the largest number in the data set.
      @return largest the largest of three numbers
   */
   public double getLargest()
   {
      return Math.max(Math.max(x1, x2), x3);
   }

   /**
      Gets the middle number in the data set.
      @return middle the middle number of three numbers
   */
   public double getMiddle()
   {
      return x1 + x2 + x3 - getLargest() - getSmallest();
   }
}
