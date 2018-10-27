import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class HouseViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      frame.setSize(300, 400);
      frame.setTitle("Houses");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      HousesComponent component = new HousesComponent();
      frame.add(component);

      frame.setVisible(true);
   }
}
