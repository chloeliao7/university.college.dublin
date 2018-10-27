/**
   A question with a numeric answer.
*/
public class NumericQuestion extends Question
{
   private static final double EPSILON = 0.01;
   private double answer;

   /**
      Constructs a numeric question .
      @param questionText the text of this question
   */
   public NumericQuestion(String questionText)
   {
      super(questionText);
   }

   public void setAnswer(double questionAnswer)
   {
      answer = questionAnswer;
   }

   /**
      Checks a given response for correctness.
      The answer is correct if if differs by no more than epsilon.
      @param response the response to check
      @return true if the response was correct, false otherwise
   */
   public boolean checkAnswer(String response)
   {
      double numericResponse = Double.valueOf(response);
      return Math.abs(answer - numericResponse) <= EPSILON;
   }
}

