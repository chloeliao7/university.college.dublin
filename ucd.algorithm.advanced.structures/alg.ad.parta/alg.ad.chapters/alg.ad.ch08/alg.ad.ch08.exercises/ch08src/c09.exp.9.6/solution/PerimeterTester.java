import java.awt.Rectangle;

/**
   This program tests the measurement of rectangles by perimeter.
*/
public class PerimeterTester
{
   public static void main(String[] args)
   {
      Measurer m = new PerimeterMeasurer();

      DataSet data = new DataSet(m);

      data.add(new Rectangle(5, 10, 20, 30));
      data.add(new Rectangle(10, 20, 30, 40));
      data.add(new Rectangle(20, 30, 5, 10));

      System.out.println("Average perimeter: " + data.getAverage());
      System.out.println("Expected: 90");
      Rectangle max = (Rectangle) data.getMaximum();
      System.out.println("Largest perimeter: " + max);
      System.out.println("Expected: java.awt.Rectangle[x=10,y=20,width=30,height=40]");
   }
}
