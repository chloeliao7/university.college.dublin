import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

/**
   Displays rectangles in random positions.
*/
public class RectanglesComponent extends JComponent
{ 
   private Rectangle box;
   private int count;
   private static final int BOX_X = 100;
   private static final int BOX_Y = 100;
   private static final int BOX_WIDTH = 20;
   private static final int BOX_HEIGHT = 30;

   public RectanglesComponent()
   {  
      count = 0;

      // the rectangle that the paintComponent method draws
      box = new Rectangle(BOX_X, BOX_Y, BOX_WIDTH, BOX_HEIGHT);
   }
   
   public void setCount(int aCount)
   {
      count = aCount;
      repaint();
   }

   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      
      Random generator = new Random();
           
      int x = 0;
      int y = 0;
      
      for (int i = 0; i < count; i++)
      {
         x = generator.nextInt(getWidth());
         y = generator.nextInt(getHeight());      
         box.setLocation(x, y);
         g2.draw(box);
      }
   }
}
