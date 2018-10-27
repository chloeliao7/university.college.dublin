import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

/**
   Draws cars and trucks in random order.
*/
public class RandomVehicleComponent extends JComponent
{
   private Random generator;

   public RandomVehicleComponent()
   {
      generator = new Random();
   }

   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      for (int i = 1; i <= 10; i++)
         randomVehicle().draw(g2);
   }

   public Vehicle randomVehicle()
   {
      Vehicle v = null;
      if (generator.nextBoolean())
         v = new Car();
      else
         v = new Truck();
      v.setLocation(generator.nextInt(getWidth() - v.getWidth()),
            generator.nextInt(getHeight() - v.getHeight()));
      return v;
   }
}
