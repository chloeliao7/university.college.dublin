import javax.swing.JFrame;

/**
   Allows the user to specify a circle with two mouse clicks.
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
