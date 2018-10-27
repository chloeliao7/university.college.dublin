import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;

/**
   This frame displays a grid with a size the user specified.
*/
public class GridFrame extends JFrame
{ 
   public GridFrame()
   {  
      component = new GridComponent();
      component.setPreferredSize(new Dimension(COMPONENT_WIDTH, COMPONENT_HEIGHT));
      
      // the text field for entering the number of n
      countField = new JTextField(5);           
           
      // the label for labeling the text field      
      JLabel nLabel = new JLabel("count: ");

      // the panel for holding the user interface components      
      JPanel panel = new JPanel();

      panel.add(nLabel);
      panel.add(countField);
      panel.add(createLineButton());
      panel.add(component);

      setSize(FRAME_WIDTH, FRAME_HEIGHT);
      add(panel);
   }

   private JButton createLineButton()
   {
      // the button to draw the grid
      JButton lineButton = new JButton("Draw");     

      class LineButtonListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            component.setCount(Integer.parseInt(countField.getText()));
            component.repaint();  
            
            // clear the text field
            countField.setText("");    
         }
      }

      // add action listener
      
      ActionListener listener = new LineButtonListener();
      lineButton.addActionListener(listener);
      return lineButton;
   }

   private GridComponent component;
   private JTextField countField;

   private static final int FRAME_WIDTH = 400;
   private static final int FRAME_HEIGHT = 400;
   private static final int COMPONENT_WIDTH = 300;
   private static final int COMPONENT_HEIGHT = 300;
}
