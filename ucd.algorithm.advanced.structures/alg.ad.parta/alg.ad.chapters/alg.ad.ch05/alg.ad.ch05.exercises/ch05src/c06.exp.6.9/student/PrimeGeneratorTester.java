public class PrimeGeneratorTester
{
   public static void main(String[] args)
   {
      PrimeGenerator generator = new PrimeGenerator();
      System.out.println(generator.nextPrime()); 
      System.out.println("Expected: " + 2);
      System.out.println(generator.nextPrime());  
      System.out.println("Expected: " + 3);
      System.out.println(generator.nextPrime());  
      System.out.println("Expected: " + 5);
      System.out.println(generator.nextPrime());  
      System.out.println("Expected: " + 7);
      System.out.println(generator.nextPrime());  
      System.out.println("Expected: " + 11);
      for (int i = 6; i <= 9999; i++)
         generator.nextPrime();
      System.out.println(generator.nextPrime());  
      System.out.println("Expected: " + 104729); // the ten thousandth prime
   }
}
