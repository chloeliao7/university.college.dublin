import java.awt.geom.Point2D;

/**
   This class describes a line in the plane. 
   NOTE: Comparing slopes works poorly for nearly vertical lines. 
   Learn some linear algebra if you need to do these computations in
   a real application.
*/
public class Line
{
   private double slope;
   private double intercept;
   private boolean isVertical;
   private static double EPSILON = 0.00001;

   
   /**
      Constructs a line that is given by a point and the slope
      @param x the x-coordinate of the point
      @param y the y-coordinate of the point
      @param m the slope of the line
   */
   public Line(double x, double y, double m)
   {
      slope = m;
      intercept = y - m * x;
      isVertical = false;
   }

   /**
      Constructs a line that is given by two points
      @param x1 the x-coordinate of the first point
      @param y1 the y-coordinate of the first point
      @param x2 the x-coordinate of the second point
      @param y2 the y-coordinate of the second point
   */
   public Line(double x1, double y1, double x2, double y2)
   {
      if (x1 == x2) 
      {
         isVertical = true;
         intercept = x1;
      }
      else
      {
         slope = (y2 - y1) / (x2 - x1);
         intercept = y1 - slope * x1;         
         isVertical = false;
      }
   }

   /**
      Constructs a line that is given by the slope and y-intercept
      @param m the slope of the line
      @param b the y-intercept of the line
   */
   public Line(double m, double b)
   {
      slope = m;
      intercept = b;
      isVertical = false;
   }

   /**
      Constructs a vertical line that is given by the x-intercept
      @param b the x-intercept of the line
   */
   public Line(double a)
   {
      intercept = a;
      isVertical = true;
   }

   public boolean intersects(Line other)
   {
      return equals(other) || !isParallel(other);
   }

   public boolean equals(Line other)
   {
      if (isVertical)
      {
         return Math.abs(intercept - other.intercept) < EPSILON;
      }
      else
      {
         return Math.abs(slope - other.slope) < EPSILON
            && Math.abs(intercept - other.intercept) < EPSILON;
       }
   }

   public boolean isParallel(Line other)
   {
      return isVertical && other.isVertical
         || Math.abs(slope - other.slope) < EPSILON;
   }
}
