import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
   The letter O of the word HELLO.
*/
public class LetterO
{
   private double x;
   private double y;

   /**
      Constructs a letter O at the given x and y coordinate.
      @param x the x-coordinate
      @param y the y-coordinate
   */
   public LetterO(double anX, double aY)
   {
      x = anX;
      y = aY;
   }

   /**
      Draws the letter O.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
      final int WIDTH = 30;
      final int HEIGHT = 50;

      Ellipse2D.Double e = new Ellipse2D.Double(x, y, WIDTH, HEIGHT);

      g2.draw(e);
   }
}
