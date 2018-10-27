import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

public class DrunkardComponent extends JComponent
{
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;

      final int NSQUARES = 20;
      final int RADIUS = 3;
      final int MAX_MOVES = 100;

      int size = Math.min(getWidth(), getHeight()) / NSQUARES;

      Grid myGrid = new Grid(size, NSQUARES);
      myGrid.draw(g2);

      int x = NSQUARES / 2;
      int y = NSQUARES / 2;

      Drunkard d = new Drunkard(x, y);

      for (int i = 1; i <= MAX_MOVES; i++)
      {
         d.move();
         x = d.getRow();
         y = d.getColumn();
         Ellipse2D.Double e = new Ellipse2D.Double(x * size - RADIUS,
            y * size - RADIUS, 2 * RADIUS, 2 * RADIUS);
         g2.draw(e);
      }
   }
}
