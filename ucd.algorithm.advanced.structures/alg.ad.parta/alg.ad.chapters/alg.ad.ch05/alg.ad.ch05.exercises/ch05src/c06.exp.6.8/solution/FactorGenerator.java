/**
   This class generates all the factors of a number.
*/
public class FactorGenerator
{
   private int num;
   private int factor;

   /**
      Creates a FactorGenerator object used to determine the factor of
      an input value.
      @param aNum is the input value
   */
   public FactorGenerator(int aNum)
   {
      num = aNum;
      factor = 2;
   }

   /**
      Determine whether or not there are more factors.
      @return true there are more factors
   */
   public boolean hasMoreFactors()
   {
      while (factor <= num && num % factor != 0)
         factor++;
      return factor <= num;
   }

   /**
      Calculate the next factor of a value.
      @return factor the next factor
   */
   public int nextFactor()
   {
      if (!hasMoreFactors())
         return 1;
      num = num / factor;
      return factor;
   }
}
