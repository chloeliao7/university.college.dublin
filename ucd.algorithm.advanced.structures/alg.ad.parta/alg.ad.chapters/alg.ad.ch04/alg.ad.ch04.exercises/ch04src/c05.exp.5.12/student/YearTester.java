public class YearTester
{
   public static void main(String[] args)
   {
      Year y = new Year(1980);
      System.out.println(y.isLeapYear());
      System.out.println("Expected: true");
      y = new Year(1900);
      System.out.println(y.isLeapYear());
      System.out.println("Expected: false");
      y = new Year(2000);
      System.out.println(y.isLeapYear());
      System.out.println("Expected: true");
      y = new Year(1500);
      System.out.println(y.isLeapYear());
      System.out.println("Expected: true");
      y = new Year(1501);
      System.out.println(y.isLeapYear());
      System.out.println("Expected: false");
   }
}
