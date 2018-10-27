/**
   This program tests the BankAccount class and its subclasses.
*/
public class AccountTester2
{
   public static void main(String[] args)
   {
      SavingsAccount momsSavings = new SavingsAccount(500);
      CheckingAccount harrysChecking = new CheckingAccount(0);
      
      test(momsSavings);
      System.out.println(momsSavings.getBalance());      
      System.out.println("Expected: 3600");
      
      test(harrysChecking);
      System.out.println(harrysChecking.getBalance());      
      System.out.println("Expected: 596");
   }

   public static void test(BankAccount account)
   {
      account.deposit(1000);
      account.withdraw(500);
      account.deposit(200);
      account.deposit(300);
      account.withdraw(400);

      account.endOfMonth();
   }
}
