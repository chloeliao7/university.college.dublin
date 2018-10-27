import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
   This program views two circles.
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

      CircleComponent component = new CircleComponent(60, 85);
      frame.add(component);

      frame.setVisible(true);
   }
}
