public class BankAccountTester2
{
   public static void main(String[] args)
   {
         
    try
      {
         BankAccount d = new BankAccount(1000);
         d.deposit(1000);
         d.withdraw(-1000);         
         System.out.println("No assertion error");
      }
      catch (AssertionError e)
      {
         System.out.println("Assertion error");
      }
      System.out.println("Expected: Assertion error");
   }
}
