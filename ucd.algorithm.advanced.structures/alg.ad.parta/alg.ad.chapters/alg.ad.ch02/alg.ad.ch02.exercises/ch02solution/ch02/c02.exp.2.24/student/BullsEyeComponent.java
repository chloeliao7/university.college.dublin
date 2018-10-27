import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
   Displays a bull's eye.
 */
public class BullsEyeComponent extends JComponent
{
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      
      int radius = 100;
      int xCenter = 100;
      int yCenter = 100;
      BullsEye be = new BullsEye(radius, xCenter, yCenter);
      be.draw(g2);
   }
}
