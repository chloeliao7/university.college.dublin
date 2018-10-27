public class GradeTester
{
   public static void main(String[] args)
   {
      System.out.println(new Grade(4).getLetterGrade());
      System.out.println("Expected: A");
      System.out.println(new Grade(4.2).getLetterGrade());
      System.out.println("Expected: A+");
      System.out.println(new Grade(2.85).getLetterGrade());
      System.out.println("Expected: B");
      System.out.println(new Grade(2.84).getLetterGrade());
      System.out.println("Expected: B-");
      System.out.println(new Grade(0.1).getLetterGrade());
      System.out.println("Expected: F");
      System.out.println(new Grade(0.49).getLetterGrade());
      System.out.println("Expected: F");
      System.out.println(new Grade(0.51).getLetterGrade());
      System.out.println("Expected: D-");
  }
}
