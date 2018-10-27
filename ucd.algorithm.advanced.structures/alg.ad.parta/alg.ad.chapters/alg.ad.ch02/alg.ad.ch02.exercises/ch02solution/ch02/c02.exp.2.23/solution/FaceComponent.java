import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/**
   Draws a face.
 */
public class FaceComponent extends JComponent
{
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;

      int faceRadius = 100;
      int eyeRadius = 5;

      Ellipse2D.Double face =
         new Ellipse2D.Double(0, 0, 2 * faceRadius, 2 * faceRadius);

      double xEye1 = faceRadius / 2;
      double yEye = faceRadius * 2 / 3;
      Ellipse2D.Double eye1 =
         new Ellipse2D.Double(xEye1 - eyeRadius, yEye - eyeRadius,
         2 * eyeRadius, 2 * eyeRadius);

      double xEye2 = faceRadius * 3 / 2;
      Ellipse2D.Double eye2 =
         new Ellipse2D.Double(xEye2 - eyeRadius, yEye - eyeRadius,
         2 * eyeRadius, 2 * eyeRadius);

      double yMouth = faceRadius * 4 / 3;
      Line2D.Double mouth =
         new Line2D.Double(xEye1, yMouth, xEye2, yMouth);

      g2.draw(face);
      g2.draw(eye1);
      g2.draw(eye2);
      g2.draw(mouth);
   }
}
