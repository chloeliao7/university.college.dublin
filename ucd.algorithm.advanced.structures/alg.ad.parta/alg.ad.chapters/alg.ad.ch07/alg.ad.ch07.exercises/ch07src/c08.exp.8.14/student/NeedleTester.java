import java.lang.reflect.*;

public class NeedleTester
{
   public static void main(String[] args)
   {
      // This loop prints the names and types of all static variables of the Needle class
   
      for (Field f : Needle.class.getDeclaredFields())
      {
         if (Modifier.isStatic(f.getModifiers()))
            System.out.println(f.getName() + ": " + f.getType());
      }
      System.out.println("Expected: class java.util.Random");
   }
}
