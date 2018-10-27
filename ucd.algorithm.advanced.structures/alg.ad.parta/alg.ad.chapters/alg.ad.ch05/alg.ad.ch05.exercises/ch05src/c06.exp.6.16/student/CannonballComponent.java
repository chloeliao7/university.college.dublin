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
      . . .
   }

   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      
      while(ball.getY() >= 0)
      {
         ball.move(DELTA_T);

         . . .

         g2.draw(circle);
      }
   }
}
