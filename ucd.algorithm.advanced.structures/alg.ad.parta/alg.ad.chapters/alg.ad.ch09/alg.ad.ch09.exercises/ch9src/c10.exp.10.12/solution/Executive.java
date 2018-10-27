/**
   An executive with a salary working for a certain department.
*/
public class Executive extends Manager
{  
   public Executive(String n, double s, String d)
   {  
      super(n, s, d);
   }

   /**
      Returns the string represention of the object.
      @return a string representation of the object
   */
   public String toString()
   {  
      return "Executive[super=" + super.toString() + "]";
   }
}