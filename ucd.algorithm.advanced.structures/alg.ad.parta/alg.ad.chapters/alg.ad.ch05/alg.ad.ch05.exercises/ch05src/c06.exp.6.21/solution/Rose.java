import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
   This class is used to draw a "four-leaved rose".
*/
public class Rose
{
   private double width;
   private double height;

   /**
      Creates a Rose object to draw the "four-leaved rose".
      @param aWidth the width of the rose
      @param aHeight the height of the rose
   */
   public Rose(double aWidth, double aHeight)
   {
      width = aWidth;
      height = aHeight;
   }

   /**
      Method used to draw the "four-leaved rose".
      @param g2 the graphics content
   */
   public void draw(Graphics2D g2)
   {
      final double XMIN = -1;
      final double XMAX = 1;
      final double YMIN = -1;
      final double YMAX = 1;

      final double ANGLE_MIN = 0;
      final double ANGLE_MAX = 2 * Math.PI;
      final int STEPS = 100;
      final int NPETALS = 4;

      double theta = ANGLE_MIN;
      double r = f(theta, NPETALS);
      double d = ANGLE_MAX / STEPS;

      double x = r * Math.cos(theta);
      double y = r * Math.sin(theta);
      double x1 = width * (x - XMIN) / (XMAX - XMIN);
      double y1 = height * (YMAX - y) / (YMAX - YMIN);

      for (theta = d; theta <= ANGLE_MAX; theta = theta + d)
      {
         r = f(theta, NPETALS);

         x = r * Math.cos(theta);
         y = r * Math.sin(theta);
         double x2 = width * (x - XMIN) / (XMAX - XMIN);
         double y2 = height * (YMAX - y) / (YMAX - YMIN);

         Line2D.Double l = new Line2D.Double(x1, y1, x2, y2);
         g2.draw(l);
         x1 = x2;
         y1 = y2;
      }
   }

   /**
      Method used to calculate the points on the curve
      @param theta the angle of the polar coordinate of the point
      @param n the number of petals
      @return the radius of the polar coordinate of the point
   */
   public double f(double theta, int n)
   {
      if (n % 2 == 0)
         return Math.cos((n / 2) * theta);
      else
         return Math.cos(n * theta);
   }
}
