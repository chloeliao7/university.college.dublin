import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
   An action listener that prints a message.
*/
public class ClickListener implements ActionListener
{
   public void actionPerformed(ActionEvent event)
   {
      Date now = new Date();
      System.out.println("I was clicked at " + now);
   }            
}
