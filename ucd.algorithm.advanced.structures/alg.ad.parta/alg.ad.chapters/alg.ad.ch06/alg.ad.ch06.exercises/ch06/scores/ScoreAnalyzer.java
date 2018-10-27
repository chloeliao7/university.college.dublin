import java.util.Scanner;

public class ScoreAnalyzer
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      GradeBook book = new GradeBook();
      System.out.println("Please enter values, Q to quit:");
      while (in.hasNextDouble())
      {  
         book.addScore(in.nextDouble());
      }
      System.out.println("Final score: " + book.finalScore());
   }
}
