/**
   This class compares two military times and
   determines which comes first.
*/
public class Time
{
   private int hour;
   private int minute;
   
   public Time(int anHour, int aMinute)
   {
      . . .
   }

   /**
      Compares this time against another time.
      @param time2 the time to compare with
      @return "before" if this time comes before time2,
      "" if the times are the same, and "after" otherwise
   */   
   public String compareWith(Time time2)
   {
      . . .   
   }
}
