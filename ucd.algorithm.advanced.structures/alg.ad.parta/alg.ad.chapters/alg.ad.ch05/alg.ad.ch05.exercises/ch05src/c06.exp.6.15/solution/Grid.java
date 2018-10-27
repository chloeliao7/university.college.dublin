import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
   This class is used to draw a grid, 10 blocks horizontal and
   10 blocks vertical, representing 10 city blocks.
*/
public class Grid
{
   private static final int RADIUS = 3;
   private int size;
   private int nSquares;

   /**
      Creates a Grid object to draw a grid.
      @param aSize the size of grid
      @param aNSquares the number of squares in the grid
   */
   public Grid(int aSize, int aNSquares)
   {
      size = aSize;
      nSquares = aNSquares;
   }

   /**
      Method used to draw the grids.
      @param g2 the graphics content
   */
   public void draw(Graphics2D g2)
   {
      // draw the x-direction of the grid
      double x;
      for (x = 0; x <= nSquares; x++)
      {
         Line2D.Double l = new Line2D.Double(x * size, 0,
            x * size, nSquares * size);
         g2.draw(l);
      }

      // draw the y-direction of the grid
      double y;
      for (y = 0; y <= nSquares; y++)
      {
         Line2D.Double l = new Line2D.Double(0, y * size,
            nSquares * size, y * size);
         g2.draw(l);
      }
   }
}
