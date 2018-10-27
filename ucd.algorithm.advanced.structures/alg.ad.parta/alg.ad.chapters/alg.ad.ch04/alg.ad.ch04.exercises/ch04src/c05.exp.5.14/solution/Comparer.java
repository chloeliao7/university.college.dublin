/**
   This class is used to test whether two floating-point numbers are the same.
*/
public class Comparer
{
   private int digits;

   /**
      Creates a Comparer object to determine if two floating-point numbers
      are approximately the same.
      @param d the number of significant digits in the comparison
   */
   public Comparer(int d)
   {
      digits = d;
   }

   /**
      Tests whether two numbers are close to each other.
      @param x1 the first number
      @param x2 the second number
      @return true if the two numbers differ by less than the number of
      significant digits
   */
   public boolean areClose(double x1, double x2)
   {
      double diff = Math.abs(x1 - x2);
      return diff < Math.pow(0.1, digits);
   }
   
   /**
      Tests whether two numbers round to the same value.
      @param x1 the first number
      @param x2 the second number
      @return true if the two numbers, when rounded to the number of 
      significant digits, yield the same value 
   */
   public boolean roundToSame(double x1, double x2)
   {
      double scale = Math.pow(10, digits);
      return Math.round(scale * x1) == Math.round(scale * x2);
   }
}
