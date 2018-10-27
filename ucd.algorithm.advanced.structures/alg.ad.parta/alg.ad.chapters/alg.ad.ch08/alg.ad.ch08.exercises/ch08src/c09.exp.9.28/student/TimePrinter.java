import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.util.Date;

/**
   Displays the current time once every second.
*/
public class TimePrinter
{
   public static void main(String[] args)
   {
      class CurrentTime implements ActionListener
      {
         . . .
      }

      . . .

      final int DELAY = 1000; // milliseconds between timer ticks
      Timer t = new Timer(DELAY, . . .);
      t.start();

      JOptionPane.showMessageDialog(null, "Quit?");
      System.exit(0);
   }
}
