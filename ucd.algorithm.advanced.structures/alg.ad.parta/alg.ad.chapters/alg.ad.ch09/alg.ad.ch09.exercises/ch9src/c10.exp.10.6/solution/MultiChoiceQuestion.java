import java.util.ArrayList;

/**
   A question with multiple choices and multiple
   correct answers possible. All correct answers must be
   chosen for the question to be marked correct.
*/
public class MultiChoiceQuestion extends Question
{
   private ArrayList<String> choices;
   private String choiceString = "";

   /**
      Constructs a choice question with a given text and no choices.
      @param questionText the text of this question
   */
   public MultiChoiceQuestion(String questionText)
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
         if (choiceString.length() == 0)
            choiceString = "" + choices.size();
         else
         // else separate with space
            choiceString += " " + choices.size();
      }
   }
   
   /**
      Checks a given response for correctness.
      @param response the response to check
      @return true if the response was correct, false otherwise
   */
   public boolean checkAnswer(String response)
   {
      return response.equals(choiceString);
   }

   public void display()
   {
      // Display the question text
      super.display();

      // Display the answer choices
      for (int i = 0; i < choices.size(); i++)
      {
         int choiceNumber = i + 1;
         System.out.println(choiceNumber + ": " + choices.get(i));     
      }
   }
}

