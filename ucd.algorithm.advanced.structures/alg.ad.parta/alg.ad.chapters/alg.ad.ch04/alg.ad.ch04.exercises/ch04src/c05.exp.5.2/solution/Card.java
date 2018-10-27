/**
   This class implements the full description of a deck of cards.
*/
public class Card
{
   private String type;
   private String suit;

   /**
      Constructs a card type and suit of a deck of cards.
      @param notation the string describing the card
   */
   public Card(String notation)
   {
      int n = notation.length();
      if (n < 2)
      {
         type = "?";
         suit = "?";
      }
      else
      {
         suit = notation.substring(n - 1, n);
         type = notation.substring(0, n - 1);
      }
   }

   /**
      Get the description of the type and suit of the card.
      @return the description of the the card
   */
   public String getDescription()
   {
      String output = "";

      // Get the type description
      if (type.equalsIgnoreCase("A"))
         output = "Ace";
      else if(type.equalsIgnoreCase("K"))
         output = "King";
      else if(type.equalsIgnoreCase("Q"))
         output = "Queen";
      else if(type.equalsIgnoreCase("J"))
         output = "Jack";
      else if(type.equals("2"))
         output = "Two";
      else if(type.equals("3"))
         output = "Three";
      else if(type.equals("4"))
         output = "Four";
      else if(type.equals("5"))
         output = "Five";
      else if(type.equals("6"))
         output = "Six";
      else if(type.equals("7"))
         output = "Seven";
      else if(type.equals("8"))
         output = "Eight";
      else if(type.equals("9"))
         output = "Nine";
      else if(type.equals("10"))
         output = "Ten";
      else
         return "Unknown";
      output = output + " of ";
      // Get the suit description
      if (suit.equalsIgnoreCase("S"))
         output = output + "Spades";
      else if(suit.equalsIgnoreCase("H"))
         output = output + "Hearts";
      else if(suit.equalsIgnoreCase("D"))
         output = output + "Diamonds";
      else if(suit.equalsIgnoreCase("C"))
         output = output + "Clubs";
      else
         return "Unknown";

      return output;
   }
}
