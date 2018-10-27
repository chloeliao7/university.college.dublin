/**
   A student is represented by the name, birth year, and major.
*/
public class Student extends Person
{
   private String major;

   /**
      Construct a Student object.
      @param n the name of the student
      @param byear the birth year
      @param m the major
   */
   public Student(String n, int byear, String m)
   {
      super(n, byear);
      major = m;
   }

   /**
      Returns the string representation of the object.
      @return a string representation of the object
   */
   public String toString()
   {
      return "Student[super=" + super.toString() + ",major=" + major + "]";
   }
}