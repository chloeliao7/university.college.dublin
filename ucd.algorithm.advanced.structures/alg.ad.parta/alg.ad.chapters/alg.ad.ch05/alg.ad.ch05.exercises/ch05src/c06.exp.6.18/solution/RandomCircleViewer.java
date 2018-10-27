import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
   Test driver class for RandomCircle class.
*/
public class RandomCircleViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 400;
      final int FRAME_HEIGHT = 400;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("RandomCircleViewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      String input = JOptionPane.showInputDialog("Enter the circle count: (e.g. 10)");
      int n = Integer.parseInt(input);

      RandomCircleComponent component = new RandomCircleComponent(n);
      frame.add(component);

      frame.setVisible(true);
   }
}
