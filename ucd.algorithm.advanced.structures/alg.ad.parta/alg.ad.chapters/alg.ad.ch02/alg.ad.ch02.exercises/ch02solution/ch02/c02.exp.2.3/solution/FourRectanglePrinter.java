import java.awt.Rectangle;

/**
   Prints a rectangle, then moves and prints it 3 times.
*/
public class FourRectanglePrinter
{  
   public static void main(String[] args)
   {  
      Rectangle box = new Rectangle(10, 20, 50, 70);
		
      System.out.println(box);
      box.translate(50, 0);
      System.out.println(box);
      box.translate(0, 70);
      System.out.println(box);
      box.translate(-50, 0);
      System.out.println(box);
   }
}




