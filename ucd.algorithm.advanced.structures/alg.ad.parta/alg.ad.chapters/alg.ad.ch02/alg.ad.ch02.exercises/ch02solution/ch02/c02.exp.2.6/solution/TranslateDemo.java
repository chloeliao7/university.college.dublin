import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
	Use a rectangle object to create and place a frame window.
	Move the rectangle and use it to move the frame window.
*/
public class TranslateDemo
{
   public static void main(String[] args)
   {
      // Construct a frame and show it
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
	
      // Construct a rectangle and set the frame bounds
      Rectangle r = new Rectangle(30, 50, 250, 250);
      frame.setBounds(r);
	
      JOptionPane.showMessageDialog(frame, "Click OK to continue.");
	
      // Move the rectangle and set the frame bounds again.
      r.translate(200, 200);
      frame.setBounds(r);
   }
}
