/* ChessBoard class
   Anderson, Franceschi
*/

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChessBoard extends Application
{
  public void start( Stage stage )
  {
    char [ ] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
    int [ ] digits = { 8, 7, 6, 5, 4, 3, 2, 1 };
    Color [ ] boardColors = { Color.WHITE, Color.RED };
    
    BoardGame game = new BoardGame( digits, letters, boardColors );
    BoardView view = new BoardView( game );
    
    Scene scene = new Scene( view, 450, 450 );
    stage.setScene( scene );
    stage.setTitle( "Click a square to reveal its position" );
    stage.show( );
  }
  
  public static void main( String [] args )
  {
    launch( args );
  }
}
