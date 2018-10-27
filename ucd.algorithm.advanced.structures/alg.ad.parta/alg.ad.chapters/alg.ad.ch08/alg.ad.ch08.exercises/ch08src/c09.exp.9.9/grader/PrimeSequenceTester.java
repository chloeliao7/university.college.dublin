public class PrimeSequenceTester
{
   public static void main(String[] args)
   {
      Sequence seq = new PrimeSequence();
      System.out.println(seq.next());
      System.out.println("Expected: 2");
      System.out.println(seq.next());
      System.out.println("Expected: 3");
      for (int i = 3; i <= 999; i++)
         seq.next();
      System.out.println(seq.next());
      System.out.println("Expected: 7919");
   }
}
