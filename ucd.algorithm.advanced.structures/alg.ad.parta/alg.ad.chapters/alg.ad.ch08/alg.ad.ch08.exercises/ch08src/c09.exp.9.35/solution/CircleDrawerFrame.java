import javax.swing.JFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import java.awt.geom.Point2D;

/**
   Allows the user to specify a circle with two mouse clicks.
 */
public class CircleDrawerFrame extends JFrame
{
   private CircleDrawerComponent component;
   private Point2D.Double[] points;

   private static final int FRAME_WIDTH = 400;
   private static final int FRAME_HEIGHT = 400;

   public CircleDrawerFrame()
   {
      component = new CircleDrawerComponent();

      final int MAX_CLICKS = 2;
      points = new Point2D.Double[MAX_CLICKS];            
      
      // add mouse click listener
      
      class MousePressedListener implements MouseListener
      {
         public void mousePressed(MouseEvent event)
         {  
            if (clicks >= MAX_CLICKS) return;
            int mouseX = event.getX();
            int mouseY = event.getY();
            points[clicks] = new Point2D.Double(mouseX, mouseY);
            clicks++;

            if (clicks == MAX_CLICKS)
            {
               // Compute center of circle 

               int x = (int) points[0].getX();
               int y = (int) points[0].getY();

               // Compute radius of circle 

               int radius =
                     (int) Math.sqrt(Math.pow(x - points[1].getX(), 2)
                     + Math.pow(y - points[1].getY(), 2)); 

               component.setPositionAndSize(x, y, radius);
            }
         }
         
         // Do-nothing methods
         public void mouseReleased(MouseEvent event) {}
         public void mouseClicked(MouseEvent event) {}
         public void mouseEntered(MouseEvent event) {}
         public void mouseExited(MouseEvent event) {}
         
         private int clicks = 0;
      }
      
      MousePressedListener listener = new MousePressedListener();
      component.addMouseListener(listener);

      setSize(FRAME_WIDTH, FRAME_HEIGHT);
      add(component);
   }
}
