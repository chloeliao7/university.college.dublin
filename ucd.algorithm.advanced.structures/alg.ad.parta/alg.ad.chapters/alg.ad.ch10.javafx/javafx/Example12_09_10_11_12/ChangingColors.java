/*  Select a Color Using RadioButtons
    Anderson, Franceschi
*/

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChangingColors extends Application 
{  
  @Override
  public void start( Stage stage )
  {
    try 
    {
      URL url = 
       getClass( ).getResource( "fxml_changing_colors.fxml" );
      HBox root = FXMLLoader.load( url );
      Scene scene = new Scene( root, 400, 200 );
      stage.setTitle( "Selecting a color" );
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