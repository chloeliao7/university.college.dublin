/*  Displaying a Label and image
    Anderson, Franceschi
*/

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Dinner extends Application 
{  
  
  @Override
  public void start( Stage stage )
  {
    try 
    {
      // find the XML resource
      URL url 
         = getClass( ).getResource( "fxml_dinner.fxml" );
      // load the XML resource and instantiate the root node 
      VBox root = FXMLLoader.load( url );
      
      // create a scene      
      Scene scene = new Scene( root, 300, 275 );

      // set the scene     
      stage.setScene( scene );
      // set title of stage
      stage.setTitle( "What's for dinner?" );
      // show the stage
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