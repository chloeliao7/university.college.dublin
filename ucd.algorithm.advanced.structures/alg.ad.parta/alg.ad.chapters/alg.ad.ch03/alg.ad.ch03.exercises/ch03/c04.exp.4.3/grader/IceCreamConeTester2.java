/**
   This program tests the IceCreamCone class.
*/
public class IceCreamConeTester2
{ 
   public static void main(String[] args)
   {  
      IceCreamCone c = new IceCreamCone(15, 3);
      
      System.out.print("volume: ");
      System.out.println(c.getVolume());
      System.out.println("Expected: 141.3716694115407");
      System.out.print("surfaceArea: ");
      System.out.println(c.getSurfaceArea());
      System.out.println("Expected: 144.17138019972685");
   }
}

