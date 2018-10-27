public class DataSetTester
{
   public static void main(String[] args)
   {
      DataSet ds = new DataSet(2, -1, 0);
      System.out.println(ds.getSmallest());
      System.out.println("Expected: -1");
      System.out.println(ds.getMiddle());
      System.out.println("Expected: 0");
      System.out.println(ds.getLargest());
      System.out.println("Expected: 2");
      
      ds = new DataSet(2, 0, -1);
      System.out.println(ds.getSmallest());
      System.out.println("Expected: -1");
      System.out.println(ds.getMiddle());
      System.out.println("Expected: 0");
      System.out.println(ds.getLargest());
      System.out.println("Expected: 2");

      ds = new DataSet(0, -1, 2);
      System.out.println(ds.getSmallest());
      System.out.println("Expected: -1");
      System.out.println(ds.getMiddle());
      System.out.println("Expected: 0");
      System.out.println(ds.getLargest());
      System.out.println("Expected: 2");

      ds = new DataSet(0, 2, -1);
      System.out.println(ds.getSmallest());
      System.out.println("Expected: -1");
      System.out.println(ds.getMiddle());
      System.out.println("Expected: 0");
      System.out.println(ds.getLargest());
      System.out.println("Expected: 2");

      ds = new DataSet(-1, 2, 0);
      System.out.println(ds.getSmallest());
      System.out.println("Expected: -1");
      System.out.println(ds.getMiddle());
      System.out.println("Expected: 0");
      System.out.println(ds.getLargest());
      System.out.println("Expected: 2");

      ds = new DataSet(-1, 0, 2);   
      System.out.println(ds.getSmallest());
      System.out.println("Expected: -1");
      System.out.println(ds.getMiddle());
      System.out.println("Expected: 0");
      System.out.println(ds.getLargest());
      System.out.println("Expected: 2");

      ds = new DataSet(2, -1, 0);
      System.out.println(ds.getSmallest());
      System.out.println("Expected: -1");
      System.out.println(ds.getMiddle());
      System.out.println("Expected: 0");
      System.out.println(ds.getLargest());
      System.out.println("Expected: 2");      
   }
}
