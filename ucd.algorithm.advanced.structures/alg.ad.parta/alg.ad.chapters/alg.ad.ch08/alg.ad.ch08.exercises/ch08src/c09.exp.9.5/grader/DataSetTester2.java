import java.awt.Rectangle;

/**
   This program demonstrates the use of a Measurer.
*/
public class DataSetTester2
{
   public static void main(String[] args)
   {
      Measurer m = new RectangleMeasurer();

      DataSet data = new DataSet(m);

      data.add(new Rectangle(10, 10, 20, 20));
      data.add(new Rectangle(5, 10, 10, 10));
      data.add(new Rectangle(20, 30, 50, 15));
      data.add(new Rectangle(0, 0, 100, 100));

      System.out.println("Average area: " + data.getAverage());
      System.out.println("Expected: 2812.5");

      Rectangle min = (Rectangle) data.getMinimum();
      System.out.println("Minimum area rectangle: " + min);
      System.out.println("Expected: java.awt.Rectangle[x=5,y=10,width=10,height=10]");
   }
}
