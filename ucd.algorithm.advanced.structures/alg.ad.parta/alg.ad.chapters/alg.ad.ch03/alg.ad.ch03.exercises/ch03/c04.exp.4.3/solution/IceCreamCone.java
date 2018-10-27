/**
   An ice cream cone is a conical object with a given
   height and radius.
*/
class IceCreamCone
{  
   private double height;
   private double radius;

   /**
      Constructs a IceCreamCone object.
      @param h the height of the cone
      @param r the radius of the cone
   */
   public IceCreamCone(double h, double r)
   {  
      height = h;
      radius = r;
   }

   /**
      Gets the surface area of the cone.
      @return the surface area (of the outside only)
   */
   public double getSurfaceArea()
   {  
      return Math.PI * radius * Math.sqrt(radius * radius + height * height);
   }

   /**
      Gets the volume of the cone.
      @return the volume
   */
   public double getVolume()
   {  
      return (Math.PI * radius * radius * height) / 3;
   }
}

