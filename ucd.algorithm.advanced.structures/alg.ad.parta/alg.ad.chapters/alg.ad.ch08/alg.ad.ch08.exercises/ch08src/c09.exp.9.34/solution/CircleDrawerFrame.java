import javax.swing.JFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JOptionPane;

/**
   Allows the user to specify a circle by typing the radius in a text field
   and then clicking on the center.
 */
public class CircleDrawerFrame extends JFrame
{  
   private CircleDrawerComponent component;

   private static final int FRAME_WIDTH = 400;
   private static final int FRAME_HEIGHT = 400;

   public int radius;

   public CircleDrawerFrame()
   {  
      component = new CircleDrawerComponent();
      component.setPreferredSize(new Dimension(400,350));

      // add mouse press listener         
      class MousePressListener implements MouseListener
      {  
         public void mousePressed(MouseEvent event)
         {  
            int x = event.getX();
            int y = event.getY();

            String ansRadius = JOptionPane.showInputDialog("Enter radius");
            radius = Integer.parseInt(ansRadius);
            
            component.setPositionAndSize(x, y, radius);
          }

         // do-nothing methods
         public void mouseReleased(MouseEvent event) {}
         public void mouseClicked(MouseEvent event) {}
         public void mouseEntered(MouseEvent event) {}
         public void mouseExited(MouseEvent event) {}
      }
         
      MouseListener listener = new MousePressListener();
      component.addMouseListener(listener);   

      setSize(FRAME_WIDTH, FRAME_HEIGHT);
      add(component);
   }
}
