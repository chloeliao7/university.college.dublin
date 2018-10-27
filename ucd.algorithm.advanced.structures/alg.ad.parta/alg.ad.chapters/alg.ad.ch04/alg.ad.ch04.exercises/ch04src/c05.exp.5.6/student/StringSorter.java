import java.util.Scanner;

/**
   This program sorts three strings.
*/
public class StringSorter
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      
      System.out.println("Please enter three strings:");
      String str1 = in.nextLine();
      String str2 = in.nextLine();
      String str3 = in.nextLine();

      StringSet s = new StringSet(str1, str2, str3);

      System.out.println("The inputs in sorted order are:\n"
         + s.getSmallest() + "\n"
         + s.getMiddle() + "\n"
         + s.getLargest());
   }
}
