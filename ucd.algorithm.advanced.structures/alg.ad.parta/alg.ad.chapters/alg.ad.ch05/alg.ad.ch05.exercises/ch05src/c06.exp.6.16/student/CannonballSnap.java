import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
   This is a driver for taking a screen snapshot 
   of the CannonballComponent class.
*/
public class CannonballSnap
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 300;
      final int FRAME_HEIGHT = 300;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("CannonballViewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      double ivel = 50;

      double ang = 45;

      CannonballComponent component = new CannonballComponent(ivel, ang);
      frame.add(component);

      frame.setVisible(true);
   }
}
