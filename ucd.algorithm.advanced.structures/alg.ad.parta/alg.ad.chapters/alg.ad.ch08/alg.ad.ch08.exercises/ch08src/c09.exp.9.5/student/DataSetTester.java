import java.awt.Rectangle;

/**
   This program demonstrates the use of a Measurer.
*/
public class DataSetTester
{
   public static void main(String[] args)
   {
      Measurer m = new RectangleMeasurer();

      DataSet data = new DataSet(m);

      data.add(new Rectangle(5, 10, 20, 30));
      data.add(new Rectangle(10, 20, 30, 40));
      data.add(new Rectangle(20, 30, 5, 15));

      System.out.println("Average area: " + data.getAverage());
      System.out.println("Expected: 625");

      Rectangle min = (Rectangle) data.getMinimum();
      System.out.println("Minimum area rectangle: " + min);
      System.out.println("Expected: java.awt.Rectangle[x=20,y=30,width=5,height=15]");
   }
}
