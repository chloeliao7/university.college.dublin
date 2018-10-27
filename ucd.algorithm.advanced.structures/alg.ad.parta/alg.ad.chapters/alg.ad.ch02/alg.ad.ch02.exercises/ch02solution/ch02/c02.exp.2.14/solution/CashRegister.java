/**
   A cash register totals up sales and computes change due.
*/
public class CashRegister
{
   private double purchase;
   private double payment;
   private double taxablePurchase;
   private double taxRate;


   /**
      Constructs a cash register with no money in it.
   */
   public CashRegister( double rate )
   {
      purchase = 0;
      payment = 0;
      taxablePurchase = 0;
      taxRate = rate;
   }

   /**
      Records the sale of an item.
      @param amount the price of the item
   */
   public void recordPurchase(double amount)
   {
      double total = purchase + amount;
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
      double change = payment - purchase - taxablePurchase - taxablePurchase * taxRate / 100;
      taxablePurchase = 0;
      purchase = 0;
      payment = 0;
      return change;
   }

   /**
      Records the sale of a taxable item.
      @param amount the price of the item
   */
   public void recordTaxablePurchase(double amount)
   {
      double total = taxablePurchase + amount;
      taxablePurchase = total;
   }
	
   /**
      Compute the total tax on taxable purchases.
      @param return the total tax on the taxable purchases
   */
   public double getTotalTax()
   {
      double totalTax = taxablePurchase * taxRate / 100;
      return totalTax;
   }
}
