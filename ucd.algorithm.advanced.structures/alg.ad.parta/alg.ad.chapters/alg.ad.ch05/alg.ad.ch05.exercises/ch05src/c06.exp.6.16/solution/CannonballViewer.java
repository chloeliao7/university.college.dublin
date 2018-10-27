import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
   This program displays the trajectory of a cannonball.
*/
public class CannonballViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 300;
      final int FRAME_HEIGHT = 300;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("CannonballViewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      String input1 = JOptionPane.showInputDialog(
         "Enter the initial velocity: (e.g. 50)");
      double ivel = Double.parseDouble(input1);

      String input2 = JOptionPane.showInputDialog(
         "Enter the angle in degrees: (e.g. 45)");
      double ang = Double.parseDouble(input2);

      CannonballComponent component = new CannonballComponent(ivel, ang);
      frame.add(component);

      frame.setVisible(true);
   }
}
