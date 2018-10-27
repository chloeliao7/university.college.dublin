/**
   Tests the use of the Formattable interface.
*/
public class FormatTester
{
   public static void main(String[] args)
   {
      BankAccount account1 = new BankAccount(1000.34367);
      BankAccount account2 = new BankAccount(55.83147);
      BankAccount account3 = new BankAccount(345);
      BankAccount account4 = new BankAccount(99000.10924);

      System.out.printf("|%10.2s|%10.2s|%10.2s|%10.2s|%n",
            account1, account2, account3, account4);
      System.out.println("Expected: |   1000.34|     55.83|    345.00|  99000.10|");
   }
}
