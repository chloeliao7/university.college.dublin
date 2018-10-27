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
      Records the purchase of an item.
      @param amount the price of the item
   */
   public void recordPurchase(double amount)
   {
      double newTotal = purchase + amount;
      purchase = newTotal;
   }

   /**
      Enters the payment received from the customer.
      @param dollars the number of dollars in the payment
      @param quarters the number of quarters in the payment
      @param dimes the number of dimes in the payment
      @param nickels the number of nickels in the payment
      @param pennies the number of pennies in the payment
   */
   public void enterPayment(int dollars, int quarters, 
      int dimes, int nickels, int pennies)
   {
      payment = dollars + quarters * QUARTER_VALUE + dimes * DIME_VALUE
         + nickels * NICKEL_VALUE + pennies * PENNY_VALUE;
   }
   
   /**
      Computes the number of dollars due to the customer.
      @return the number of dollars in the change due
   */
   public int giveDollars()
   {
      if (payment == 0) return 0;
      int change = (int) (payment - purchase);

      if (change < 0)
         return 0;

      payment = payment - change;
      return change;
   }

   /**
      Computes the number of quarters due to the customer.
      @return the number of quarters in the change due
   */
   public int giveQuarters()
   {
      if (payment == 0) return 0;
      int change = (int) ((payment - purchase) / QUARTER_VALUE);
      payment = payment - change * QUARTER_VALUE;
      return (int) change;
   }

   /**
      Computes the number of dimes due to the customer.
      @return the number of dimes in the change due
   */
   public int giveDimes()
   {
      if (payment == 0) return 0;
      int change = (int) ((payment - purchase) / DIME_VALUE);
      payment = payment - change * DIME_VALUE;
      return (int) change;
   }

   /**
      Computes the number of nickels due to the customer.
      @return the number of nickels in the change due
   */
   public int giveNickels()
   {
      if (payment == 0) return 0;
      int change = (int) ((payment - purchase)/NICKEL_VALUE);
      payment = payment - change * NICKEL_VALUE;
      return (int) change;
   }

   /**
      Computes the number of pennies due to the customer.
      @return the number of pennies in the change due
   */
   public int givePennies()
   {
      if (payment == 0) return 0;
      int change = (int) ((payment - purchase)/PENNY_VALUE);
      payment = payment - change * PENNY_VALUE;
      return (int) change;
   }
}
