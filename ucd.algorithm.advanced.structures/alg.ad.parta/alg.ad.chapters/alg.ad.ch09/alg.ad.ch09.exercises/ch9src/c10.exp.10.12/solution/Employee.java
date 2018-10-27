/**
   An employee with salary.
*/
public class Employee
{  
   private String name;
   private double salary;

   /**
      Construct an Employee object.
      @param n the name of the employee
      @param s the salary of the employee
   */
   public Employee(String n, double s)
   {  
      name = n;
      salary = s;
   }

   /**
      Returns the string represention of the object.
      @return a string representation of the object
   */
   public String toString()
   {  
      return "Employee[name=" + name + ",salary=" + salary + "]";
   }
}