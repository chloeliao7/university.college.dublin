import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
   A polygon is a closed curve made up from line segments
   that join the corner points.
*/
public class Polygon
{  
   . . .

   /**
      Constructs a polygon with no corner points.
   */
   public Polygon()
   {  
      . . .
   }

   /**
      Adds a corner point to the polygon.
      @param x the x-coordinate of the point
      @param y the y-coordinate of the point
   */
   public void add(double x, double y)
   {  
      . . .
   }

   /**
      Calculates the perimeter of a polygon.
      @return the perimeter of this polygon
   */
   public double perimeter()
   {  
      . . .
   }

   /**
      Calculates the area of a polygon.
      @return the area of this polygon
   */
   public double area()
   {  
      . . .
   }   
}
