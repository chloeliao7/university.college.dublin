import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
   Draws the trajectory of a cannonball.
*/
public class CannonballComponent extends JComponent
{
   private double initialVelocity;
   private double angle;

   /**
      Constructs a component that paints the flight of a cannonball 
      @param ivel the initial velocity of the ball
      @param ang the angle at which the cannonball was launched
   */
   public CannonballComponent(double ivel, double ang)
   {
      initialVelocity = ivel;
      angle = ang;
   }

   public void paintComponent(Graphics g)
   {
      Cannonball ball = new Cannonball(initialVelocity, angle);

      final double DELTA_T = 0.01;
      final double RADIUS = 2;
      Graphics2D g2 = (Graphics2D) g;
      
      while(ball.getY() >= 0)
      {
         ball.move(DELTA_T);
         double x = ball.getX(); 
         double y = getHeight() - ball.getY(); 
         Ellipse2D.Double circle = new Ellipse2D.Double(
            x - RADIUS, y - RADIUS, 2 * RADIUS, 2 * RADIUS);
         g2.draw(circle);
      }
   }
}
