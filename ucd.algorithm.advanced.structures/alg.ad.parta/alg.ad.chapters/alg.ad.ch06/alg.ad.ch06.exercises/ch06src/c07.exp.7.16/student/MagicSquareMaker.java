import java.util.Scanner;

/**
   This class makes a magic square.
*/
public class MagicSquareMaker
{  
   public static void main(String[] args)
   {  
      Scanner in = new Scanner(System.in);
      System.out.print("Enter the size of the square (must be odd): ");
      int size = in.nextInt();

      if (size % 2 == 1)
      {  
         MagicSquare mySquare = new MagicSquare(size);         
         System.out.println(mySquare.toString());
      }
      else
         System.out.println("Size must be odd." );
   }
}
