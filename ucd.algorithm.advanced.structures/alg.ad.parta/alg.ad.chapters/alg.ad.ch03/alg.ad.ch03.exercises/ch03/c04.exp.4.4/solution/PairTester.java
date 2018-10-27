/**
   Tests the Pair class.
*/
public class PairTester
{
   public static void main(String[] args)
   {
      Pair myPair = new Pair(-2, 11);

      System.out.println("Sum: " + myPair.getSum());
      System.out.println("Expected: 9");
      System.out.println("Difference: " + myPair.getDifference());
      System.out.println("Expected: -13");
      System.out.println("Product:" + myPair.getProduct());
      System.out.println("Expected: -22");
      System.out.println("Average: " + myPair.getAverage());
      System.out.println("Expected: 4.5");      
      System.out.println("Distance: " + myPair.getDistance());
      System.out.println("Expected: 13");      
      System.out.println("Maximum: " + myPair.getMaximum());
      System.out.println("Expected: 11");      
      System.out.println("Minimum: " + myPair.getMinimum());
      System.out.println("Expected: -2");      
   }
}
