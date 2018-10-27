public class QuestionTester
{
   public static void main(String[] args)
   {
      Question q = new Question("");
      q.setAnswer("james GOSLING");
      System.out.println(q.checkAnswer("JAMES gosling"));
      System.out.println("Expected: true");
      System.out.println(q.checkAnswer(" JAMES gosling"));
      System.out.println("Expected: true");
      System.out.println(q.checkAnswer("JAMES gosling "));
      System.out.println("Expected: true");
      System.out.println(q.checkAnswer("JAMES  gosling"));
      System.out.println("Expected: true");
      System.out.println(q.checkAnswer("james GOSLING."));
      System.out.println("Expected: false");
   }
}
