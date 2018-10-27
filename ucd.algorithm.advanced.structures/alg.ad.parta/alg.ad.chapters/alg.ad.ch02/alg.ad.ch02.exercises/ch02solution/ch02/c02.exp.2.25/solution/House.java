import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

/**
   This class draws a house by allowing the user to specify houses of different sizes.
*/
public class House
{
   private int xleft;
   private int ybottom;

   /**
      Constructor to initiate the bottom left corner
      @param x the left corner coordinate
      @param y the bottom corner coordinate
   */
   public House(int x, int y)
   {
      xleft = x;
      ybottom = y;
   }

   /**
      Draws the house
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
      Rectangle front =
         new Rectangle(xleft, ybottom - 50, 50, 50);

      Rectangle door =
         new Rectangle(xleft + 10, ybottom - 25, 10, 25);

      Rectangle window =
         new Rectangle(xleft + 30, ybottom - 25, 10, 10);

      Line2D.Double roofLeft =
         new Line2D.Double(xleft, ybottom - 50, xleft + 25, ybottom - 100);

      Line2D.Double roofRight =
         new Line2D.Double(xleft + 50, ybottom - 50, xleft + 25, ybottom - 100);

      g2.draw(front);
      g2.draw(door);
      g2.draw(window);
      g2.draw(roofLeft);
      g2.draw(roofRight);
   }
}
