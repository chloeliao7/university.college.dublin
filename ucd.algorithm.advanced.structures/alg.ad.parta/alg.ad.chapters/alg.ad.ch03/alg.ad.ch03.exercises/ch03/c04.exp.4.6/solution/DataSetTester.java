import java.util.Scanner;

/**
   This program tests the DataSet class.
 */
public class DataSetTester
{
   public static void main(String[] args)
   {
      DataSet myDataSet = new DataSet();
      myDataSet.addValue(11);
      myDataSet.addValue(-2);
      myDataSet.addValue(3);
      myDataSet.addValue(0);
      System.out.println("Largest: " + myDataSet.getLargest());
      System.out.println("Expected: 11");      
      System.out.println("Smallest: " + myDataSet.getSmallest());
      System.out.println("Expected: -2");
   }
}
