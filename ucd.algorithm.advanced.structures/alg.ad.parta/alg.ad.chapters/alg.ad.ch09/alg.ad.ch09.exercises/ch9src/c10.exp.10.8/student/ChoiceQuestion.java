/**
   A question with multiple choices.
*/
public class ChoiceQuestion extends Question
{
   // Add any needed instance variables, but don't store the choices
   // The choices should be added to the text of the superclass
   
   /**
      Constructs a choice question with a given text and no choices.
      @param questionText the text of this question
   */
   public ChoiceQuestion(String questionText)
   {
      ...
   }

   /**
      Adds an answer choice to this question.
      @param choice the choice to add
      @param correct true if this is the correct choice, false otherwise
   */
   public void addChoice(String choice, boolean correct)
   {
      ...
   }
}

