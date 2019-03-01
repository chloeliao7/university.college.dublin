/*  Animation Sampler
    demonstrates various animations
    Anderson, Franceschi
*/

import java.net.URL;
import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.stage.*;

public class AnimationSampler extends Application 
{  
  @Override
  public void start( Stage stage ) // throws Exception 
  {
    try 
    {
      URL url = 
         getClass( ).getResource( "fxml_animation.fxml" );
      BorderPane root = FXMLLoader.load( url );
      Scene scene = new Scene( root, 800, 600 );
      stage.setTitle( "Animation Sampler" );
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