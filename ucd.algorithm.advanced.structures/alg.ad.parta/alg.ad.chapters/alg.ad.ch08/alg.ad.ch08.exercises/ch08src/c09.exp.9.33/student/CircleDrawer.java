import javax.swing.JFrame;

/**
   Prompts the user to enter the x- and y-positions of the center and a radius.
   When the user clicks a "Draw" button, draw a circle with that center and
   radius in a component.
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
