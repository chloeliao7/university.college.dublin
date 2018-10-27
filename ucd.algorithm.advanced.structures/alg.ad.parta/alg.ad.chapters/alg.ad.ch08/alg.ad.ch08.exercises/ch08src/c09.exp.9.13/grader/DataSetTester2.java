/**
   This program demonstrates the use of the DataSet that accepts
   instances of the Comparable interface.
*/
public class DataSetTester2
{
   public static void main(String[] args)
   {
      DataSet data = new DataSet();

      data.add("Helen");
      data.add("Andy");
      data.add("Robert");
      data.add("Vicky");  
      data.add("Andrew");
      data.add("Zach");    

      Comparable max = data.getMaximum();
      Comparable min = data.getMinimum();
      System.out.println("Maximum: " + max);
      System.out.println("Expected: Zach");
      System.out.println("Minimum: " + min);
      System.out.println("Expected: Andrew");
    }
}
