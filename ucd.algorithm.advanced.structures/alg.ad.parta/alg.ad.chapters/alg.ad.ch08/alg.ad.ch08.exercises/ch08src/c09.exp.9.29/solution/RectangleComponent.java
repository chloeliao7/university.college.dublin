import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

/**
   This component displays a rectangle that can be moved. 
*/
public class RectangleComponent extends JComponent
{  
   private static final int BOX_X = 100;
   private static final int BOX_Y = 100;
   private static final int BOX_WIDTH = 20;
   private static final int BOX_HEIGHT = 30;

   private Rectangle box;
   private int dx;
   private int dy;

   public RectangleComponent()
   {  
      // The rectangle that the paint method draws 
      box = new Rectangle(BOX_X, BOX_Y, 
            BOX_WIDTH, BOX_HEIGHT);         
      dx = 1;
      dy = 1;
   }

   public void paintComponent(Graphics g)
   {  
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;

      g2.draw(box);
   }

   /**
      Moves the rectangle. 
   */
   public void moveRectangle()
   {
      if (box.getX() <= 0)
         dx = 1;
      if (box.getY() <= 0)
         dy = 1;
      if (box.getMaxX() > getWidth())
         dx = -1;
      if (box.getMaxY() > getHeight())
         dy = -1;
      box.translate(dx, dy);
      repaint();      
   }
}
