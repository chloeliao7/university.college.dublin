/** ColorGridGameController class
*   Anderson, Franceschi
*/

import javafx.event.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ColorGridGameController implements EventHandler<ActionEvent>
{
  private ColorGridGame model;
  private BorderedLabelGridView view;
  
  public ColorGridGameController( ColorGridGame model,
                                  BorderedLabelGridView view )
  {
    this.model = model;
    this.view = view;
    setUpGame( );
  }
  
  public void setUpGame( )
  {
    setUpLabels( );
    setUpButtons( );
  }
  
  public void setUpLabels( )
  {
    for ( int i = 0; i < model.getSize( ); i++ )
      for ( int j = 0; j < model.getSize( ); j++ )
        view.setLabelBackground( i, j, model.getGridHexColor( i, j ) );
  }
  
  public void setUpButtons( )
  {
    for ( int i = 0; i < model.getNumberOfColors( ); i++ )
    {
      view.setButtonText( i, model.getLabel( i ) );
      view.setButtonListener( i, this );
    }
  }
  
  public void handle( ActionEvent event )
  {
    Button button = ( Button ) event.getSource( );
    int index = model.getIndex( button.getText( ) );
    
    if ( model.isCorrect( index ) )
      showMessageDialog( "Congratulations", "You won" );
    else
      showMessageDialog( "Sorry", "You lost" );
    // disable buttons here
  }
  
  public void showMessageDialog( String title, String message )
  {
    Alert alert = new Alert( AlertType.INFORMATION );
    alert.setTitle( title );
    alert.setHeaderText( "" );
    alert.setContentText( message );
    alert.showAndWait( );
  }
}
