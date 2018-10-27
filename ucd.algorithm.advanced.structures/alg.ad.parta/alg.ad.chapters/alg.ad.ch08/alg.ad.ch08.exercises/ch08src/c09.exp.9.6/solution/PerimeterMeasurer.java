import java.awt.Rectangle;

public class PerimeterMeasurer implements Measurer
{
   public double measure(Object anObject)
   {
      Rectangle aRectangle = (Rectangle) anObject;
      double perimeter 
                  = (2 * aRectangle.getWidth()) + (2 * aRectangle.getHeight());
      return perimeter;
   }
}

