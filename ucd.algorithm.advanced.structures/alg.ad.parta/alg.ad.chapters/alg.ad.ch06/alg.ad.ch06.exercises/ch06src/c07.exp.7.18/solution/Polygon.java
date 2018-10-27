import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
   A polygon is a closed curve made up from line segment
   that join the corner points.
*/
public class Polygon
{  
   private ArrayList<Point2D.Double> points;

   /**
      Constructs a Polygon.
   */
   public Polygon()
   {  
      points = new ArrayList<Point2D.Double>();
   }

   /**
      Adds a point of the polygon.
      @param aPoint the point
   */
   public void add(Point2D.Double aPoint)
   {  
      points.add(aPoint);
   }

   /**
      Draws the polygon.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {  
      for (int i = 0; i < points.size(); i++)
      {  
         Point2D.Double from = points.get(i);
         Point2D.Double to = points.get((i + 1) % points.size());
         g2.draw(new Line2D.Double(from, to));
      }
   }
}
