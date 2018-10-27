import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;

public class SpiralComponent extends JComponent
{
   private int segments;

   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      final int INITIAL_SIZE = 10;

      int size = Math.min(getWidth(), getHeight());
      SpiralGenerator gen = new SpiralGenerator(
         INITIAL_SIZE,
         new Point2D.Double(size / 2, size / 2));

      while (true)
      {
         Line2D.Double segment = gen.nextSegment();
         if (!segment.intersects(getBounds()))
            return;
         g2.draw(segment);
      }
   }
}
