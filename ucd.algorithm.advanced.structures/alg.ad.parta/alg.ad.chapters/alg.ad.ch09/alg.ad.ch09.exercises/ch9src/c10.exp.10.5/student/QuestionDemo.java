import java.util.Scanner;

public class QuestionDemo
{
   public static void main(String[] args)
   {
      Question[] quiz = new Question[2];

      quiz[0] = new Question("Who was the inventor of Java?");
      quiz[0].setAnswer("James Gosling");      

      quiz[1] = new Question("What computer device did Douglas Engelbart invent?");
      quiz[1].setAnswer("mouse");      

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

