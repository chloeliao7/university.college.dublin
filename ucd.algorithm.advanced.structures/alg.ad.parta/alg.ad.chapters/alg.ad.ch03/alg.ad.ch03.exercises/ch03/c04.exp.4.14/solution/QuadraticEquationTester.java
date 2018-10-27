/**
   This program tests the QuadraticEquation class.
 */
public class QuadraticEquationTester
{
   public static void main(String[] args)
   {
      // 2*(x-1)*(x+2) = 2*x*x + 2*x - 4 
      QuadraticEquation myEquation = new QuadraticEquation(2, 2, -4);

      double x1 = myEquation.getSolution1();
      double x2 = myEquation.getSolution2();
      // we don't know which of them is the smaller one
      System.out.println("Smaller: " + Math.min(x1, x2));
      System.out.println("Expected: -2");
      System.out.println("Larger: " + Math.max(x1, x2));
      System.out.println("Expected: 1");
   }
}

