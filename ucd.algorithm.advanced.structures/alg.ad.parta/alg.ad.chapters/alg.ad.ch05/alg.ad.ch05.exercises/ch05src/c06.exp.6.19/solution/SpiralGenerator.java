import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
   This class produces the line segments in a spiral.
*/
public class SpiralGenerator
{
   private double increment;
   private double size;
   private Point2D.Double last;
   private int count;

   /**
      Creates a spiral generator.
      @param initialSize the size of the first (shortest) segment 
      of the spiral, in pixels
      @param start the starting point of the spiral
   */
   public SpiralGenerator(double initialSize, Point2D.Double start)
   {
      size = initialSize;
      increment = initialSize;
      last = start;
   }

   /**
      Returns the next segment of the spiral.
      @return the next segment
   */
   public Line2D.Double nextSegment()
   {
      int dx = 0;
      int dy = 0;
      if (count % 4 == 0) { dx = 1; dy = 0; } // right
      else if (count % 4 == 1) { dx = 0; dy = -1; } // up
      else if (count % 4 == 2) { dx = -1; dy = 0; } // left 
      else if (count % 4 == 3) { dx = 0; dy = 1; } // down
      Point2D.Double next = new Point2D.Double(
         last.getX() + dx * size,
         last.getY() + dy * size);
      Line2D.Double segment = new Line2D.Double(last, next);

      last = next;
      if (count % 2 == 1)
         size = size + increment;
      count++;

      return segment;
   }
}
