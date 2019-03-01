/*  Slider demo
    Anderson, Franceschi
*/

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PhotoGraying extends Application 
{  
  @Override
  public void start( Stage stage )
  {
    try 
    {
      URL url = 
        getClass( ).getResource( "fxml_photo_grayer.fxml" );
      VBox root = FXMLLoader.load( url );
      Scene scene = new Scene( root, 300, 320 );
      stage.setTitle( "Graying a photo" );
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