/**
   Tests the use of the Formattable interface.
*/
public class FormatTester2
{
   public static void main(String[] args)
   {
      BankAccount account1 = new BankAccount(1000);
      BankAccount account2 = new BankAccount(55);
      BankAccount account3 = new BankAccount(345);
      BankAccount account4 = new BankAccount(99000);

      System.out.printf("|%8s |%5s |%5s |%10s%n", account1, account2, account3, account4);
      System.out.println("Expected: |  1000.0 | 55.0 |345.0 |   99000.0");
   }
}
