import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
   The letter E of the word HELLO.
*/
public class LetterE
{
   private double x;
   private double y;

   /**
      Constructs a letter E at the given x and y coordinate.
      @param x the x-coordinate
      @param y the y-coordinate
   */
   public LetterE(double anX, double aY)
   {
      x = anX;
      y = aY;
   }

   /**
      Draws the letter E.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
      final int WIDTH = 30;
      final int HEIGHT = 50;

      Line2D.Double horiz1 =
         new Line2D.Double(x, y, x + WIDTH, y);
      Line2D.Double horiz2 =
         new Line2D.Double(x, y + HEIGHT / 2, x + WIDTH, y + HEIGHT / 2);
      Line2D.Double horiz3 =
         new Line2D.Double(x, y + HEIGHT, x + WIDTH, y + HEIGHT);
      Line2D.Double vert =
         new Line2D.Double(x, y, x, y + HEIGHT);

      g2.draw(horiz1);
      g2.draw(horiz2);
      g2.draw(horiz3);
      g2.draw(vert);
   }
}
