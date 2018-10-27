/**
   This class tests the Person, Student, and Instructor classes.
*/
public class PersonTester2
{
   public static void main(String[] args)
   {
      Person p1 = new Person("John", 1965);
      Person p2 = new Person("Mary Ann", 1970);
      Student s1 = new Student("Ann", 1982, "Computer Science");
      Student s2 = new Student("Thomas", 1986, "Biology");      
      Instructor e = new Instructor("Joseph", 1954, 65000);
      System.out.println(p1);
      System.out.println("Expected: Person[name=John,birthYear=1965]");
      System.out.println(p2);
      System.out.println("Expected: Person[name=Mary Ann,birthYear=1970]");
      System.out.println(s1);
      System.out.println("Expected: Student[super=Person[name=Ann,birthYear=1982],major=Computer Science]");
      System.out.println(s2);
      System.out.println("Expected: Student[super=Person[name=Thomas,birthYear=1986],major=Biology]");
      System.out.println(e);
      System.out.println("Expected: Instructor[super=Person[name=Joseph,birthYear=1954],salary=65000.0]");
   }
}
