import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
   Draws a picture of a house, using the House class.
 */
public class HouseComponent extends JComponent
{
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;

      int x = 100;
      int y = 200;

      House house = new House(x, y);

      house.draw(g2);
   }
}
