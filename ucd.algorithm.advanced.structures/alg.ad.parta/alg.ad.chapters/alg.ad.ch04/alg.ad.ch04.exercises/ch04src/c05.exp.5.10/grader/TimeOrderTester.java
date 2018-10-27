public class TimeOrderTester
{  
   public static void main(String[] args)
   {  
      Time t1 = new Time(3, 45);
      Time t2 = new Time(23, 10);
      Time t3 = new Time(3, 15);
      System.out.println(t1.compareWith(t2));
      System.out.println("Expected: before");
      System.out.println(t1.compareWith(t3));
      System.out.println("Expected: after");   
      System.out.println(t3.compareWith(t1));                       
      System.out.println("Expected: before");
      System.out.println("\"" + t3.compareWith(t3) + "\"");         
      System.out.println("Expected: \"\"");      
   }
}
