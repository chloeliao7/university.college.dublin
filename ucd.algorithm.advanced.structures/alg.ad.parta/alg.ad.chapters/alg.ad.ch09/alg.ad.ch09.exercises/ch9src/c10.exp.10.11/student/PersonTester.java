/**
   This class tests the Person, Student, and Instructor classes.
*/
public class PersonTester
{
   public static void main(String[] args)
   {
      Person p = new Person("Perry", 1959);
      Student s = new Student("Sylvia", 1979, "Computer Science");
      Instructor e = new Instructor("Edgar", 1969, 65000);
      System.out.println(p);
      System.out.println("Expected: Person[name=Perry,birthYear=1959]");
      System.out.println(s);
      System.out.println("Expected: Student[super=Person[name=Sylvia,birthYear=1979],major=Computer Science]");
      System.out.println(e);
      System.out.println("Expected: Instructor[super=Person[name=Edgar,birthYear=1969],salary=65000.0]");
   }
}
