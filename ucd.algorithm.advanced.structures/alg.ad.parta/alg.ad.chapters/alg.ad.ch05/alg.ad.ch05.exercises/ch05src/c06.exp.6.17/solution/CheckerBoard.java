import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
   This class displays a checkerboard with squares,
   alternating between white and black.
*/
public class CheckerBoard
{
   private int numSquares;
   private int size;

   /**
      Creates a CheckerBoard object with a given number of squares.
      @param aNumSquares the number of squares in each row
      @param aSize the size of each square
   */
   public CheckerBoard(int aNumSquares, int aSize)
   {
      numSquares = aNumSquares;
      size = aSize;
   }

   /**
      Method used to draw the checkerboard.
      @param g2 the graphics content
   */
   public void draw(Graphics2D g2)
   {
      for (int i = 0; i < numSquares; i++)
      {
         for (int j = 0; j < numSquares; j++)
         {
            if ((i + j) % 2 == 0)
            {
               Rectangle r = new Rectangle(i * size, j * size, size, size);
               g2.fill(r);
            }
         }
      }
   }
}
