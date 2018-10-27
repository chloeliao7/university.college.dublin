/**
   This class implements the Newton-Raphson method to approximate the
   root of an input value.
*/
public class RootApproximator
{
   private double a;
   private int n;
   private double xOld;
   private double xNew;
   private double epsilon;
   private int count;

   /**
      Creates a RootApproximator object used to approximate the root of a number.
      @param a the value whose nth root is to be obtained
      @param n the root to be extracted
      @param eps the comparison threshold 
   */
   public RootApproximator(double a, int n, double eps)
   {
      this.a = a;
      this.n = n;
      xNew = 0;
      count = 0;
      epsilon = eps;
   }

   /**
      Method used to calculate the next root number.
      @return the next guess number
   */
   public double nextGuess()
   {
      xOld = xNew;
      if (count == 0) // first time
         xNew = 1;
      else
         xNew = xOld * (1 - 1.0 / n) + a / (n * Math.pow(xOld, n - 1));
      count++;
      return xNew;
   }

   /**
      Determine if there are more guesses.
      @return true we are close enough to the answer
   */
   public boolean hasMoreGuesses()
   {
      return count <= 2 || Math.abs(xNew - xOld) > epsilon;
   }
}
