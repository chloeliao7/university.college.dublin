/**
   This class models a month.
*/
public class Month
{
   private int month;

   /**
      Creates a Month object from the month number
      @param aMonth the month in numeric format, in { 1, 2, ..., 12 }
   */
   public Month(int aMonth)
   {
      month = aMonth;
   }

   /**
      Get the number of days in this month.
      @return the number of days 
   */
   public int getDays()
   {
      int days;

      if (month == 4 || month == 6 || month == 9 || month == 11)
         days = 30;
      else if (month == 2)
         days = 28;
      else if (1 <= month && month <= 12)
         days = 31;
      else
         days = -1;

      return days;
   }
}
