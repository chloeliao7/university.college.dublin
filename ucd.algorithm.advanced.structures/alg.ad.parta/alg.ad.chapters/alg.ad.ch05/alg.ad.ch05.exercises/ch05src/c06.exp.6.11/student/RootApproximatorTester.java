public class RootApproximatorTester
{
   public static void main(String[] args)
   {
      double a = 10000;
      final double EPSILON = 1000; 
      RootApproximator approx = new RootApproximator(a, 4, EPSILON);
      System.out.println(approx.nextGuess());  
      System.out.println("Expected: 1");
      System.out.println(approx.nextGuess());  
      System.out.println("Expected: 2500.75");
      System.out.println(approx.hasMoreGuesses());
      System.out.println("Expected: true");
      approx.nextGuess();
      System.out.println(approx.hasMoreGuesses());
      System.out.println("Expected: false");
   }
}
