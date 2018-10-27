/**
   A fill in the blank question. The question is constructed with
   a string containing the answer, such as 
   "The inventor of Java was _James Gosling_"   
*/
public class FillInQuestion extends Question
{
   /**
      Constructs a fill in the blank question.
      @param questionText the text of this question
   */
   public FillInQuestion(String questionText)
   {
      super(removeAnswer(questionText));
      int start = questionText.indexOf("_");
      int end = questionText.lastIndexOf("_");
      setAnswer(questionText.substring(start + 1, end));     
   }
   
   // This needs to be a separate method because the call to super
   // must be the first line in the constructor
   private static String removeAnswer(String questionText)
   {
      int start = questionText.indexOf("_");
      int end = questionText.lastIndexOf("_");
      return questionText.substring(0, start + 1) + "___" + questionText.substring(end);     
   }
}

