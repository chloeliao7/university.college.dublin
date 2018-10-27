/**  Chapter 10 PA 1 Teller Application
 *   Anderson, Franceschi
*/
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Teller extends Application
{		
	@Override
	public void start( Stage primaryStage ) 
	{
		try 
		{
			FXMLLoader loader = new FXMLLoader( );
			loader.setLocation( getClass( ).getResource( "teller.fxml" ) );
			      
			VBox root = loader.load( );
			Scene scene = new Scene( root, 700, 600 );
				
			primaryStage.setScene( scene );
			primaryStage.setTitle( "Savings Account Ledger" );
			primaryStage.show( );
	    } 
		catch ( Exception e ) 
		{
			e.printStackTrace( );
	    }
     }
		
	public static void main( String[] args ) {
		launch( args );
	}
}

