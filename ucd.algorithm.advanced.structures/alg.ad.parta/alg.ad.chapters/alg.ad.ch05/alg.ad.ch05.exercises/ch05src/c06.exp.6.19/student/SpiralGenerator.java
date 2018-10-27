public class SpiralGenerator
{   
   // private implementation
   . . .

   /**
      Creates a spiral generator.
      @param initialSize the size of the first (shortest) segment 
      of the spiral, in pixels
      @param start the starting point of the spiral
   */
   public SpiralGenerator(double initialSize, Point2D.Double start) { . . . }
 
   /**
      Returns the next segment of the spiral.
      @return the next segment
   */
   public Line2D.Double nextSegment() { . . . }
}
