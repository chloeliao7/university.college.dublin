/**
   A cash register totals up sales and computes change due.
*/
public class CashRegister
{
   private double purchase;
   private double payment;
   public CashRegister()
   {
      purchase = 0;
      payment = 0;
   }
   public void recordPurchase(double amount)
   {
      double newTotal = purchase + amount;
      purchase = newTotal;
   }
   public void enterPayment(int coinCount, Coin coinType)
   {
      payment  = payment + coinCount * coinType.getValue();
   }
   public double giveChange()
   {
      double change = payment - purchase;
      purchase = 0;
      payment = 0;
      return change;
   }    
}
