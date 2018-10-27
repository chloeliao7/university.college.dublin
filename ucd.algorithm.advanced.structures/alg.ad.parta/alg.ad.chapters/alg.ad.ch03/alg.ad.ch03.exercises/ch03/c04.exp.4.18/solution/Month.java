public class Month
{
   private int monthNumber;

   private static final int MONTHS_PER_YEAR = 12;
   private static final String MONTHS =
      "  January" +
      " February" +
      "    March" +
      "    April" +
      "      May" +
      "     June" +
      "     July" +
      "   August" +
      "September" +
      "  October" +
      " November" +
      " December";

   /**
      Constructs the names of months in a year.
      @param aMonthNumber of the month
   */
   public Month(int aMonthNumber)
   {
      monthNumber = aMonthNumber;
   }

   /**
      Gets the name of the month.
      @return name of the month
   */
   public String getName()
   {
      int spacesPerMonth = MONTHS.length() / MONTHS_PER_YEAR;
      return MONTHS.substring((monthNumber - 1) * spacesPerMonth,
         monthNumber * spacesPerMonth);
   }
}
