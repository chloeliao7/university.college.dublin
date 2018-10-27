/**
   This class models a balloon.
*/
public class Balloon
{
   private double volume;

   /**
      Constructs an empty balloon.
   */
   public Balloon()
   {
      volume = 0;      
   }
   
   public void addAir(double amount) 
   {
      volume = volume + amount;
   }   

   /**
      Gets the volume of this balloon
      @return the current volume
   */
   public double getVolume()
   {
      return volume;
   }

   /**
      Gets the surface area of this balloon
      @return the current surface area
   */
   public double getSurfaceArea()
   {
      return 4 * Math.PI * Math.pow(getRadius(), 2);
   }
   
   /**
      Gets the radius of this balloon
      @return the current radius
   */
   public double getRadius()
   {
      return Math.pow(volume * 3 / 4 / Math.PI, 1.0/3);
   }
}
