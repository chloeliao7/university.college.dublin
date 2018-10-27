import java.awt.geom.Point2D;
import java.awt.geom.Line2D;

public class SpiralTester
{
   public static void main(String[] args)
   {
      SpiralGenerator gen = new SpiralGenerator(10, new Point2D.Double(100, 100));
      Line2D line = gen.nextSegment();
      System.out.println(line.getX1()); 
      System.out.println("Expected: 100");
      System.out.println(line.getY1()); 
      System.out.println("Expected: 100");
      System.out.println(line.getX2()); 
      System.out.println("Expected: 110");
      System.out.println(line.getY2()); 
      System.out.println("Expected: 100");
      line = gen.nextSegment();
      System.out.println(line.getX1()); 
      System.out.println("Expected: 110");
      System.out.println(line.getY1());
      System.out.println("Expected: 100");
      System.out.println(line.getX2());
      System.out.println("Expected: 110");
      System.out.println(line.getY2());
      System.out.println("Expected: 90");
   }
}
