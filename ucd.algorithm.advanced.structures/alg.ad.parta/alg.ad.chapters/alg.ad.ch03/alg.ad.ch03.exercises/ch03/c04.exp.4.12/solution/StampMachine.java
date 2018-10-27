/**
*/
public class StampMachine
{
   public static final int FIRST_CLASS_STAMP_PRICE = 44;
   private int numDollars;
   private int change;

   /**
      Constructs a stamp machine with a zero balance.
   */
   public StampMachine() 
   { 
      numDollars = 0;
      change = 0; 
   }

   /**
      Adds a given number of dollar bills into this machine.
      @param dollars the number of dollar bills
   */
   public void insert(int dollars)
   {
      numDollars = numDollars + dollars;
   }

   /**
      Dispenses first class stamps for the inserted payment.
      @return the number of first class stamps
   */
   public int giveFirstClassStamps()
   {
      int firstClassStamps = (numDollars * 100) / FIRST_CLASS_STAMP_PRICE;
      change = (numDollars * 100) - firstClassStamps * FIRST_CLASS_STAMP_PRICE;
      numDollars = 0;
      return firstClassStamps;
   }

   /**
      Dispenses penny stamps for the inserted payment.
      @return the number of penny stamps
   */
   public int givePennyStamps()
   {
      int pennyStamps = change;
      change = 0;
      return pennyStamps;      
   }
}
