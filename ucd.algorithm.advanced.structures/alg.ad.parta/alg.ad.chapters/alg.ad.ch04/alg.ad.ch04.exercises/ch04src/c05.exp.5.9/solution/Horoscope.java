/**
   Produces a horoscope based on the day and month of birth.
*/

public class Horoscope
{
   private int month;
   private int day;

   /**
      @param month the month of birth
      @param day the day of birth
   */
   public Horoscope(int month, int day)
   {
      this.month = month;
      this.day = day; 
   }

   /**
      Gets a description for the month and day.
      @return the horoscope description
   */
   public String getDescription()
   {
      /* Capricorn */
      if (month == 12 && day >= 22 || month == 1 && day <= 19)
      {
         return "Capricons are good at building and organizing." +
            "Today is just right for surprise moves and" +
            "\nsurpassing the competition before they know what's going on.";
      }
      /* Aquarius */
      else if (month == 1 && day >= 20 || month == 2 && day <= 18)
      {
         return "Aquarius is innovating and liberating." +
         "Today you may have a sudden burst of romantic interest" +
            "\nin someone totally new. Run with it!";
      }
      /* Pisces */
      else if (month == 2 && day >= 19 || month == 3 && day <= 20)
      {
         return "Pisces are good at accepting and loving." +
         "Today you're feeling a little unsettled about" +
            "\nsome new arrangement. That means it's time to reevaluate.";
      }
      /* Aries */
      else if (month == 3 && day >= 21 || month == 4 && day <= 19)
      {
         return "Aries people are independent and make good leaders." +
         "Nothing seems to mean what people think it means today," +
            "\nbut that doesn't mean you have to just throw up your hands and walk away.";
      }      
      /* Taurus */
      else if (month == 4 && day >= 20 || month == 5 && day <= 20)
      {
         return "The Taurus is possessive." +
         "Today you and your heart are feeling just" +
            "\na bit more fragile than usual. Get your sweetie to take care of you.";
      }      
      /* Gemini */
      else if (month == 5 && day >= 21 || month == 6 && day <= 21)
      {
         return "Geminis love to learn and are good communicators." +
         "Try to take one positive step toward better health today." +
            "\nEat a banana or take a long walk.";
      }
      /* Cancer */
      else if (month == 6 && day >= 22 || month == 7 && day <= 22)
      {
         return "Cancers are protectors and homebodies." +
         "Your emotional energy feels as deep and energetic" +
            "\nas the ocean right now. If anyone can handle it, it's you!";
      }
      /* Leo */
      else if (month == 7 && day >= 23 || month == 8 && day <= 22)
      {
         return "Leos are highly respected, but playful." +
         "Now is a good time for skulduggery, but" +
            "\nyou're not the only one who's thinking about it!";
      }
      /* Virgo */
      else if (month == 8 && day >= 23 || month == 9 && day <= 22)
      {
         return "Virgos are the workers and cleaners." +
         "Speak up today. Someone close to you" +
            "\nis in dire need of advice, or at least perspective.";
      }
      /* Libra */
      else if (month == 9 && day >= 23 || month == 10 && day <= 22)
      {
         return "Libra are good at socialing and relating to others." +
         "You are experiencing big changes right now. It's almost" +
            "\nceratinly positive in the long run, so stick with it.";
      }
      /* Scorpio */
      else if (month == 10 && day >= 23 || month == 11 && day <= 21)
      {
         return "Scorpio can be very secretive." +
         "Whether you think of yourself as an introvert or" +
            "\nan extrovert, today you can see that others find you fascinating.";
      }
      /* Sagittarius */
      else if (month == 11 && day >= 22 || month == 12 && day <= 21)
      {
         return "Sagittarius is the traveler and explorer." +
         "Today an important clue comes your way through a dream," +
            "\nso make sure that you take some extra time to recall what went on at night.";
      }
      /* bad date */
      else
         return "The birth date is invalid.";
   }
}
