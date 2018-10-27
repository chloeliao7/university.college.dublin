import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

/**
   This component displays a car that can be moved. 
*/
public class CarComponent extends JComponent
{  
   private Car car;

   public CarComponent()
   {  
      // The rectangle that the paint method draws 
      car = new Car(0, 0);         
   }

   public void paintComponent(Graphics g)
   {  
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;

      car.draw(g2);
   }

   /**
      Moves the rectangle by a given amount. 
      @param x the amount to move in the x-direction 
      @param y the amount to move in the y-direction 
   */
   public void moveCarBy(int dx, int dy)
   {
      car.translate(dx, dy);
      repaint();      
   }
}
