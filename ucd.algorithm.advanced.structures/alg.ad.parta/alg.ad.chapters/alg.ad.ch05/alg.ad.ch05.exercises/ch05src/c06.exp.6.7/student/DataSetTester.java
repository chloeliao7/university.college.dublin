import java.util.Scanner;

/**
   This is a test driver class for DataSet class.
*/
public class DataSetTester
{
   public static void main(String[] args)
   {
      DataSet a = new DataSet();
      a.add(5);
      a.add(6);
      a.add(8);
      a.add(9);
      System.out.println("count: " + a.getCount());
      System.out.println("Expected: 4");
      System.out.println("average: " + a.getAverage());
      System.out.println("Expected: 7");
      System.out.println("standard deviation: " + a.getStandardDeviation());
      System.out.println("Expected: 1.83");
   }
}
