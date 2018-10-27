import java.awt.Rectangle;

/**
   Prints two Rectangles and their intersection.
*/
public class IntersectionPrinter
{  
   public static void main(String[] args)
   {  
      Rectangle r1 = new Rectangle(10, 10, 50, 70);
      System.out.println(r1);
      // overlapping rectangle
      Rectangle r2 = new Rectangle(30, 30, 70, 50);
      System.out.println(r2);
      Rectangle r3 = r1.intersection(r2);
      System.out.println(r3);
      // non-overlapping rectangle; intersection has 
      // negative width and/or height
      Rectangle r4 = new Rectangle(100, 100, 70, 50);
      System.out.println(r4);
      Rectangle r5 = r1.intersection(r4);
      System.out.println(r5);
   }
}




