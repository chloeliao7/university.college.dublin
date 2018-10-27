/**
   This class implements the Newton-Raphson method to approximate the
   nth root of an input value.
*/
public class RootApproximator
{
   . . .

   /**
      Creates a RootApproximator object used to approximate the root of a number.
      @param a the value whose nth root is to be obtained
      @param n the root to be extracted
      @param eps the comparison threshold 
   */
   public RootApproximator(double a, int n, double eps)
   {
      . . .
   }

   /**
      Method used to calculate the next root number.
      @return the next guess number
   */
   public double nextGuess()
   {
      . . .
   }

   /**
      Determine if there are more guesses.
      @return true we are close enough to the answer
   */
   public boolean hasMoreGuesses()
   {
      . . .
   }
}
