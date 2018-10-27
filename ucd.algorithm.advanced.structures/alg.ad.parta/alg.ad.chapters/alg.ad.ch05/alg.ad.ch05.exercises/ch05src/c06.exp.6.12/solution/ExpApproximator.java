/**
   This class calculates e^x as a power series.
*/
public class ExpApproximator
{
   private double x;
   private double summand;
   private int i;
   private double total;
   private double epsilon;

   /**
      Creates a ExpApproximator object to calculate e^x.
      @param x the input value
      @param eps the comparison threshold 
   */
   public ExpApproximator(double x, double eps)
   {
      this.x = x;
      summand = 1;
      i = 0;
      total = 0;
      epsilon = eps;
   }

   /**
      Calculates the next approximation.
      @return the next approximation of e^x
   */
   public double nextGuess()
   {
      if (i > 0) summand = summand * x / i;
      i++;
      total = total + summand;
      return total;
   }

   /**
      Checks whether a more precise approximation is available
      @return true if there is a more precise approximation
   */
   public boolean hasMoreGuesses()
   {
      return summand > epsilon;
   }
}
