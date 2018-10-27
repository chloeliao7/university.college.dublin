import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class CheckerBoardComponent extends JComponent
{
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;

      final int NSQUARES = 8;

      int size = Math.min(getWidth(), getHeight()) / NSQUARES;
      CheckerBoard cb = new CheckerBoard(NSQUARES, size);

      cb.draw(g2);
   }
}
