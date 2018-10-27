import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
   This program views two circles.
*/
public class CircleViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 400;
      final int FRAME_HEIGHT = 400;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("CircleViewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      String input = JOptionPane.showInputDialog("Radius 1:");
      double r1 = Double.parseDouble(input);

      input = JOptionPane.showInputDialog("Radius 2:");
      double r2 = Double.parseDouble(input);

      CircleComponent component = new CircleComponent(r1, r2);
      frame.add(component);

      frame.setVisible(true);
   }
}
