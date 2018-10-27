import java.util.Scanner;

public class QuestionDemo
{
   public static void main(String[] args)
   {
      Question[] quiz = new Question[2];

      AnyCorrectChoiceQuestion question0 = new AnyCorrectChoiceQuestion(
         "Which countries are in Africa?");
      question0.addChoice("Ghana", true);
      question0.addChoice("Canada", false);
      question0.addChoice("Benin", true);
      question0.addChoice("Denmark", false);
      quiz[0] = question0;

      AnyCorrectChoiceQuestion question1 = new AnyCorrectChoiceQuestion(
         "Which of the following are vegetables?");
      question1.addChoice("Zuchini", true);
      question1.addChoice("Pepper", true);
      question1.addChoice("Banana", false);
      question1.addChoice("Cabbage", true);
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

