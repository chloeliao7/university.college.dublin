/**
   This class determines if a year is a leap year or not.
*/
public class Year
{
   private int year;

   /**
      Creates a Year object to test whether a particular year is a leap year.
      @param aYear is the year to be tested
   */
   public Year(int aYear)
   {
      year = aYear;
   }

   /**
      Method to determine if a year is a leap year.
      @return boolean true year is a leap year
   */
   public boolean isLeapYear()
   {
      final int GREGORIAN = 1582;

      boolean everyFourYears = year % 4 == 0;
      boolean everyHundredYears = year % 100 == 0;
      boolean everyFourHundredYears = year % 400 == 0;
      boolean beforeGregorian = year < GREGORIAN; 
  
      return everyFourYears && (beforeGregorian || !everyHundredYears ||  
         everyFourHundredYears);
   }
}
