import java.util.Scanner;

/**
   Tests the DataSet class.
 */
public class DataSetTester
{
   public static void main(String[] args)
   {
      DataSet myDataSet = new DataSet();
      myDataSet.addValue(13);
      myDataSet.addValue(-2);
      myDataSet.addValue(3);
      myDataSet.addValue(0);

      System.out.println("Sum: " + myDataSet.getSum());
      System.out.println("Expected: 14");
      System.out.println("Average: " + myDataSet.getAverage());
      System.out.println("Expected: 3.5");
   }
}
