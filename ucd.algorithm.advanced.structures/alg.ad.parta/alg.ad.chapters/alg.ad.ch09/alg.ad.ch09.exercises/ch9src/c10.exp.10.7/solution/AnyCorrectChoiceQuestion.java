import java.util.ArrayList;

/**
   A question with multiple choices and multiple
   correct answers possible. Any correct answers will be
   accepted for the question to be marked correct.
*/
public class AnyCorrectChoiceQuestion extends Question
{
   private ArrayList<String> choices;
   private String choiceString;

   /**
      Constructs a choice question with a given text and no choices.
      @param questionText the text of this question
   */
   public AnyCorrectChoiceQuestion(String questionText)
   {
      super(questionText);
      choices = new ArrayList<String>();
   }

   /**
      Adds an answer choice to this question.
      @param choice the choice to add
      @param correct true if this is the correct choice, false otherwise
   */
   public void addChoice(String choice, boolean correct)
   {
      choices.add(choice);

      // Convert choices.size() to string
      if (correct) 
      {
         // if this is the first correct answer
         if (choiceString == null)
            choiceString = "" + choices.size();
         else
         // else separate with spaces
            choiceString += " " + choices.size();
      }
   }
   
   /**
      Checks a given response for correctness.
      The answer string will have all correct responses separated
      by a blank. A correct answer should provide any one of
      the correct choices.
      @param response the response to check
      @return true if the response was correct, false otherwise
   */
   public boolean checkAnswer(String response)
   {
      // indexOf returns a -1 if the substring is not part of the string
      return choiceString.indexOf(response) > -1;
   }

   public void display()
   {
      // Display the question text
      super.display();

      // Add instructions to indicate multiple
      // correct answers are possible
      System.out.println("Provide any one of the correct choices.");

      // Display the answer choices
      for (int i = 0; i < choices.size(); i++)
      {
         int choiceNumber = i + 1;
         System.out.println(choiceNumber + ": " + choices.get(i));     
      }
   }
}

