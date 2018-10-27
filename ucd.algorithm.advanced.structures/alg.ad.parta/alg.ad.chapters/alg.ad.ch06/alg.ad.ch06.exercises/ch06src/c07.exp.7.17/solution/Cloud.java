import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
   This class draws a cloud of circles.
*/
public class Cloud
{
   private ArrayList<Point2D.Double> points;
   private final int RADIUS = 3;

   /**
      Construct a Cloud object.
   */
   public Cloud()
   {
      points = new ArrayList<Point2D.Double>();
   }

   /**
      Adds a point to this cloud.
      @param p the point to add
   */
   public void add(Point2D.Double p)
   {
      points.add(p);
   }
   
   /**
      Draws the cloud.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
      for (Point2D.Double p : points)
      {
         Ellipse2D.Double e = 
            new Ellipse2D.Double(p.getX(), p.getY(), RADIUS * 2, RADIUS * 2);
            
         g2.draw(e);
      }
   }
}
