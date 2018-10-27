import java.util.Scanner;

public class QuestionDemo
{
   public static void main(String[] args)
   {
      Question[] quiz = new Question[2];

      quiz[0] = new Question("Who was the inventor of Java?");
      quiz[0].setAnswer("James Gosling");      

      NumericQuestion question = new NumericQuestion(
         "What is 3 / 4?");
      question.setAnswer(0.75);
      quiz[1] = question;

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

