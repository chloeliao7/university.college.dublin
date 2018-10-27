import java.awt.Rectangle;

/**
   A square is represented by the sides and the area.
*/
public class Square extends Rectangle
{
   /**
      Constructs a Square object.
      @param x the x coordinate of the center of the square
      @param y the y coordinate of the center of the square
      @param w the side length
   */
   public Square(int x, int y, int w)
   {
      setLocation(x - w / 2, y - w / 2);
      setSize(w, w);
   }

   /**
      Computes the area of the square
      @return area of the square
   */
   public double getArea()
   {
      return getWidth() * getWidth();
   }
}