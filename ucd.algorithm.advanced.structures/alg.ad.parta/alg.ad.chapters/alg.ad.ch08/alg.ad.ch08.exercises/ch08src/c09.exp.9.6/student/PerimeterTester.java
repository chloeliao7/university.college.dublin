import java.awt.Rectangle;

/**
   This program tests the measurement of rectangles by perimeter.
*/
public class PerimeterTester
{
   public static void main(String[] args)
   {
      DataSet data = . . .;

      data.add(new Rectangle(5, 10, 20, 30));
      data.add(new Rectangle(10, 20, 30, 40));
      data.add(new Rectangle(20, 30, 5, 10));

      double avg = . . .;
      Rectangle max = . . .;

      System.out.println("Average perimeter: " + avg);
      System.out.println("Expected: ");
      System.out.println("Largest perimeter: " + max);
      System.out.println("Expected: ");
   }
}
