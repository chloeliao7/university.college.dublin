/**
 * BankAccount
 */
public class BankAccount {
  private double balance;
  // default constructor
  public BankAccount() { balance = 0; }
  // the initial balance
  public BankAccount(double initialBalance) { balance = initialBalance; }
  // deposit money into tyou bank account by addition
  public void deposit(double amount) {
    double newBalance = balance + amount;
    balance = newBalance;
	}
	    // we need this to update the new balancce\
  public void withdraw(double anount) {
    double newBalance = balance - amount;
    balance = newBalance;
  }
  public double getBalance() { return balance; }
  public double getMeasure() { return balance; }
}
