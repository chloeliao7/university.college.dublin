/**
   This program tests the Employee class.
*/
public class EmployeeTester2
{  
   public static void main(String[] args)
   {  
      Employee richard = new Employee("Poor Richard", 30000);
      System.out.println(richard.getName());
      System.out.println("Expected: Poor Richard");
      richard.raiseSalary(5);
      System.out.println(richard.getSalary());
      System.out.println("Expected: 31500");
      
      Employee boss = new Employee("Boss Tweed", 200000);
      System.out.println(boss.getName());
      System.out.println("Expected: Boss Tweed");
      boss.raiseSalary(25);
      System.out.println(boss.getSalary());
      System.out.println("Expected: 250000");
      
   }
}

