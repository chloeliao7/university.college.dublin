/*  MixingColorsController class
    Anderson, Franceschi
*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
 
public class MixingColorsController 
{
  private ColorMixer mixer;

  @FXML private CheckBox red;
  @FXML private CheckBox green;
  @FXML private CheckBox blue;
  @FXML private Label label;

  public MixingColorsController( )
  {
    mixer = new ColorMixer( );
  }

  @FXML protected void mix( ActionEvent event ) 
  {
    if ( event.getSource( ) == red )
      mixer.toggleColor( ColorMixer.RED );
    else if ( event.getSource( ) == green )
      mixer.toggleColor( ColorMixer.GREEN );
    else if ( event.getSource( ) == blue )
      mixer.toggleColor( ColorMixer.BLUE );
 
    String style = "-fx-background-color: ";
    style += mixer.hexStringColor( );
    label.setStyle( style ); 
  }
}