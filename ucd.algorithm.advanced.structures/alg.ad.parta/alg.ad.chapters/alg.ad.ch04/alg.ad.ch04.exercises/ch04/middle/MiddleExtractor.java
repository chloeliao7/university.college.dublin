import java.util.Scanner;

public class MiddleExtractor
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.print("Please enter a string: ");
      String str = in.nextLine();

      int position;
      int length;

      if (str.length() % 2 == 1)
      {
         position = str.length() / 2;
         length = 1;
      }
      else
      {
         position = str.length() / 2 - 1;
         length = 2;
      }
      String result = str.substring(position, position + length);

      System.out.println("Middle: " + result);
   }
}
