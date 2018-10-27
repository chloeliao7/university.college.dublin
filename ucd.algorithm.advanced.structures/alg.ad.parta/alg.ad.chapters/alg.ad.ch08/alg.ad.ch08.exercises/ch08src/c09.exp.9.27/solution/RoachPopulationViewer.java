import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
   This program displays the growth of a roach population. 
*/
public class RoachPopulationViewer
{  
   private static final int FRAME_WIDTH = 400;
   private static final int FRAME_HEIGHT = 100;

   public static void main(String[] args)
   {  
      JFrame frame = new JFrame();

      JButton button = new JButton("Double roach population!");

      final RoachPopulation roachPopulation = new RoachPopulation(2);

      // The label for displaying the results
      final JLabel label = new JLabel(
            "population: " + roachPopulation.getPopulation());

      // The panel that holds the user interface components
      JPanel panel = new JPanel();
      panel.add(button);
      panel.add(label);      
      frame.add(panel);

      class PopulationDoublerListener implements ActionListener
      {  
         public void actionPerformed(ActionEvent event)
         {
            roachPopulation.doublePopulation();
            label.setText(
                  "population: " + roachPopulation.getPopulation());
         }
      }
  
      ActionListener listener = new PopulationDoublerListener();
      button.addActionListener(listener);

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}
