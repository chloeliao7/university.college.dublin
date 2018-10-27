import javax.swing.JFrame;

/**
   Displays a frame that shows a house.
 */
public class HouseViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      frame.setSize(300, 500);
      frame.setTitle("A house");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      HouseComponent component = new HouseComponent();
      frame.add(component);

      frame.setVisible(true);
   }
}
