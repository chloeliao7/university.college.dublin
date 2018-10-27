import java.util.ArrayList;

/**
   A question with multiple choices.
*/
public class ChoiceQuestion extends Question
{
   private ArrayList<String> choices;

   /**
      Constructs a choice question with a given text and no choices.
      @param questionText the text of this question
   */
   public ChoiceQuestion(String questionText)
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
      if (correct) 
      {
         // Convert choices.size() to string
         String choiceString = "" + choices.size();
         setAnswer(choiceString);
      }
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

   /**
      toString
   */
   public String toString()
   {
      return super.toString() + "[choices=" + choices + "]";
   }

   /**
      equals - override inherited method
         determines whether two objects have the same contents
   */
   public boolean equals(Object otherObject)
   {
      ChoiceQuestion other = (ChoiceQuestion) otherObject;
      if (choices.size() != other.choices.size())
         return false;

      for (int i = 0; i < choices.size(); i++)
      {
         if (!(choices.get(i).equals(other.choices.get(i))))
            return false;
      }
      return true;
   }
}

