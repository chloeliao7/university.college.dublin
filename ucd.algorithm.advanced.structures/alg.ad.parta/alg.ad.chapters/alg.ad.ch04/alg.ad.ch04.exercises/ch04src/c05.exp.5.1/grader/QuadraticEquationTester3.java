/**
   This program tests the QuadraticEquation class.
 */
public class QuadraticEquationTester3
{
   public static void main(String[] args)
   {
      QuadraticEquation eq1 = new QuadraticEquation(1, -63.3, -1604.38);
      System.out.println(eq1.hasSolutions());
      System.out.println("Expected: true");
      System.out.println(eq1.getSolution1());
      System.out.println("Expected: -19.4");
      System.out.println(eq1.getSolution2());
      System.out.println("Expected: 82.69999999999999");            

      QuadraticEquation eq2 = new QuadraticEquation(10, 36, 32);
      System.out.println(eq2.hasSolutions());
      System.out.println("Expected: true");
      System.out.println(eq2.getSolution1());
      System.out.println("Expected: -2");
      System.out.println(eq2.getSolution2());
      System.out.println("Expected: -1.6");            
   }
}

