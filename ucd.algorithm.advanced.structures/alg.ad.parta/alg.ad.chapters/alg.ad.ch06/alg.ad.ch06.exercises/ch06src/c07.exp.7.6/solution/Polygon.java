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
   private ArrayList<Point2D.Double> points;

   /**
      Constructs a polygon with no corner points.
   */
   public Polygon()
   {  
      points = new ArrayList<Point2D.Double>();
   }

   /**
      Adds a corner point to the polygon.
      @param x the x-coordinate of the point
      @param y the y-coordinate of the point
   */
   public void add(double x, double y)
   {  
      points.add(new Point2D.Double(x, y));
   }

   /**
      Calculates the perimeter of a polygon.
      @return the perimeter of this polygon
   */
   public double perimeter()
   {  
      double p = 0;
      int i;
      for (i = 0; i < points.size(); i++)
      {  
         Point2D.Double from = points.get(i);
         Point2D.Double to = points.get((i + 1) % points.size());
         p = p + distance(from, to);
      }
      return p;
   }

   /**
      Helper method to calculate the distance between two points.
      @param p the first point
      @param q the second point
      @return distance between two points
   */
   public static double distance(Point2D.Double p, Point2D.Double q)
   {  
      double dx = p.getX() - q.getX();
      double dy = p.getY() - q.getY();
      return Math.sqrt(dx * dx + dy * dy);
   }

   /**
      Calculates the area of a polygon.
      @return the area of this polygon
   */
   public double area()
   {  
      double a = 0;
      
      for (int i = 0; i < points.size(); i++)
      {  
         Point2D.Double from = points.get(i);
         Point2D.Double to = points.get((i + 1) % points.size());
         a = a + from.getX() * to.getY() - from.getY() * to.getX();
      }
      return 0.5 * Math.abs(a);
   }   
}
