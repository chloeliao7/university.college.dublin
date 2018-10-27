/**
   This program tests the Balloon class.
 */
public class BalloonTester
{
   public static void main(String[] args)
   {
      Balloon myBalloon = new Balloon();

      System.out.println("Volume: " + myBalloon.getVolume());
      System.out.println("Expected: 0");

      System.out.println("Surface area: " + myBalloon.getSurfaceArea());
      System.out.println("Expected: 0");
      
      System.out.println("Radius: " + myBalloon.getRadius());
      System.out.println("Expected: 0");

      myBalloon.addAir(100);
      
      System.out.println("Volume: " + myBalloon.getVolume());
      System.out.println("Expected: 100");

      System.out.println("Surface area: " + myBalloon.getSurfaceArea());
      System.out.println("Expected: 104.1879415");
      
      System.out.println("Radius: " + myBalloon.getRadius());
      System.out.println("Expected: 2.8794119");
      
      myBalloon.addAir(100);
      
      System.out.println("Volume: " + myBalloon.getVolume());
      System.out.println("Expected: 200");

      System.out.println("Surface area: " + myBalloon.getSurfaceArea());
      System.out.println("Expected: 165.3880481");
      
      System.out.println("Radius: " + myBalloon.getRadius());
      System.out.println("Expected: 3.6278317");            
   }
}

