public class BankAccountTester2
{
   public static void main(String[] args)
   {
      BankAccount account = new BankAccount(100);
      account.deposit(100);
      System.out.println(account.getBalance());
      System.out.println("Expected: 200");
      account.withdraw(-50);
      System.out.println(account.getBalance());
      System.out.println("Expected: 200");
      account.withdraw(-200);
      System.out.println(account.getBalance());
      System.out.println("Expected: 200");      
       account.withdraw(300);
      System.out.println(account.getBalance());
      System.out.println("Expected: 200");      
   }
}
