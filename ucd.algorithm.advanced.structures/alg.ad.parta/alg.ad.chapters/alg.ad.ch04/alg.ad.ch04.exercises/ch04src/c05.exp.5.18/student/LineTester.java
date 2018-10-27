public class LineTester
{
   public static void main(String[] args)
   {
      Line line1 = new Line(1, 1, 0.5);
      Line line2 = new Line(1, 1, 1, 2);
      Line line3 = new Line(0.5, -1);
      Line line4 = new Line(1);
      
      System.out.println(line1.equals(line2));
      System.out.println("Expected: false");
      System.out.println(line2.equals(line4));
      System.out.println("Expected: true");
      System.out.println(line1.intersects(line2));
      System.out.println("Expected: true");
      System.out.println(line1.intersects(line3));
      System.out.println("Expected: false");
      System.out.println(line1.isParallel(line3));
      System.out.println("Expected: true");
      System.out.println(line2.isParallel(line4));
      System.out.println("Expected: true");
      System.out.println(line1.isParallel(line2));
      System.out.println("Expected: false");
   }
}
