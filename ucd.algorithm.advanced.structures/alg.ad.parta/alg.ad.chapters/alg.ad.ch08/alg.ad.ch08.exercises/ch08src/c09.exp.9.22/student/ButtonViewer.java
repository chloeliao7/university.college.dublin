import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
   This program demonstrates how to install an action listener.
*/
public class ButtonViewer
{  
   private static final int FRAME_WIDTH = 150;
   private static final int FRAME_HEIGHT = 100;

   public static void main(String[] args)
   {  
      JFrame frame = new JFrame();
      JPanel panel = new JPanel();
      
      JButton buttonA = new JButton("A");
      panel.add(buttonA);

      . . .
      
      frame.add(panel);
      
      ActionListener listenerA = new ClickListener("A");
      buttonA.addActionListener(listenerA);
      
      . . .
      
      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}
