import java.awt.Rectangle;

/**
   This program tests a data set that can be used with measurers
   and measurables.
*/
public class DataSetTester
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

      d.add(new Rectangle(5, 10, 20, 30));
      d.add(new Rectangle(10, 20, 30, 40));
      d.add(new Rectangle(20, 30, 5, 10));

      System.out.println("Average area: " + d.getAverage());
      System.out.println("Expected: 616.6666667");

      Object max = d.getMaximum();
      System.out.println("Largest area: " + m.measure(max));
      System.out.println("Expected: 1200");


      // Test the default Measurer
      
      d = new DataSet();

      d.add(new BankAccount(2000));
      d.add(new BankAccount(200));
      d.add(new BankAccount(20000));

      System.out.println("Average balance: " + d.getAverage());
      System.out.println("Expected: 7400");
      Measurable max2 = (Measurable) d.getMaximum();
      System.out.println("Highest balance: " + max2.getMeasure());
      System.out.println("Expected: 20000");      
   }
}
