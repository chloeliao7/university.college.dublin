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
      Sequence seq2 = new Sequence(5);
      seq2.add(3);
      seq2.add(4);
      seq2.add(4);
      seq2.add(4);
      seq2.add(5);
      System.out.println(seq2.markRuns());
      System.out.println("Expected: 3 (4 4 4) 5");
      Sequence seq3 = new Sequence(5);
      seq3.add(3);
      seq3.add(4);
      seq3.add(4);
      seq3.add(5);
      seq3.add(5);
      System.out.println(seq3.markRuns());
      System.out.println("Expected: 3 (4 4) (5 5)");
      Sequence seq4 = new Sequence(5);
      seq4.add(1);
      seq4.add(2);
      seq4.add(3);
      seq4.add(4);
      seq4.add(5);
      System.out.println(seq4.markRuns());
      System.out.println("Expected: 1 2 3 4 5");
      Sequence seq5 = new Sequence(5);
      seq5.add(4);
      seq5.add(4);
      seq5.add(4);
      seq5.add(4);
      seq5.add(4);
      System.out.println(seq5.markRuns());
      System.out.println("Expected: (4 4 4 4 4)");      
   }
}
