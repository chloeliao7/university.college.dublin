/* PlayTreasureHunt class
   Anderson, Franceschi
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlayTreasureHunt extends Application
{
  private final int GAME_SIZE = 500;

  @Override
  public void start( Stage stage )
  {
    TreasureHunt th = new TreasureHunt( GAME_SIZE );
    TreasureHuntViewController root = 
      new TreasureHuntViewController( th, GAME_SIZE, GAME_SIZE );
    
    Scene scene = new Scene( root, GAME_SIZE, GAME_SIZE );
    stage.setTitle( "Play !!" );
    stage.setScene( scene );
    stage.show( );
  }
  
  public static void main( String [] args )
  {
    launch( args );
  }
}
