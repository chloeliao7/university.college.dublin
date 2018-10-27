public class DigitExtractor
{
   private int integer;
   private int result;

   /**
      Constructs a digit extractor that gets the digits
      of an integer in reverse order.
      @param anInteger the integer to break up into digits
   */
   public DigitExtractor(int anInteger)
   {
      integer = anInteger;
      result = 0;
   }

   /**
      Returns the next digit to be extracted.
      @return the next digit
   */
   public int nextDigit()
   {
      result = integer % 10;
      integer = integer / 10;
      return result;
   }
}
