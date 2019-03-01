/*  Simple Math Operations Using Buttons
    Anderson, Franceschi
*/

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SimpleMathPractice extends Application 
{  
  @Override
  public void start( Stage stage ) // throws Exception 
  {
    try 
    {
      URL url = 
         getClass( ).getResource( "fxml_simple_math.fxml" );
      VBox root = FXMLLoader.load( url );
      Scene scene = new Scene( root, 300, 275 );
      scene.getStylesheets( ).add( "simple_math.css" );
      stage.setTitle( "Simple Math" );
      stage.setScene( scene ); 
      stage.show( );
    }
    catch ( Exception e )
    {
      e.printStackTrace( ); 
    }
  }
 
  public static void main( String [] args ) 
  {
    launch( args );
  }
}