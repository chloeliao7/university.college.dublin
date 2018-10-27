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
      . . .
   }

   /**
      Returns a string describing the object.
      @return a string in the format "Purse[coinName1,coinName2,...]"
   */
   public String toString()
   {
      . . .
   }

   /**
      Transfer the coins from one purse to another.
      @param other the other purse
   */   
   public void transfer(Purse other)
   {      
      . . .
   }     
}
