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

      ChoiceQuestion question2 = new ChoiceQuestion(
         "In which country was the inventor of Java born?");
      question2.addChoice("Australia", false);
      question2.addChoice("Denmark", false);
      question2.addChoice("Canada", true);
      question2.addChoice("United States", false);
      quiz[3] = question2;

      quiz[4] = new Question("Who was the inventor of Java?");
      quiz[4].setAnswer("James Gosling");      

      ChoiceQuestion question3 = new ChoiceQuestion(
         "In which country was the inventor of Java born?");
      question3.addChoice("Australia", false);
      question3.addChoice("Canada", true);
      question3.addChoice("Denmark", false);
      question3.addChoice("United States", false);
      quiz[5] = question3;    

      /* test equals and toString for Question class */
      System.out.println(quiz[0].toString());
      System.out.println("Expected: Question[text=Who was the inventor of Java?,answer=James Gosling]");
      System.out.println(quiz[2].toString());
      System.out.println("Expected: Question[text=Who was the inventor of C++?,answer=Bjarne Stroustrup]");
      System.out.println(quiz[0].equals(quiz[2]));
      System.out.println("Expected: false");
      System.out.println(quiz[0].equals(quiz[4]));
      System.out.println("Expected: true");

      /* test equals and toString for ChoiceQuestion class */
      System.out.println(quiz[1].toString());
      System.out.println("Expected: ChoiceQuestion[text=In which country was the inventor of Java born?,answer=2][choices=[Australia, Canada, Denmark, United States]]");
      System.out.println(quiz[3].toString());
      System.out.println("Expected: ChoiceQuestion[text=In which country was the inventor of Java born?,answer=3][choices=[Australia, Denmark, Canada, United States]]");
      System.out.println(quiz[1].equals(quiz[3]));
      System.out.println("Expected: false");
      System.out.println(quiz[1].equals(quiz[5]));
      System.out.println("Expected: true");
   }
}

