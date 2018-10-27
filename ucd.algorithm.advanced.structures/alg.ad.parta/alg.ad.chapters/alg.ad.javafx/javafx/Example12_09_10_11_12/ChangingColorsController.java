/*  ChangingColorsController class
    Anderson, Franceschi
*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
 
public class ChangingColorsController 
{
  @FXML private RadioButton red;
  @FXML private RadioButton green;
  @FXML private RadioButton blue;
  @FXML private Label label;

  @FXML protected void colorChosen( ActionEvent event ) 
  {
    String style = "-fx-background-color: ";

    if ( event.getSource( ) == red )
     style += 
      ColorSelector.colorToHexString( ColorSelector.RED );
    else if ( event.getSource( ) == green )
     style += 
      ColorSelector.colorToHexString( ColorSelector.GREEN );
    else if ( event.getSource( ) == blue )
     style += 
      ColorSelector.colorToHexString( ColorSelector.BLUE );
 
    label.setStyle( style ); 
 }
}