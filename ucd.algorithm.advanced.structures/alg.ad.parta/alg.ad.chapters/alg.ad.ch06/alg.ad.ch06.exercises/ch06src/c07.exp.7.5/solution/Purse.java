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
      Determines if a purse has the same coins in the same or different
      order as another purse.
      @param other the other purse
      @return true if the two purses have the same coins in the
            same or different order, false otherwise
   */
   public boolean sameCoins(Purse other)
   {
      for (String c : coins)
         if (count(c) != other.count(c)) 
            return false; 
      
      return true;
   }

   /**
      Counts the number of times the same coin is in the purse.
      @param c the coin to examine
      @return count the number of times the coin is in purse
   */
   public int count(String c)
   {
      int count = 0;
      
      for (String coin : coins)
         if (c.equals(coin))
            count++;
      
      return count;
   }
}
