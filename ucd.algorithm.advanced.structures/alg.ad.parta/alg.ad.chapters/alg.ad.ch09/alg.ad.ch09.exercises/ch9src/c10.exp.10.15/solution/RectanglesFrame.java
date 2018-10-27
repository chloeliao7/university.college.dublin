import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;

/**
   Prompts the user for an integer and then draws as many rectangles at
   random positions in a component as the user requested.
 */
public class RectanglesFrame extends JFrame
{  
   private RectanglesComponent component;
   private JTextField nField;

   private static final int FRAME_WIDTH = 300;
   private static final int FRAME_HEIGHT = 300;   

   public RectanglesFrame()
   {
      setSize(FRAME_WIDTH, FRAME_HEIGHT);

      component = new RectanglesComponent();
      component.setPreferredSize(new Dimension(400,350));
      
      // the text field for entering a number of rectangles
      nField = new JTextField(5);
            

      // the label for labeling the text field
      JLabel nLabel = new JLabel("Number of Rectangles: ");

      // the panel for holding the user interface components
      JPanel panel = new JPanel();

      panel.add(nLabel);
      panel.add(nField);
      panel.add(createDrawButton());
      panel.add(component);

      add(panel);      
   }

   private JButton createDrawButton()
   {
      // the button to draw the rectangles
      JButton drawButton = new JButton("Draw");    

      class DrawButtonListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            int n = Integer.parseInt(nField.getText());
            
            component.setCount(n);
            
            // clears the text field
            nField.setText("");
         }
      }

      ActionListener listener = new DrawButtonListener();
      drawButton.addActionListener(listener);      
      return drawButton;
   }
}
