/**
   This class calculates the season for a given month and day.
*/
public class Season
{  
   private int day;
   private int month;
   
   public Season(int month, int day)
   {
      this.month = month;
      this.day = day;
   }

   public String getDescription()
   {  
      String season;
      if (month >= 1 && month <= 3)
      {
         season = "Winter";
      }
      else if (month >= 4 && month <= 6)
      {
         season = "Spring";
      }
      else if (month >= 7 && month <= 9)
      {
         season = "Summer";
      }
      else 
      {
         season = "Fall";
      }
      
      if (month % 3 == 0 && day >= 21)
      {
         if (season.equals("Winter"))
         {
            season = "Spring";
         }
         else if (season.equals("Spring"))
         {
            season = "Summer";
         }
         else if (season.equals("Summer"))
         {
            season = "Fall";
         }
         else 
         {
            season = "Winter";
         }
      }
      return season;
   }
}
