/*  JavaFX Shell Application
    Anderson, Franceschi
*/

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXShellApplication extends Application 
{  
  @Override
  // start is main entry point for the application
  // it receives a Stage object - the main window for the 
  // GUI application
  public void start( Stage stage ) // throws Exception 
  {
    try 
    {
      // Locate the FXML resource
      URL url 
         = getClass( ).getResource( "fxml_shell.fxml" );
  
      // Load the FXML resource, instantiate root Node
      // use appropriate layout class for root Node; 
      // here we use HBox
      HBox root = FXMLLoader.load( url );
    
      // create a scene associated with the root
      // and set its width and height
      Scene scene = new Scene( root, 300, 275 );

      // assign the scene to the stage object 
      stage.setScene( scene );
 
      // set title of stage (optional)
      stage.setTitle( "JavaFX Shell" );

      // make the stage visible
      stage.show( );
    }
    // The FXMLLoader load method throws an exception if
    // the FXML file is invalid or the URL was not found   
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