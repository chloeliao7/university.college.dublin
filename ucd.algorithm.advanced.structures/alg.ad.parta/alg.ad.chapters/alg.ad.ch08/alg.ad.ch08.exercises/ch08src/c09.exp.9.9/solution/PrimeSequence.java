public class PrimeSequence implements Sequence
{
   private int current = 0;   // before first call

   public int next()
   {
      if (current == 0)
      {
         current = 2;
         return current;
      }
      else if (current == 2)
      {
         current = 3;
         return current;
      }

      /*
         there are an infinite number of primes,
         and as such, we are guaranteed to find one
      */
      while (true)
      {
         current += 2;  // after 2, all primes are odd
         if (isPrime(current)) return current;
      }
   }

   /**
      @param n an odd number
   */
   private static boolean isPrime(int n)
   {
      for (int f = 3; f * f <= n; f += 2)
      {
         if (n % f == 0) return false;
      }
      return true;
   }
}
