import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/** 
	Show a dialog box with an image and greeting.
*/
public class ImageGreeter
{
   public static void main(String[] args) throws Exception
   {
      URL imageLocation = new URL("http://horstmann.com/cay-tiny.gif");
			
      JOptionPane.showMessageDialog(null, 
         "Greetings from Cay Horstmann", "Welcome to Java",
         JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
         System.exit(0);
   }
}
