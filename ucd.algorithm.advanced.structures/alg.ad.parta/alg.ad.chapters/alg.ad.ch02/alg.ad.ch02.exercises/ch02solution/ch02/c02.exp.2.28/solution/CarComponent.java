import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws two car shapes.
*/
public class CarComponent extends JComponent
{  
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;

      Car car1 = new Car(0, 0, 50, 50);
      Car car2 = new Car(80, 100, 200, 100);

      car1.draw(g2);
      car2.draw(g2);      
   }
}
