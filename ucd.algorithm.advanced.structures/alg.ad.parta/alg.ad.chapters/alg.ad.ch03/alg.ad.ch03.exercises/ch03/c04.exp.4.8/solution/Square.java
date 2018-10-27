/**
   This class models a square. 
*/
public class Square
{
   private double length;

   /**
      Constructs a square.
      @param aLength the side length of a square
   */
   public Square(double aLength)
   {
      length = aLength;
   }

   /**
      Gets the area of this square.
      @return area of the square
   */
   public double getArea()
   {
      return length * length;
   }

   /**
      Gets the perimeter of this square.
      @return perimeter of the square
   */
   public double getPerimeter()
   {
      return 4 * length;
   }

   /**
      Gets the length of the diagonal of this square.
      @return diagonal length of the square
   */
   public double getDiagonalLength()
   {
      return Math.sqrt(2) * length;
   }
}
