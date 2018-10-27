public class DartTester
{
   public static void main(String[] args)
   {
      Dart d = new Dart();
      d.throwIntoSquare();
      System.out.println(d.getTries());
      System.out.println("Expected: 1");
      int h = d.getHits();
      System.out.println(h == 0 || h == 1);
      System.out.println("Expected: true");      
   }
}
