/**
   An account that earns interest at a fixed rate.
*/
public class SavingsAccount extends BankAccount
{  
   private double interestRate;
   private double minimumBalance;

   /**
      Constructs a bank account with a given interest rate.
      @param rate the interest rate
   */
   public SavingsAccount(double rate) 
   {  
      interestRate = rate;
      minimumBalance = 0;
   }

   /**
      Constructs a bank account with a given interest rate
      and an initial balance (so that the minimum balance
      isn't zero on a newly created account)
      @param initialBalance the initial balance
      @param rate the interest rate
   */
   public SavingsAccount(double initialBalance, double rate) 
   {  
      deposit(initialBalance);
      interestRate = rate;
      minimumBalance = initialBalance;
   }

   /**
      Adds the earned interest to the account balance.
   */
   public void addInterest() 
   {  
      double interest = minimumBalance * interestRate / 100;
      deposit(interest);
      minimumBalance = getBalance();
   }

   /**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
   */
   public void withdraw(double amount)
   {
      super.withdraw(amount);
      if (getBalance() < minimumBalance)
         minimumBalance = getBalance();
   }
}
