import java.awt.Rectangle;

/**
   Prints a rectangle, then translates it, and grows it so that
   the new square is twice the size of the original and has the
   same top-left corner.
*/
public class GrowSquarePrinter
{  
   public static void main(String[] args)
   {  
      /*
         Rectangles are created with x, y, width, height
         where x and y are the upper left corner of the object.
         We want the center of the square at 100, 100 and the
         sides to be 50. The upper left corner coordinate will
         be at 75, 75 for the center to be at 100, 100.
      */
      Rectangle square = new Rectangle(75, 75, 50, 50);
      System.out.println(square);

      /*
         The grow(h,v) method resizes the object both vertically and
         horizontally. The new object has (x-h, y-v) as its upper
         left corner, width of (w + 2h) and (height of h + 2v).
      */
      square.grow(25, 25);

      /*
         Use translate to reposition the top-left corner back to 75, 75.
      */
      square.translate(25, 25);
      System.out.println(square);
   }
}




