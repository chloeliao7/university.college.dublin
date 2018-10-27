/**
   This program tests the QuadraticEquation class.
 */
public class QuadraticEquationTester
{
   public static void main(String[] args)
   {
      QuadraticEquation eq1 = new QuadraticEquation(2, 2, -4);
      System.out.println(eq1.hasSolutions());
      System.out.println("Expected: true");
      System.out.println(eq1.getSolution1());
      System.out.println("Expected: -2");
      System.out.println(eq1.getSolution2());
      System.out.println("Expected: 1");            

      QuadraticEquation eq2 = new QuadraticEquation(2, 2, 4);
      System.out.println(eq2.hasSolutions());
      System.out.println("Expected: false");
      System.out.println(eq2.getSolution1());
      System.out.println("Expected: 0");
      System.out.println(eq2.getSolution2());
      System.out.println("Expected: 0");            
   }
}

