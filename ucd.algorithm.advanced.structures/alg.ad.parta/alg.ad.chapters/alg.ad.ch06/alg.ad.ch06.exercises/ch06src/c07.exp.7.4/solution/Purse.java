import java.util.ArrayList;

/**
   A purse holds a collection of coins.
*/
public class Purse
{
   private ArrayList<String> coins;

   /**
      Constructs an empty purse.
   */
   public Purse()
   {
      coins = new ArrayList<String>();
   }

   /**
      Add a coin to the purse.
      @param coinName the coin to add
   */
   public void addCoin(String coinName)
   {
      coins.add(coinName);
   }

   /**
      Returns a string describing the object.
      @return a string in the format "Purse[coinName1,coinName2,...]"
   */
   public String toString()
   {
      if (coins.size() == 0)
         return "Purse[]";
      
      String output = "Purse[";
      
      for (String coin : coins)
      {
         output = output + coin + ",";
      }
      output = output.substring(0, output.length() - 1); // remove the last ","
      return output + "]";         
   }

   /**
      Determines if a purse has the same coins in the same 
      order as another purse.
      @param other the other purse
      @return true if the two purses have the same coins in the
         same order, false otherwise
   */
   public boolean sameContents(Object other)
   {
      Purse otherPurse = (Purse) other;
      if (coins.size() == otherPurse.coins.size())
      {
         for (int i = 0; i < coins.size(); i++)
            if (!coins.get(i).equals(otherPurse.coins.get(i)))
               return false; //The coins are different
      }
      else
         return false; //They are not equal

      return true; //Purses have same size and all coins match
   }
}
