public class PowerGenerator
{
   private double current;
   private double factor;

   /**
      Constructs a power generator.
      @param aFactor the number that will be multiplied by itself
   */
   public PowerGenerator(int aFactor) 
   { 
      current = 1;
      factor = aFactor;
   }

   /**
      Computes the next power.
   */
   public double nextPower() 
   { 
      double r = current;
      current = current * factor;
      return r;
   }   
}
