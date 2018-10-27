public class MonthTester
{
   public static void main(String[] args)
   {
      Month m = new Month(1);
      System.out.println(m.getDays());
      System.out.println("Expected: 31");
      m = new Month(2);
      System.out.println(m.getDays());
      System.out.println("Expected: 28");
      m = new Month(3);
      System.out.println(m.getDays());
      System.out.println("Expected: 31");
      m = new Month(4);
      System.out.println(m.getDays());
      System.out.println("Expected: 30");
      m = new Month(5);
      System.out.println(m.getDays());
      System.out.println("Expected: 31");
      m = new Month(6);
      System.out.println(m.getDays());
      System.out.println("Expected: 30");
      m = new Month(7);
      System.out.println(m.getDays());
      System.out.println("Expected: 31");
      m = new Month(8);
      System.out.println(m.getDays());
      System.out.println("Expected: 31");
      m = new Month(9);
      System.out.println(m.getDays());
      System.out.println("Expected: 30");
      m = new Month(10);
      System.out.println(m.getDays());
      System.out.println("Expected: 31");
      m = new Month(11);
      System.out.println(m.getDays());
      System.out.println("Expected: 30");
      m = new Month(12);
      System.out.println(m.getDays());
      System.out.println("Expected: 31");
   }
}
