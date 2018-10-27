import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;

/**
   Draws a bull's eye.
 */
public class BullsEye
{
   private double radius;
   private double xCenter;
   private double yCenter;

   /**
      Creates a new instance of BullsEye.
      @param r the radius
      @param x the center x-coordinate
      @param y the center y-coordinate
    */
   public BullsEye(double r, double x, double y)
   {
      radius = r;
      xCenter = x;
      yCenter = y;
   }
   
   /**
      Draws the bull's eye.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
      // Draw a "bull's eye"

      Ellipse2D.Double circle
         = new Ellipse2D.Double(xCenter - radius, yCenter - radius, 2 * radius, 2 * radius);
      g2.setColor(Color.black);
      g2.fill(circle);

      radius = radius - 20;
      circle = new Ellipse2D.Double(xCenter - radius, yCenter - radius, 2 * radius, 2 * radius);
      g2.setColor(Color.white);
      g2.fill(circle);

      radius = radius - 20;
      circle = new Ellipse2D.Double(xCenter - radius, yCenter - radius, 2 * radius, 2 * radius);
      g2.setColor(Color.black);
      g2.fill(circle);

      radius = radius - 20;
      circle = new Ellipse2D.Double(xCenter - radius, yCenter - radius, 2 * radius, 2 * radius);
      g2.setColor(Color.white);
      g2.fill(circle);

      radius = radius - 20;
      circle = new Ellipse2D.Double(xCenter - radius, yCenter - radius, 2 * radius, 2 * radius);
      g2.setColor(Color.black);
      g2.fill(circle);
   }
}
