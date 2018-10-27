/**
   This program tests the IceCreamCone class.
*/
public class IceCreamConeTester
{ 
   public static void main(String[] args)
   {  
      IceCreamCone c = new IceCreamCone(5, 1);
      
      System.out.print("Volume: ");
      System.out.println(c.getVolume());
      System.out.println("Expected: 5.235987755982989");
      System.out.print("Surface area: ");
      System.out.println(c.getSurfaceArea());
      System.out.println("Expected: 16.01904224441409");
   }
}

