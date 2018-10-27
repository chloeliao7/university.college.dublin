import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

class AddInterestListener implements ActionListener
{
   private BankAccount account;
   private JLabel label;
   private static final double INTEREST_RATE = 10;

   public AddInterestListener(BankAccount anAccount, JLabel aLabel)
   {
      account = anAccount;
      label = aLabel;
   }
   
   public void actionPerformed(ActionEvent event)
   {
      double interest = account.getBalance() 
            * INTEREST_RATE / 100;
      account.deposit(interest);
      label.setText(
            "balance=" + account.getBalance());
   }
}

