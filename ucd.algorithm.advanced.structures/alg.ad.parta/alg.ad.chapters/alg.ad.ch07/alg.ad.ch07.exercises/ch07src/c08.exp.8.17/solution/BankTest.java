import org.junit.Test;
import org.junit.Assert;

public class BankTest
{
   @Test public static void testCount()
   {
      Bank firstBankOfJava = new Bank();
      firstBankOfJava.addAccount(new BankAccount(1001, 20000));
      firstBankOfJava.addAccount(new BankAccount(1015, 10000));
      firstBankOfJava.addAccount(new BankAccount(1729, 15000));

      double threshold = 15000;
      int expected = 2;
      Assert.assertEquals(expected, firstBankOfJava.count(threshold));
   }

   @Test public static void testGetBalance()
   {
      Bank firstBankOfJava = new Bank();
      firstBankOfJava.addAccount(new BankAccount(1001, 20000));
      firstBankOfJava.addAccount(new BankAccount(1015, 10000));
      firstBankOfJava.addAccount(new BankAccount(1729, 15000));

      int accountNumber = 1015;
      int expected = 10000;
      BankAccount a = firstBankOfJava.find(accountNumber);
      Assert.assertEquals(expected, a.getBalance());
   }

   @Test public static void testMax()
   {
      Bank firstBankOfJava = new Bank();
      firstBankOfJava.addAccount(new BankAccount(1001, 20000));
      firstBankOfJava.addAccount(new BankAccount(1015, 10000));
      firstBankOfJava.addAccount(new BankAccount(1729, 15000));

      int expected = 1001;
      BankAccount max = firstBankOfJava.getMaximum();
      Assert.assertEquals(expected, max.getAccountNumber());
   }

   public static void main (String[] args) {
      org.junit.runner.JUnitCore.runClasses(BankTest.class);
   }
}