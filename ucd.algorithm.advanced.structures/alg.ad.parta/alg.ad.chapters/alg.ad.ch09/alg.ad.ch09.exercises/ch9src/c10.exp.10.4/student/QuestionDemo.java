import java.util.Scanner;

public class QuestionDemo
{
   public static void main(String[] args)
   {
      Question[] quiz = new Question[2];

      FillInQuestion question0 = new FillInQuestion(
         "_James Gosling_ was the inventor of Java.");
      quiz[0] = question0;

      FillInQuestion question1 = new FillInQuestion(
         "The first U.S. president was _George Washington_");
      quiz[1] = question1;

      Scanner in = new Scanner(System.in);
      for (Question q : quiz)
      {
         q.display();
         System.out.println("Your answer: ");
         String response = in.nextLine();
         System.out.println(q.checkAnswer(response));      
      }
   }
}

