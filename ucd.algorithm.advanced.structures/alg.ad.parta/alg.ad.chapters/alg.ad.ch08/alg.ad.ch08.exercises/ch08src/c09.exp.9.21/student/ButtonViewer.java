import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
   This program demonstrates how to install an action listener.
*/
public class ButtonViewer
{  
   private static final int FRAME_WIDTH = 100;
   private static final int FRAME_HEIGHT = 100;

   public static void main(String[] args)
   {  
      JFrame frame = new JFrame();
      JPanel panel = new JPanel();
      
      JButton button = new JButton("Click me!");
      panel.add(button);
      
      . . .

      frame.add(panel);
      
      ActionListener listener = new ClickListener();
      button.addActionListener(listener);
      
      . . .
      
      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}
