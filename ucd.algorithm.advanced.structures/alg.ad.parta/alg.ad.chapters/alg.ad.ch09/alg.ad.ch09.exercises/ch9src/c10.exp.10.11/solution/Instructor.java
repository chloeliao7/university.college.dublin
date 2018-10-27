/**
   An instructor is represented by a name, a birth year, and a salary.
*/
public class Instructor extends Person
{
   private double salary;

   /**
      Construct an Instructor object.
      @param n the name of the instructor
      @param byear the birth year
      @param s the salary
   */
   public Instructor(String n, int byear, double s)
   {
      super(n, byear);
      salary = s;
   }

   /**
      Returns the string represention of the object.
      @return a string representation of the object
   */
   public String toString()
   {
      return "Instructor[super=" + super.toString() + ",salary=" + salary + "]";
   }
}