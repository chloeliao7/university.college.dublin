/**
   This class provides methods to compute the volume and surface area of a cone.
*/
public class Cone
{
   private double r;
   private double h;

   /**
      Constructs a Cone object with input: radius and height.
      @param aRadius the radius
      @param aHeight the height
   */
   public Cone(double aRadius, double aHeight)
   {
      r = aRadius;
      h = aHeight;
   }

   /**
      Computes the volume of a cone.
      @return volume of a cone
    */
   public double getVolume()
   {
      return (1.0 / 3.0) * Math.PI * r * r * h;
   }

   /**
      Computes the surface area of a cone.
      @return surface area of a cone
    */
   public double getSurfaceArea()
   {
      /*
         Use Pythagorean's theorem to calculate the slant height
      */
      double s = Math.sqrt(r * r + h * h);
      return Math.PI * r * (r + s);
   }
}
