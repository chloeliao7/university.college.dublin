import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
   This class provides methods to simulate the movement of a drunkard.
*/
public class Drunkard
{
   private static final int UP = 0;
   private static final int DOWN = 1;
   private static final int LEFT = 2;
   private static final int RIGHT = 3;

   private int size;
   private int x;
   private int y;
   private Random generator;

   /**
      Creates a Drunkard object representing an intoxicated person.
      @param anX the x coordinate size
      @param aY the y coordinate size
   */
   public Drunkard(int anX, int aY)
   {
      x = anX;
      y = aY;
      generator = new Random();
   }

   /**
      Method used to simulate the moves of the intoxicated person.
   */
   public void move()
   {
      int move = generator.nextInt(4);

      if (move == UP)
         y--;
      else if (move == DOWN)
         y++;
      else if (move == LEFT)
         x--;
      else if (move == RIGHT)
         x++;
   }

   public int getRow() { return x; }
   public int getColumn() { return y; }
}
