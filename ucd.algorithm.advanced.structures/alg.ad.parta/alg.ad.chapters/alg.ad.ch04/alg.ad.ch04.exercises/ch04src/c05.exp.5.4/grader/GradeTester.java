public class GradeTester
{
   public static void main(String[] args)
   {
      System.out.println(new Grade("A").getNumericGrade());
      System.out.println("Expected: 4");
      System.out.println(new Grade("A+").getNumericGrade());
      System.out.println("Expected: 4");
      System.out.println(new Grade("A-").getNumericGrade());
      System.out.println("Expected: 3.7");
      System.out.println(new Grade("C").getNumericGrade());
      System.out.println("Expected: 2");
      System.out.println(new Grade("C+").getNumericGrade());
      System.out.println("Expected: 2.3");
      System.out.println(new Grade("C-").getNumericGrade());
      System.out.println("Expected: 1.7");
      System.out.println(new Grade("F").getNumericGrade());
      System.out.println("Expected: 0");
  }
}
