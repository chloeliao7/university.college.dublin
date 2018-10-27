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
      seq2.add(1);
      seq2.add(2);
      seq2.add(3);
      seq2.add(4);
      seq2.add(5);
      seq2.findLongestRun();
      System.out.println(seq2.getLongestStart());
      System.out.println("Expected: -1");
      System.out.println(seq2.getLongestSize());
      System.out.println("Expected: 0");
   }
}
