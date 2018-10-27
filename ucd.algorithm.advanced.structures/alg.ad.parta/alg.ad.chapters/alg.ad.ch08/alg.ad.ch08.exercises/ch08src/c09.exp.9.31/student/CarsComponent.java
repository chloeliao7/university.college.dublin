import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
   This component displays cars. 
*/
public class CarsComponent extends JComponent
{  
   private ArrayList<Car> cars;

   public CarsComponent()
   {  
      // The rectangle that the paint method draws 
      cars = new ArrayList<Car>();         
   }

   public void add(Car car)
   {
      cars.add(car);
   }

   public void paintComponent(Graphics g)
   {  
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      for (Car car : cars)
         car.draw(g2);
   }
}
