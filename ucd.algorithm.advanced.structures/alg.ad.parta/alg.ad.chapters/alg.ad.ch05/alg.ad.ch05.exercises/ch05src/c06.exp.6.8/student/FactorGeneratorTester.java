public class FactorGeneratorTester
{
   public static void main(String[] args)
   {
      FactorGenerator generator = new FactorGenerator(2 * 2 * 3 * 5);
      System.out.println(generator.hasMoreFactors());
      System.out.println("Expected: true");
      System.out.println(generator.nextFactor());
      System.out.println("Expected: 2");
      System.out.println(generator.hasMoreFactors());
      System.out.println("Expected: true");
      System.out.println(generator.nextFactor());
      System.out.println("Expected: 2");
      System.out.println(generator.hasMoreFactors());
      System.out.println("Expected: true");
      System.out.println(generator.nextFactor());
      System.out.println("Expected: 3");
      System.out.println(generator.hasMoreFactors());
      System.out.println("Expected: true");
      System.out.println(generator.nextFactor());
      System.out.println("Expected: 5");
      System.out.println(generator.hasMoreFactors());
      System.out.println("Expected: false");
   }
}
