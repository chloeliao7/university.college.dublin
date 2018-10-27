/**
   This program tests the Student class.
*/
public class StudentTester2
{  
   public static void main(String[] args)
   {  
      Student student = new Student("Cracker, Carla");
      
      student.addQuiz(8);
      student.addQuiz(7);
      student.addQuiz(9);

      System.out.println(student.getName());
      System.out.println("Expected: Cracker, Carla");      

      System.out.print("Total score: ");
      System.out.println(student.getTotalScore());
      System.out.println("Expected: 24");
      System.out.print("Average: ");
      System.out.println(student.getAverageScore());
      System.out.println("Expected: 8");

      student.addQuiz(8);

      System.out.print("Total score: ");
      System.out.println(student.getTotalScore());
      System.out.println("Expected: 32");
      System.out.print("Average: ");
      System.out.println(student.getAverageScore());
      System.out.println("Expected: 8");
   }
}

