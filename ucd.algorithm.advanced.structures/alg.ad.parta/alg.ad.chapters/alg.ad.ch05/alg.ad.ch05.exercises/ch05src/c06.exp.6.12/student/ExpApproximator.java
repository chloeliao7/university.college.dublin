/**
   This class calculates e^x as a power series.
*/
public class ExpApproximator
{
   . . .

   /**
      Creates a ExpApproximator object to calculate e^x.
      @param x the input value
      @param eps the comparison threshold 
   */
   public ExpApproximator(double x, double eps)
   {
      . . .
   }

   /**
      Calculates the next approximation.
      @return the next approximation of e^x
   */
   public double nextGuess()
   {
      . . .
   }

   /**
      Checks whether a more precise approximation is available
      @return true if there is a more precise approximation
   */
   public boolean hasMoreGuesses()
   {
      . . .
   }
}
