import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

class AddInterestListener implements ActionListener
{
   private BankAccount account;
   private static final double INTEREST_RATE = 10;

   public AddInterestListener(BankAccount anAccount)
   {
      account = anAccount;
   }
   
   public void actionPerformed(ActionEvent event)
   {
      // The listener method accesses the account variable
      // from the surrounding block
      double interest = account.getBalance() 
                  * INTEREST_RATE / 100;
      account.deposit(interest);
      System.out.println("balance: " + account.getBalance());
   }
}
     
