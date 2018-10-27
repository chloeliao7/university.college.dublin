import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
   A RandomCircleComponent draws a number of random circles.
*/
public class RandomCircleComponent extends JComponent
{
   private int count;
   private static final double MAX_RADIUS = 100;

   /**
      Constructs a RandomCircleComponent that draws a given number of circles.
      @param n the number of circles to draw.
   */
   public RandomCircleComponent(int n)
   {
      count = n;
   }

   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      Random generator = new Random();

      for (int i = 1; i <= count; i++)
      {
         
         double r = generator.nextDouble() * MAX_RADIUS;
         double x = generator.nextDouble() * (getWidth() - 2 * r);
         double y = generator.nextDouble() * (getHeight() - 2 * r);
         Ellipse2D.Double circle = new Ellipse2D.Double(x, y, 2 * r, 2 * r);
         g2.draw(circle);                  
      }
   }
}
