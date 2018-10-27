/**
   This program tests the Employee class and its subclasses.
*/
public class EmployeeTester2
{  
   public static void main(String[] args)
   {  
      Employee e1 = new Employee("Edgar", 65000);
      Employee e2 = new Employee("John", 70000);      
      Manager m = new Manager("Mary Jo Brown", 80000, "Engineering");
      Executive v = new Executive("Veronica Poobah", 120000, "Plant Engineering");
      System.out.println(e1);
      System.out.println("Expected: Employee[name=Edgar,salary=65000.0]");
      System.out.println(e2);
      System.out.println("Expected: Employee[name=John,salary=70000.0]");
      System.out.println(m);
      System.out.println("Expected: Manager[super=Employee[name=Mary Jo Brown,salary=80000.0],department=Engineering]");
      System.out.println(v);
      System.out.println("Expected: Executive[super=Manager[super=Employee[name=Veronica Poobah,salary=120000.0],department=Plant Engineering]]");
   }
}
