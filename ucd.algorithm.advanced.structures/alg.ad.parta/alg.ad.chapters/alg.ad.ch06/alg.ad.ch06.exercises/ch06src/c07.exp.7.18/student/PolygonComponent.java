import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**
   Displays two polygons.
*/
public class PolygonComponent extends JComponent
{
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;

      Polygon square = new Polygon();
      square.add(new Point2D.Double(100, 100));
      square.add(new Point2D.Double(100, 150));
      square.add(new Point2D.Double(150, 150));
      square.add(new Point2D.Double(150, 100));

      square.draw(g2);

      Polygon pentagon = new Polygon();
      double centerX = 200;
      double centerY = 200;
      double radius = 50;
      for (int i = 0; i < 5; i++)
      {
          double angle = 2 * Math.PI * i / 5;
          pentagon.add(new Point2D.Double(
                           centerX + radius * Math.cos(angle),
                           centerY + radius * Math.sin(angle)));
      }

      pentagon.draw(g2);
   }
}
