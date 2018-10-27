import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JOptionPane;

/**
   Takes the x- and y-positions of the center and a radius.
   When the user clicks a "Draw" button, draw a circle with that center and
   radius in a component.
 */
public class CircleDrawerFrame extends JFrame
{  
   private CircleDrawerComponent component;
   private int x;
   private int y;
   private int radius;

   private static final int FRAME_WIDTH = 400;
   private static final int FRAME_HEIGHT = 400;

   public CircleDrawerFrame()
   {
      component = new CircleDrawerComponent();
      component.setPreferredSize(new Dimension(400,350));
      
      // the panel for holding the user interface components
      JPanel panel = new JPanel();

      panel.add(createDrawButton());
      panel.add(component);

      setSize(FRAME_WIDTH, FRAME_HEIGHT);
      add(panel);
   }

   private JButton createDrawButton()
   {
      // the button to draw the circle
      JButton drawButton = new JButton("Draw");    

      class DrawButtonListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            /* 
               create JOptionPane dialogs to collect the
               x- and y- positions of the center and a radius
            */
            String ansX = JOptionPane.showInputDialog("Enter x-coordinate");
            x = Integer.parseInt(ansX);
            
            String ansY = JOptionPane.showInputDialog("Enter y-coordinate");
            y = Integer.parseInt(ansY);
            
            String ansRadius = JOptionPane.showInputDialog("Enter radius");
            radius = Integer.parseInt(ansRadius);
            
            component.setPositionAndSize(x, y, radius);
         }
      }

      ActionListener listener = new DrawButtonListener();
      drawButton.addActionListener(listener);      

      return drawButton;
   }
}
