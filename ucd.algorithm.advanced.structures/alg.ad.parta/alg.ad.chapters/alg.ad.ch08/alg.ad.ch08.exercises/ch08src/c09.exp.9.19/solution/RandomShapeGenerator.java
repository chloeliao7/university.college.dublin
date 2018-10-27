import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Random;

/**
   This class provides a method to generate random Shape objects.
*/
public class RandomShapeGenerator 
{
   private Random generator;  
   private int windowW;
   private int windowH;  

   /**
      Construct a RandomShapeGenerator object.
      @param w the width of the window
      @param h the height of the window
   */
   public RandomShapeGenerator(int w, int h)
   {  
      generator = new Random();
      windowW = w;
      windowH = h;
   }   
   
   /**
      Generate a random shape.
      @return a shape: Rectangle, Ellipse, or Line
   */
   public Shape randomShape()
   {  
      int s = generator.nextInt(3);
      int x = generator.nextInt(windowW);
      int y = generator.nextInt(windowH);

      final int WIDTH = 30;
      final int HEIGHT = 15;

      if (s == 0)
         return new Rectangle(x, y, WIDTH, HEIGHT);
      else if (s == 1)
         return new Ellipse2D.Double(x, y, WIDTH, HEIGHT);
      else
         return new Line2D.Double(x, y, x + WIDTH, y + HEIGHT);
   }
}
