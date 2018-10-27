import javax.swing.JComponent;
import javax.swing.JFrame;

/**
   This program draws cars and trucks in random order.
*/
public class RandomVehicleViewer
{
   public static void main(String args[])
   {
      JFrame frame = new JFrame();
      final int FRAME_WIDTH = 600;
      final int FRAME_HEIGHT = 600;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JComponent component = new RandomVehicleComponent();
      frame.add(component);
      frame.setVisible(true);
   }
}
