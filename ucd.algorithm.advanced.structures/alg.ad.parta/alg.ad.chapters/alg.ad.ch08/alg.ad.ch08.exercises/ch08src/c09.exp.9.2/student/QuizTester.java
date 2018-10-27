/**
   This program tests the Quiz and DataSet classes.
*/
public class QuizTester
{
   public static void main(String[] args)
   {
      DataSet quizData = new DataSet();
      Quiz q1 = new Quiz(89, "B+");
      Quiz q2 = new Quiz(90, "A-");
      Quiz q3 = new Quiz(73, "C");
      
      quizData.add(q1);
      quizData.add(q2);
      quizData.add(q3);
      
      double avg = . . .;
      Quiz max = . . .;

      System.out.println("Average score: " + avg);
      System.out.println("Expected: 84");
 
      System.out.println("Highest score: " + max.getScore());
      System.out.println("Expected: 90");

      System.out.println("Highest grade: " + max.getGrade());
      System.out.println("Expected: A-");
   }
}
