/**
   This program tests the SodaCan class.
 */
public class SodaCanTester
{
   public static void main(String[] args)
   {
      SodaCan mySodaCan = new SodaCan(10, 3);

      System.out.println("Volume: " + mySodaCan.getVolume());
      System.out.println("Expected: 70.6858347");

      System.out.println("Surface area: " + mySodaCan.getSurfaceArea());
      System.out.println("Expected: 108.3849465");
   }
}

