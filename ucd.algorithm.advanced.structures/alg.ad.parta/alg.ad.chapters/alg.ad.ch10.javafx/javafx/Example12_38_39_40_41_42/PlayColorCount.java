/** PlayColorCount class
*   Anderson, Franceschi
*/

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlayColorCount extends Application
{
  
  @Override
  public void start( Stage stage )
  {
    Color [] colors = { Color.RED, Color.GREEN, Color.BLUE };
    String [] labels = { "RED", "GREEN", "BLUE" };
    
    ColorFrequencyGame game
      = new ColorFrequencyGame( 8, colors, labels );
    
    BorderedLabelGridView root
      = new BorderedLabelGridView( colors.length, game.getSize( ) );
    
    ColorGridGameController controller
       = new ColorGridGameController( game, root );

    Scene scene = new Scene( root, 450, 425 );
    stage.setTitle( game.getTitle( ) );
    stage.setScene( scene );
    stage.show( );
    
  }
  
  public static void main( String [] args )
  {
    launch( args );
  }
}
