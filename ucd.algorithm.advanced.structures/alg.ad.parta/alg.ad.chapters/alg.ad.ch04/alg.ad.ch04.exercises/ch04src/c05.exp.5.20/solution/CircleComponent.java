import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
   Shows two Circles and tests whether they intersect or not.
 */
public class CircleComponent extends JComponent
{
   private Circle circle1;
   private Circle circle2;

 
   /**
      Constructs a component for showing two circles.
      @param r1 the radius of the first circle
      @param r2 the radius of the second circle
   */
   public CircleComponent(double r1, double r2)
   {
      String message;

      circle1 = new Circle(100, 200, r1);
      circle2 = new Circle(200, 100, r2);
      Color color;
      if (circle1.intersects(circle2))
         color = Color.GREEN;
      else
         color = Color.RED;
      circle1.setColor(color);
      circle2.setColor(color);
   }

   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;

      circle1.draw(g2);
      circle2.draw(g2);
   }
}
