/**
   This class gives the volume and surface area of a soda can.
*/
public class SodaCan
{
   private double radius;
   private double height;

   /**
      Construct a SodaCan.
      @param aHeight the height of the soda can
      @param aDiameter the diameter of the soda can
   */
   public SodaCan(double aHeight, double aDiameter)
   {
      height = aHeight;
      radius = aDiameter / 2;
   }

   /**
      Gets the volume of a soda can.
      @return volume of the soda can
   */
   public double getVolume()
   {
      return Math.PI * radius * radius * height;
   }

   /**
      Gets the surface area of a soda can.
      @return surface area of the soda can
   */
   public double getSurfaceArea()
   {
      return 2 * Math.PI * radius * (radius + height);
   }
}
