import java.awt.geom.Point2D;

/**
   This program tests the methods to compute the slope and
   angle of a line.
*/
public class LineTester2
{
   public static void main(String[] args)
   {
      Point2D.Double p = new Point2D.Double(10, 10);
      Point2D.Double q = new Point2D.Double(5, 2);

      System.out.println("Slope: " + Geometry.slope(p, q));
      System.out.println("Expected: 1.6");

      Point2D.Double r = new Point2D.Double(3, -1);

      System.out.println("Angle: " + Geometry.angle(p, r));
      System.out.println("Expected: -122.47119229084849");

      p = new Point2D.Double(5, 10);
      q = new Point2D.Double(10, 2);

      System.out.println("Slope: " + Geometry.slope(p, q));
      System.out.println("Expected: -1.6");

      r = new Point2D.Double(3, -1);

      System.out.println("Angle: " + Geometry.angle(p, r));
      System.out.println("Expected: -100.30484646876603");
   }
}

