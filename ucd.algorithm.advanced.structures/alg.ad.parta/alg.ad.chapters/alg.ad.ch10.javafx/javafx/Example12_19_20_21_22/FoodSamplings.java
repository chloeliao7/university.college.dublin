/*  Using ComboBox to show a sampling of international foods
    Anderson, Franceschi
*/

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FoodSamplings extends Application 
{  
  @Override
  public void start( Stage stage )
  {
   try 
   {
     URL url = 
        getClass( ).getResource( "fxml_food_samplings.fxml" );
     HBox root = FXMLLoader.load( url );
     Scene scene = new Scene( root, 400, 200 );
     stage.setTitle( "Food samplings of various countries" );
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