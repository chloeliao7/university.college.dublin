import javax.swing.JFrame;

/**
   Displays a "bull's eye".
 */
public class BullsEyeViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      frame.setSize(220, 240);
      frame.setTitle("BullsEye");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      BullsEyeComponent component = new BullsEyeComponent();
      frame.add(component);

      frame.setVisible(true);
   }
}
