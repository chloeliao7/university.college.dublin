/**
   Class used to generate a Fibonacci number with a given input.
*/
public class FibonacciGenerator
{
   private int fOld1;
   private int fOld2;
   private int fNew;

   /**
      Construct a FibonacciGenerator object to generate a Fibonacci number.
   */
   public FibonacciGenerator()
   {
      fOld1 = 1;
      fOld2 = 1;
      fNew = 1;
   }

   /**
      Method used to calculate a fibonacci number.
      @return fNew the fibonacci number
   */
   public int nextNumber()
   {
      int r = fOld2;
      fNew = fOld1 + fOld2;

      fOld2 = fOld1;
      fOld1 = fNew;

      return r;
   }
}
