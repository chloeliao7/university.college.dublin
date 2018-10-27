public class QuadraticEquation
{
   private double a;
   private double b;
   private double c;
   private double root;

   /**
      Constructs a quadratic equation and get 2 solutions.
      @param coefficientA coefficient a of quadratic equation
      @param coefficientB coefficient b of quadratic equation
      @param coefficientC coefficient c of quadratic equation
   */
   public QuadraticEquation(double coefficientA, double coefficientB, double coefficientC)
   {
      a = coefficientA;
      b = coefficientB;
      c = coefficientC;
      root = Math.sqrt(b * b - 4 * a * c);
   }

   /**
      Returns the first solution to the quadratic equation.
      @return the first solution
   */
   public double getSolution1()
   {
      return (-b + root) / (2 * a);
   }

   /**
      Returns the second solution to the quadratic equation.
      @return the second solution
   */
   public double getSolution2()
   {
      return (-b - root) / (2 * a);
   }
}
