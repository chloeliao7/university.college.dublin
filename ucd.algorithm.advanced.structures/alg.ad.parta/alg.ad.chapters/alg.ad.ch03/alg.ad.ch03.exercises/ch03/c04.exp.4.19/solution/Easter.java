public class Easter
{
   private int n;
   private int p;

   /**
      Constructs the date of Easter Sunday.
   */
   public Easter(int year)
   {
      int y = year;
      int a = y % 19;
      int b = y / 100;
      int c = y % 100;
      int d = b / 4;
      int e = b % 4;
      int g = (8 * b + 13) / 25;
      int h = (19 * a + b - d - g + 15) % 30;
      int j = c / 4;
      int k = c % 4;
      int m = (a + 11 * h) / 319;
      int r = (2 * e + 2 * j - k - h + m + 32) % 7;
      n = (h - m + r + 90) / 25;
      p = (h - m + r + n + 19) % 32;
   }

   /**
      Gets the month of Easter Sunday
      @return month of Easter Sunday
   */
   public int getEasterSundayMonth()
   {
      return n;
   }

   /**
      Gets the date of Easter Sunday
      @return date of Easter Sunday
   */
   public int getEasterSundayDay()
   {
      return p;
   }
}
