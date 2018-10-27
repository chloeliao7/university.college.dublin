import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class RoseComponent extends JComponent
{
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;

      double width = getWidth();
      double height = getHeight();

      Rose myRose = new Rose(width, height);
      myRose.draw(g2);
   }
}
