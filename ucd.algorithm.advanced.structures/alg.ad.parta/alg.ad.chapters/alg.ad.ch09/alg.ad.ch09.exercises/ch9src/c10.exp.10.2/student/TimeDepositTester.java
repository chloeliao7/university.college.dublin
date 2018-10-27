/**
   This program tests the BankAccount class and its subclasses.
*/
public class TimeDepositTester
{
   public static void main(String[] args)
   {
      SavingsAccount momsSavings = new SavingsAccount(5);

      CheckingAccount harrysChecking = new CheckingAccount(100);

      TimeDepositAccount collegeFund = new TimeDepositAccount(10, 3);

      momsSavings.deposit(10000);

      momsSavings.transfer(2000, harrysChecking);
      harrysChecking.withdraw(1500);
      harrysChecking.withdraw(80);

      momsSavings.transfer(1000, harrysChecking);
      harrysChecking.withdraw(400);

      momsSavings.transfer(3000, collegeFund);
      collegeFund.withdraw(800);

      // simulate end of month
      momsSavings.addInterest();
      collegeFund.addInterest();
      harrysChecking.deductFees();

      System.out.println("Mom's savings balance: "
            + momsSavings.getBalance());
      System.out.println("Expected: 4200");

      System.out.println("Harry's checking balance: "
            + harrysChecking.getBalance());
      System.out.println("Expected: 1116");

      System.out.println("College fund's time deposit balance: "
            + collegeFund.getBalance());
      System.out.println("Expected: 2398");
   }
}
