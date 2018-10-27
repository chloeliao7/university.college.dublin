import java.awt.Rectangle;

/**
   This program tests a data set that can be used with measurers
   and measurables.
*/
public class DataSetTester2
{
   public static void main(String[] args)
   {
      class RectangleMeasurer implements Measurer
      {
         public double measure(Object anObject)
         {
            Rectangle aRectangle = (Rectangle) anObject;
            double area = aRectangle.getWidth() * aRectangle.getHeight();
            return area;
         }
      }

      Measurer m = new RectangleMeasurer();

      DataSet d = new DataSet(m);

      d.add(new Rectangle(10, 10, 20, 20));
      d.add(new Rectangle(5, 10, 10, 10));
      d.add(new Rectangle(20, 30, 50, 15));
      d.add(new Rectangle(0, 0, 100, 100));

      System.out.println("Average area: " + d.getAverage());
      System.out.println("Expected: 2812.5");

      Object max = d.getMaximum();
      System.out.println("Largest area: " + m.measure(max));
      System.out.println("Expected: 10000");


      // Test the default Measurer
      
      d = new DataSet();

      d.add(new BankAccount(2000));
      d.add(new BankAccount(300));
      d.add(new BankAccount(100));

      System.out.println("Average balance: " + d.getAverage());
      System.out.println("Expected: 800");
      Measurable max2 = (Measurable) d.getMaximum();
      System.out.println("Highest balance: " + max2.getMeasure());
      System.out.println("Expected: 2000");      
   }
}
