/**
   A question with multiple choices.
*/
public class ChoiceQuestion extends Question
{
   private int numChoices;

   /**
      Constructs a choice question with a given text and no choices.
      @param questionText the text of this question
   */
   public ChoiceQuestion(String questionText)
   {
      super(questionText);
      numChoices = 0;
   }

   /**
      Adds an answer choice to this question.
      @param choice the choice to add
      @param correct true if this is the correct choice, false otherwise
   */
   public void addChoice(String choice, boolean correct)
   {
      numChoices++;
      addLine(numChoices + ": " + choice);

      if (correct) 
      {
         // Convert choices.size() to string
         String choiceString = "" + numChoices;
         setAnswer(choiceString);
      }
   }
}

