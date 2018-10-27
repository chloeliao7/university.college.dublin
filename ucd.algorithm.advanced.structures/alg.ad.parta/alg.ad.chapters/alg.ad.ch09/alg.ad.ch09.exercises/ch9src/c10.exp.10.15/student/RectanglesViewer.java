import javax.swing.JFrame;

/**
   Prompts the user for an integer and then draws as many rectangles at
   random positions in a component as the user requested.
 */
public class RectanglesViewer
{  
   public static void main(String[] args)
   {
      JFrame frame = new RectanglesFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("RectanglesViewer");
      frame.setVisible(true);
  }
}
