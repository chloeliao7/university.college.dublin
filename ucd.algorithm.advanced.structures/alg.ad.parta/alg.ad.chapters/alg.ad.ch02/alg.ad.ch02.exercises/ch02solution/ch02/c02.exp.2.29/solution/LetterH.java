import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
   The letter H of the word HELLO.
*/
public class LetterH
{
   private double x;
   private double y;

   /**
      Constructs a letter H at the given x and y coordinate.
      @param x the x-coordinate
      @param y the y-coordinate
   */
   public LetterH(double anX, double aY)
   {
      x = anX;
      y = aY;
   }

   /**
      Draws the letter H.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
      final int WIDTH = 30;
      final int HEIGHT = 50;

      Line2D.Double vert1 =
         new Line2D.Double(x, y, x, y + HEIGHT);
      Line2D.Double vert2 =
         new Line2D.Double(x + WIDTH, y, x + WIDTH, y + HEIGHT);
      Line2D.Double horiz =
         new Line2D.Double(x, y + HEIGHT / 2, x + WIDTH, y + HEIGHT / 2);

      g2.draw(vert1);
      g2.draw(vert2);
      g2.draw(horiz);
   }
}
