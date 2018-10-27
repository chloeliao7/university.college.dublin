/**
   This class compares two military times and
   determines which comes first.
*/
public class Time
{
   private int hour;
   private int minute;
   
   public Time(int hour, int minute)
   {
      this.hour = hour;
      this.minute = minute;
   }

   /**
      Compares this time against another time.
      @param time2 the time to compare with
      @return "before" if this time comes before time2,
      "" if the times are the same, and "after" otherwise
   */   
   public String compareWith(Time time2)
   {   
      if (this.hour < time2.hour)
      {
         return "before";
      }
      else if (this.hour == time2.hour)
      {
         if (this.minute < time2.minute)
         {
            return "before";
         }
         else if (this.minute == time2.minute)
         {
            return "";
         }
         else
         {
            return "after";
         }
      }
      else
      {
         return "after";
      }
   }
}
