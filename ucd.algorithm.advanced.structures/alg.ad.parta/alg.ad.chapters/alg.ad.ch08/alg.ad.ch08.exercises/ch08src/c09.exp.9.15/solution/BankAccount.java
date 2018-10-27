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
      String s = "" + balance;
      
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
