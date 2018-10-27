import javax.swing.JFrame;

/**
   Allows the user to specify a circle by typing the radius in a text field
   and then clicking on the center.
 */
public class CircleDrawer
{  
   public static void main(String[] args)
   {
      JFrame frame = new CircleDrawerFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("CircleDrawer");
      frame.setVisible(true);
  }
}
