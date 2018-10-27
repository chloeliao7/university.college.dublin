/**
   A manager with salary working for a certain department.
*/
public class Manager extends Employee
{ 
   private String department;

   /**
      Construct a Manager object.
      @param n the name of the manager
      @param s the salary of the manager
      @param d the department where the manager works
   */
   public Manager(String n, double s, String d)
   {  
      super(n, s);
      department = d;
   }

   /**
      Returns the string represention of the object.
      @return a string representation of the object
   */
   public String toString()
   {  
      return "Manager[super=" + super.toString() + ",department=" + department + "]";
   }
}