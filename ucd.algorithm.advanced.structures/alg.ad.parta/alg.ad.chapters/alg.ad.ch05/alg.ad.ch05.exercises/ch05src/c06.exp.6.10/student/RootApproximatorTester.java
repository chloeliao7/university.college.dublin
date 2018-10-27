public class RootApproximatorTester
{
   public static void main(String[] args)
   {
      double a = 100;
      final double EPSILON = 1; 
      RootApproximator approx = new RootApproximator(a, EPSILON);
      System.out.println(approx.nextGuess());  
      System.out.println("Expected: 1");
      System.out.println(approx.nextGuess());  
      System.out.println("Expected: 50.5");
      while (approx.hasMoreGuesses())
         approx.nextGuess(); 
      System.out.println(Math.abs(approx.nextGuess() - 10) < EPSILON);
      System.out.println("Expected: true");
   }
}
