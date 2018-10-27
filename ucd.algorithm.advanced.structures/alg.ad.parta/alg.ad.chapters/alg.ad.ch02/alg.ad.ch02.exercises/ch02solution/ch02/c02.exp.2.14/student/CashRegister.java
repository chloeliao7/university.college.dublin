
public class CashRegister
{
   private double purchase;
   private double payment;
   private double totalTax;
   private double taxRate;
   /**
   Constructs a cash register with no money in it.
   */
   public CashRegister(double rate)
   {
	  purchase=0;
	  ...
   }
   /**
   Records the sale of an item.
   @param amount the price of the item
   */
   public void recordPurchase(double amount)
   {
	  purchase = purchase + amount;
   }
   /**
   Records the sale of a taxable item and compute the total tax.
   @param amount the price of the item
   */
   public void recordTaxablePurchase(double amount)
   {
	  ...
   }
   /**
   Enters the payment received from the customer.
   @param amount the amount of the payment
   */
   public void enterPayment(double amount)
   {
	  payment=amount;
   }
   /**
   Returns the total tax due
   @return the totalTax 
   */
   public double getTotalTax()
   {
      ...
   }
   /**
   Computes the change due and resets the machine for the next customer.
   @return the change due to the customer
   */
   public double giveChange()
   {
	  double change = ...
	  purchase = 0;
	  payment = 0;
	  ...
	  return change;
	}
}
