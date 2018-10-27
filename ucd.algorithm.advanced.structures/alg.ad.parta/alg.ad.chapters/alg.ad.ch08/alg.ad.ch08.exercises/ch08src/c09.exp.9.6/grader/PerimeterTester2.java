import java.awt.Rectangle;

/**
   This program demonstrates the use of a Measurer.
*/
public class PerimeterTester2
{
   public static void main(String[] args)
   {
      Measurer m = new PerimeterMeasurer();

      DataSet data = new DataSet(m);

      data.add(new Rectangle(10, 10, 20, 20));
      data.add(new Rectangle(5, 10, 10, 10));
      data.add(new Rectangle(20, 30, 50, 15));
      data.add(new Rectangle(0, 0, 100, 100));

      System.out.println("Average perimeter: " + data.getAverage());
      System.out.println("Expected: 162.5");
      Rectangle max = (Rectangle) data.getMaximum();
      System.out.println("Largest perimeter: " + max);
      System.out.println("Expected: java.awt.Rectangle[x=0,y=0,width=100,height=100]");
   }
}
