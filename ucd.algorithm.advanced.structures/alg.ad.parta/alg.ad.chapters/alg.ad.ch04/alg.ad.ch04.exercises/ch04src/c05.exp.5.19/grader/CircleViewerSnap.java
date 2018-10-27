import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
   This program views a circle and a pocint.
*/
public class CircleViewerSnap
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 400;
      final int FRAME_HEIGHT = 400;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("CircleViewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      Point2D.Double point = new Point2D.Double(150, 150);
            
      CircleComponent component = new CircleComponent(point);
      frame.add(component);

      frame.setVisible(true);
   }
}
