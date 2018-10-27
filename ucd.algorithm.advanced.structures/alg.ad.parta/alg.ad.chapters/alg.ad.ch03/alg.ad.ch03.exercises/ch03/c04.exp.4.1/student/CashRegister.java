/**
   A cash register totals up sales and computes change due.
*/
public class CashRegister
{
   public static final double QUARTER_VALUE = 0.25;
   public static final double DIME_VALUE = 0.1;
   public static final double NICKEL_VALUE = 0.05;
   public static final double PENNY_VALUE = 0.01;    

   private double purchase;
   private double payment;

   /**
      Constructs a cash register with no money in it.
   */
   public CashRegister()
   {
      purchase = 0;
      payment = 0;
   }

   /**
      Records the sale of an item.
      @param amount the price of the item
   */
   public void recordPurchase(double amount)
   {
      double newTotal = purchase + amount;
      purchase = newTotal;
   }

   /**
      Computes the change due and resets the machine for the next customer.
      @return the change due to the customer
   */
   public double giveChange()
   {
      double change = payment - purchase;
      purchase = 0;
      payment = 0;
      return change;
   }

   public void enterDollars(int dollars)
   {
      . . .
   }

   public void enterQuarters(int quarters)
   {
      . . .
   }

   public void enterDimes(int dimes)
   {
      . . .
   }

   public void enterNickels(int nickels)
   {
      . . .
   }

   public void enterPennies(int pennies)
   {
      . . .
   }
}
