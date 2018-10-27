import java.util.Formattable;
import java.util.Formatter;
import java.lang.Appendable;
import java.io.IOException;

/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
*/
public class BankAccount implements Formattable
{  
   private double balance;

   /**
      Constructs a bank account with a zero balance.
   */
   public BankAccount()
   {   
      balance = 0;
   }

   /**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
   */
   public BankAccount(double initialBalance)
   {   
      balance = initialBalance;
   }

   /**
      Deposits money into the bank account.
      @param amount the amount to deposit
   */
   public void deposit(double amount)
   {  
      double newBalance = balance + amount;
      balance = newBalance;
   }

   /**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
   */
   public void withdraw(double amount)
   {   
      double newBalance = balance - amount;
      balance = newBalance;
   }

   /**
      Gets the current balance of the bank account.
      @return the current balance
   */
   public double getBalance()
   {   
      return balance;
   }

   public void formatTo(Formatter formatter, int flags, int width, int precision)
   {
      Appendable a = formatter.out();
      
      // Obtain a string representation of the balance, adjusted for precision
      String s = Double.toString((int) (balance * Math.pow(10, precision))
            / Math.pow(10, precision));
      
      // Add zeros at the end if necessary to show appropriate precision
      if (!s.substring(s.length() - 3, s.length() - 2).equals("."))
      {
         if (s.substring(s.length() - 2, s.length() - 1).equals("."))
            s = s + "0";
         else
            s = s + ".00";
      }
      
      // Add padding spaces if necessary
      while (s.length() < width)
         s = " " + s;

      // Pass the string to the append method
      try
      {
         a.append(s);
      }
      catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}
