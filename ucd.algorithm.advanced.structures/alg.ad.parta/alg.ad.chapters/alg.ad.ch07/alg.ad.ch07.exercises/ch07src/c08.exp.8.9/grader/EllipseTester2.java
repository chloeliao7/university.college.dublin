import java.awt.geom.Ellipse2D;

/**
   This is a tester for the ellipse geometry methods.
*/
public class EllipseTester2
{
   public static void main(String[] args)
   {
      Ellipse2D.Double e = new Ellipse2D.Double(0.5, 0.5, 2.0, 2.0);
      System.out.println("Area: " + Geometry.area(e));
     System.out.println("Expected: 3.141592653589793");

      System.out.println("Perimeter: " + Geometry.perimeter(e));
      System.out.println("Expected: 6.283185307179586");
   }
}
