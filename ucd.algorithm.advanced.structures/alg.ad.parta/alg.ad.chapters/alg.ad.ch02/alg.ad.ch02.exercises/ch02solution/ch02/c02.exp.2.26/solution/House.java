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
   private int width;
   private int height;

   /**
      Constructor to initiate the bottom left corner, the width, and the height.
      @param x the left corner coordinate
      @param y the bottom corner coordinate
      @param w the width of the house
      @param h the height of the house
   */
    public House(int x, int y, int w, int h)
   {
      xleft = x;
      ybottom = y;
      width = w;
      height = h;
   }

   /**
      Draws the house.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
      Rectangle front =
         new Rectangle(xleft, ybottom - width, width, width);

      Rectangle door =
         new Rectangle(xleft + width / 5, ybottom - width / 2, width / 5, width / 2);

      Rectangle window =
         new Rectangle(xleft + width * 3 / 5, ybottom - width / 2, width / 5, width / 5);

      Line2D.Double roofLeft =
         new Line2D.Double(xleft, ybottom - width, xleft + width / 2, ybottom - height);

      Line2D.Double roofRight =
         new Line2D.Double(xleft + width, ybottom - width, xleft + width / 2, ybottom - height);

      g2.draw(front);
      g2.draw(door);
      g2.draw(window);
      g2.draw(roofLeft);
      g2.draw(roofRight);
   }
}
