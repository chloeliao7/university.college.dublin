/* PlaySubHunt class
   Anderson, Franceschi
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlaySubHunt extends Application
{
  private final int GAME_SIZE = 500;

  @Override
  public void start( Stage stage )
  {
    SubHunt sub = new SubHunt( GAME_SIZE );
    SubHuntViewController root = 
      new SubHuntViewController( sub, stage, GAME_SIZE, GAME_SIZE );
    
    Scene scene = new Scene( root, 500, 500 );
    stage.setTitle( "Play !!" );
    stage.setScene( scene );
    stage.show( );
  }
  
  public static void main( String [] args )
  {
    launch( args );
  }
}
