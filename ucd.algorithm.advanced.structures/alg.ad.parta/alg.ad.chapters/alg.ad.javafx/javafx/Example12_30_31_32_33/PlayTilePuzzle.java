/* PlayTilePuzzle class
   Anderson, Franceschi
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlayTilePuzzle extends Application
{
  
  @Override
  public void start( Stage stage )
  {
    TilePuzzle puzzle= new TilePuzzle( 3 );
    TilePuzzleViewController root
      = new TilePuzzleViewController( puzzle );
    
    Scene scene = new Scene( root, 350, 350 );
    stage.setTitle( "The tile puzzle game" );
    stage.setScene( scene );
    stage.show( );
  }
  
  public static void main( String [] args )
  {
    launch( args );
  }
}
