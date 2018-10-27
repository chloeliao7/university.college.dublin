import java.util.Scanner;
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;

/**
   This is a test driver for the ellipse containment methods.
*/
public class EllipseTester2
{
   public static void main(String[] args)
   {
      Ellipse2D.Double e = new Ellipse2D.Double(0.5, 0.5, 2.0, 2.0);
      Point2D.Double p = new Point2D.Double(200, 100);
      System.out.println(Geometry.isOnBoundary(p, e));
      System.out.println("Expected: false");
      Point2D.Double q = new Point2D.Double(1, 1);
      System.out.println(Geometry.isInside(q, e));
      System.out.println("Expected: true");
   }
}
