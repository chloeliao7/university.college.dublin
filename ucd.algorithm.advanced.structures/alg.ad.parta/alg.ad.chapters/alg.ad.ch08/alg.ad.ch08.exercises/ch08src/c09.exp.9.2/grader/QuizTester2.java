/**
   This program tests the Quiz and DataSet classes.
*/
public class QuizTester2
{
   public static void main(String[] args)
   {
      DataSet quizData = new DataSet();
      Quiz q1 = new Quiz(89, "B+");
      Quiz q2 = new Quiz(90, "A-");
      Quiz q3 = new Quiz(73, "C");
      Quiz q4 = new Quiz (50, "F");
      Quiz q5 = new Quiz (100, "A+");
      
      quizData.add(q1);
      quizData.add(q2);
      quizData.add(q3);
      quizData.add(q4);
      quizData.add(q5);
      double avg = quizData.getAverage();
      Quiz max = (Quiz) quizData.getMaximum();

      System.out.println("Average score: " + avg);
      System.out.println("Expected: 80.4");
 
      System.out.println("Highest score: " + max.getScore());
      System.out.println("Expected: 100");

      System.out.println("Highest grade: " + max.getGrade());
      System.out.println("Expected: A+");
   }
}
