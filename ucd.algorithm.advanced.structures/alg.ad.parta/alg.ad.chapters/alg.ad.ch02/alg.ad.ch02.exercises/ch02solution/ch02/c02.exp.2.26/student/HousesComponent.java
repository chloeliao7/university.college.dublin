import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
   Draws a few houses of different sizes.
 */
public class HousesComponent extends JComponent
{
   public void paintComponent(Graphics g)
   {
      // Draws a house with given coordinates

      Graphics2D g2 = (Graphics2D) g;

      House house1 = new House(100, 150, 100, 120);
      House house2 = new House(210, 200, 50, 70);
      House house3 = new House(260, 260, 20, 25);

      house1.draw(g2);
      house2.draw(g2);
      house3.draw(g2);
   }
}
