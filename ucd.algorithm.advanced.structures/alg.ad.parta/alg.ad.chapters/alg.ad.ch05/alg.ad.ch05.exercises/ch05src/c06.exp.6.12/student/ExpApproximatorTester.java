public class ExpApproximatorTester
{
   public static void main(String[] args)
   {
      double a = 1;
      double epsilon = 0.25; 
      ExpApproximator approx = new ExpApproximator(a, epsilon);
      System.out.println(approx.nextGuess());
      System.out.println("Expected: 1");
      System.out.println(approx.nextGuess());
      System.out.println("Expected: 2");
      System.out.println(approx.nextGuess());
      System.out.println("Expected: 2.5");
      System.out.println(approx.hasMoreGuesses());
      System.out.println("Expected: true");
      approx.nextGuess();
      System.out.println(approx.hasMoreGuesses());
      System.out.println("Expected: false");
   }
}
