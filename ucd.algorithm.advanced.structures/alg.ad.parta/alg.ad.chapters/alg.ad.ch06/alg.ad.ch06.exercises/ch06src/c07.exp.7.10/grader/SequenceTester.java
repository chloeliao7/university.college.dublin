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
      seq1.findLongestRun();
      System.out.println(seq1.getLongestStart());
      System.out.println("Expected: 0");
      System.out.println(seq1.getLongestSize());
      System.out.println("Expected: 2");
      Sequence seq2 = new Sequence(5);
      seq2.add(3);
      seq2.add(4);
      seq2.add(4);
      seq2.add(4);
      seq2.add(5);
      seq2.findLongestRun();
      System.out.println(seq2.getLongestStart());
      System.out.println("Expected: 1");
      System.out.println(seq2.getLongestSize());
      System.out.println("Expected: 3");
      Sequence seq3 = new Sequence(5);
      seq3.add(3);
      seq3.add(4);
      seq3.add(4);
      seq3.add(5);
      seq3.add(5);
      seq3.findLongestRun();
      System.out.println(seq3.getLongestStart());
      System.out.println("Expected: 1");
      System.out.println(seq3.getLongestSize());
      System.out.println("Expected: 2");
      Sequence seq4 = new Sequence(5);
      seq4.add(1);
      seq4.add(2);
      seq4.add(3);
      seq4.add(4);
      seq4.add(5);
      seq4.findLongestRun();
      System.out.println(seq4.getLongestStart());
      System.out.println("Expected: -1");
      System.out.println(seq4.getLongestSize());
      System.out.println("Expected: 0");
      Sequence seq5 = new Sequence(5);
      seq5.add(4);
      seq5.add(4);
      seq5.add(4);
      seq5.add(4);
      seq5.add(4);
      seq5.findLongestRun();
      System.out.println(seq5.getLongestStart());
      System.out.println("Expected: 0");
      System.out.println(seq5.getLongestSize());
      System.out.println("Expected: 5");
   }
}
