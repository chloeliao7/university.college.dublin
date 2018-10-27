public class SequenceTester
{
   public static void main(String[] args)
   {
      Sequence seq1 = new Sequence(5);
      seq1.add(3);
      seq1.add(3);
      seq1.add(4);
      seq1.add(5);
      seq1.add(5);
      System.out.println(seq1.markRuns());
      System.out.println("Expected: (3 3) 4 (5 5)");
   }
}
