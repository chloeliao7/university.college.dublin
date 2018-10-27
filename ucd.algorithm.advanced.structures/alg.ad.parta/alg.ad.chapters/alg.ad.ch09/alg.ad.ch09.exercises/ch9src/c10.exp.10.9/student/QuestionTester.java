import java.util.Scanner;

public class QuestionTester
{
   public static void main(String[] args)
   {
      Question[] quiz = new Question[6];

      quiz[0] = new Question("Who was the inventor of Java?");
      quiz[0].setAnswer("James Gosling");      

      ChoiceQuestion question = new ChoiceQuestion(
         "In which country was the inventor of Java born?");
      question.addChoice("Australia", false);
      question.addChoice("Canada", true);
      question.addChoice("Denmark", false);
      question.addChoice("United States", false);
      quiz[1] = question;

      quiz[2] = new Question("Who was the inventor of C++?");
      quiz[2].setAnswer("Bjarne Stroustrup");      

      /* test equals and toString for Question class */
      System.out.println(quiz[0].toString());
      System.out.println("Expected: Question[text=Who was the inventor of Java?,answer=James Gosling]");
      System.out.println(quiz[0].equals(quiz[2]));
      System.out.println("Expected: false");

      /* test equals and toString for ChoiceQuestion class */
      System.out.println(quiz[1].toString());
      System.out.println("Expected: ChoiceQuestion[text=In which country was the inventor of Java born?,answer=2][choices=[Australia, Canada, Denmark, United States]]");
      System.out.println(quiz[1].equals(quiz[1]));
      System.out.println("Expected: true");
   }
}

