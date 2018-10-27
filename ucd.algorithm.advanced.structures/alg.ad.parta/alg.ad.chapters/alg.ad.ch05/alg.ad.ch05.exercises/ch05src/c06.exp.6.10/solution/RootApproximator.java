/**
   This class approximates the square root of a number.
*/
public class RootApproximator
{
   private double num;
   private double xOld;
   private double xNew;
   private double epsilon;
   private int count;

   /**
      Creates a RootApproximator object used to approximate the root of a number.
      @param aNum the number whose square root is being computed
      @param eps the comparison threshold 
   */
   public RootApproximator(double aNum, double eps)
   {
      num = aNum;
      epsilon = eps;
      xNew = 0;
      count = 0;
   }

   /**
      Method used to calculate the next root guess.
      @return the next guess number
   */
   public double nextGuess()
   {
      xOld = xNew;
      if (count == 0) // first time
         xNew = 1;
      else
         xNew = (xOld + (num / xOld)) / 2;
      count++;
      return xNew;
   }

   /**
      Determine if there are more guesses.
      @return true we are close enough to the answer
   */
   public boolean hasMoreGuesses()
   {
      return count <= 2 || (Math.abs(xNew - xOld) > epsilon);
   }
}
