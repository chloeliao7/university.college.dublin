/** SinpleMathController
*   Anderson, Franceschi
*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
 
public class SimpleMathController 
{
  @FXML private TextField operand;
  @FXML private Label result;
  @FXML private Button square;
  @FXML private Button cube;

  @FXML protected void calculate( ActionEvent event ) 
  {
    try
    {
      double op = Double.parseDouble( operand.getText( ) );
      if ( event.getSource( ) == square )
        result.setText( "" + SimpleMath.square( op ) );
      else if ( event.getSource( ) == cube ) 
        result.setText( "" + SimpleMath.cube( op ) );
    }
    catch( NumberFormatException nfe ) 
    {
      operand.setText( "" );
      result.setText( "???" );
    }
  }
}