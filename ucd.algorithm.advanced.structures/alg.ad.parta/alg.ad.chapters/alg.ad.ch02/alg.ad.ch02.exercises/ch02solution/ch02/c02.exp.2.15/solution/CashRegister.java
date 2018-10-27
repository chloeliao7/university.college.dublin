/**
   A cash register totals up sales and computes change due.
*/
public class CashRegister
{
   private double purchase;
   private double payment;
   private double salesTotal;
   private int salesCount;

   /**
      Constructs a cash register with no money in it.
   */
   public CashRegister()
   {
      purchase = 0;
      payment = 0;
      salesTotal = 0;
      salesCount = 0;
   }

   /**
      Records the sale of an item.
      @param amount the price of the item
   */
   public void recordPurchase(double amount)
   {
      double total = purchase + amount;
      salesTotal = salesTotal + amount;
      purchase = total;
   }

   /**
      Enters the payment received from the customer.
      @param amount the amount of the payment
   */
   public void enterPayment(double amount)
   {
      payment = amount;
   }

   /**
      Computes the change due and resets the machine for the next customer.
      @return the change due to the customer
   */
   public double giveChange()
   {   
      double change = payment - purchase;
      salesCount = salesCount + 1;
      purchase = 0;
      payment = 0;
      return change;
   }

   /**
      Get the total amount of all sales for the day.
      @param return sale total
   */
   public double getSalesTotal()
   {
      return salesTotal;
   }

   /**
      Get the total number of sales for the day.
      @param return the number of sales.
   */
   public int getSalesCount()
   {
      return salesCount;
   }

   /**
      Reset counters and totals for the next days sales.
      @param none
   */
   public void reset()
   {
      salesTotal = 0;
      salesCount = 0;
   }
}
