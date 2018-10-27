public class QuadraticEquation
{
   private double a;
   private double b;
   private double c;
   private double discriminant;

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
      discriminant = b * b - 4 * a * c;
   }

   /**
      Returns the first solution to the quadratic equation.
      @return the first solution
   */
   public double getSolution1()
   {
      if (discriminant < 0) return 0;
      return (-b - Math.sqrt(discriminant)) / (2 * a);
   }

   /**
      Returns the second solution to the quadratic equation.
      @return the second solution
   */
   public double getSolution2()
   {
      if (discriminant < 0) return 0;
      return (-b + Math.sqrt(discriminant)) / (2 * a);
   }

   /**
      Determines if there is a solution or not.
      @return true if there is a solution
   */
   public boolean hasSolutions()
   {
      return discriminant > 0;
   }
}
