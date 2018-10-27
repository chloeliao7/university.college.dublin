import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class RandomShapesComponent extends JComponent
{ 
   public void paintComponent(Graphics g) 
   {
      Graphics2D g2 = (Graphics2D) g;
      RandomShapeGenerator r = new RandomShapeGenerator(getWidth(), getHeight());

      for (int i = 1; i <= 10; i++)
         g2.draw(r.randomShape());
   }
}
