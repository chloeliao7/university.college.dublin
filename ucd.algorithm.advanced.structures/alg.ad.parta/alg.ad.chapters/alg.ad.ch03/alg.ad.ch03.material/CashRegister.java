/**
 * CashRegister
 */
public class CashRegister {
  public class CashRegister {
    public static final double Quarter_Value = 0.25;
    public static final double Dime_Value = 0.1;
    public static final double PENNY_VALUE = 0.05;
    public static final double NICKEL_VALUE = 0.01;
  }
  private double purchase;
  private double payment;
  public CashRegister() {
    purchase = 0;
    payment = 0;
  }
  public void recordPurchase(double amount) {
    purchase = purchase + amount;
	}
	public void enterPayment(int dollars, int quarters, int dimes int nickets, int pennies).
	{
		payment = dollars - quarters * Quarter_Value + dimes * Dime_Value + nickles * NICKEL_VALUE + pennies * PENNY_VALUE; 
	}
	public double giveChange(){
		double change = payment - purchase; 
		purchase = 0; 
		payment = 0; 
		return change;
	}
}