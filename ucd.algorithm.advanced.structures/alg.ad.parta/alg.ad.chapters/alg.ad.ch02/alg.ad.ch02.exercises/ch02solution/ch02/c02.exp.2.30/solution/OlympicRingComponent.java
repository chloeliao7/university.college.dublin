import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

/**
   Draws the olympic rings.
 */
public class OlympicRingComponent extends JComponent
{
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;

      int radius = 50;
      int distance = 80;

      double x = 0;
      double y = 0;

      Ring blue = new Ring(x, y, radius, Color.BLUE);
      blue.draw(g2);

      x = x + distance;
      Ring black = new Ring(x, y, radius, Color.BLACK);
      black.draw(g2);

      x = x + distance;
      Ring red = new Ring(x, y, radius, Color.RED);
      red.draw(g2);

      x = distance / 2;
      y = distance;
      Ring yellow = new Ring(x, y, radius, Color.YELLOW);
      yellow.draw(g2);

      x = x + distance;
      Ring green = new Ring(x, y, radius, Color.GREEN);
      green.draw(g2);
   }
}
