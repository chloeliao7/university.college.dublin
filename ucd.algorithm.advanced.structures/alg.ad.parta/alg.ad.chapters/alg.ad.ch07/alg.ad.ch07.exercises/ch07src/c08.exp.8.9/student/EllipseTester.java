import java.awt.geom.Ellipse2D;

/**
   This is a tester for the ellipse geometry methods.
*/
public class EllipseTester
{
   public static void main(String[] args)
   {
      Ellipse2D.Double e = new Ellipse2D.Double(100, 100, 200, 100);
      System.out.println("Area: " + Geometry.area(e));
      System.out.println("Expected: 15707.96326794896619231322");

      System.out.println("Perimeter: " + Geometry.perimeter(e));
      System.out.println("Expected: 484.42241102738376");
      // from http://www.jgiesen.de/kepler/arc/ellipseArc2.html
   }
}
