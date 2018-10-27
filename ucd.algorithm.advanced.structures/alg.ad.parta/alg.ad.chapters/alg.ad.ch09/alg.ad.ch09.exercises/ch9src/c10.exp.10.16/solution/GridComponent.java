import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
   Draws a grid.
*/
public class GridComponent extends JComponent
{
   /**
      Creates the component object.
   */
   public GridComponent()
   {
      count = 0;
   }
   
   /**
      Sets the number of squares per side of the n x n grid.
      @param aCount the number of squares per side of the grid
    */
   public void setCount(int aCount)
   {
      count = aCount;
   }
   
   /**
      Draw the grid.
      @param g the graphics context
   */
   public void paintComponent(Graphics g)
   {
      if (count == 0) 
         return;

      Graphics2D g2 = (Graphics2D) g;

      // draw vertical n
      for (int i = 0; i <= count; i++)
      {  
         double x = i * (getWidth() - 1) / count;
         Point2D.Double p = new Point2D.Double(x, 0);
         Point2D.Double q = new Point2D.Double(x, getHeight());
         g2.draw(new Line2D.Double(p, q));
      }

      // draw horizontal n
      for (int i = 0; i <= count; i++)
      {  
         double y = i * (getHeight() - 1) / count;
         Point2D.Double p = new Point2D.Double(0, y);
         Point2D.Double q = new Point2D.Double(getWidth(), y);
         g2.draw(new Line2D.Double(p, q));
      }
   }
 
   private int count;
}
