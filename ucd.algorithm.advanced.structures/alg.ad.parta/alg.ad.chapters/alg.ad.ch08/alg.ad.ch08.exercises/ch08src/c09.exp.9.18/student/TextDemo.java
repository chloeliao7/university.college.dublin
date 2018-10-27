public class TextDemo
{
   public static void main(String[] args)
   {
      IText text = new MockText();
      while (...)
      {
         String type = ...;
         System.out.println("<" + type + ">" + cleanup(...) + 
            "</" + type + ">");
      }
   }

   public static String cleanup(String text)
   {
      String result = text.replace("&", "&amp;");
      result = result.replace("``", "&ldquo;"); 
      result = result.replace("''", "&ldquo;"); 
      result = result.replace("`", "&lsquo;"); 
      result = result.replace("'", "&rsquo;"); 
      result = result.replace("--", "&emdash;"); 
      result = result.replace("<", "&lt;"); 
      result = result.replace(">", "&gt;"); 
      return result;
   }
}
