/** InvestmentApplication class
*   Anderson, Franceschi
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InvestmentApplication extends Application
{
  @Override
  public void start( Stage stage )
  {    
    int years = 4;
    Stocks stocks = new Stocks( years );
    Bonds bonds = new Bonds( years );
    Investment [] investments = { bonds, stocks };
    
    BarChartView root = new BarChartView( 2020, investments );
    
    Scene scene = new Scene( root, 540, 510 );
    stage.setTitle( "Financial Projections" );
    stage.setScene( scene );
    stage.show( );
    
    BarChartViewController controller
      = new BarChartViewController( root, investments );
  }
  
  public static void main( String [] args )
  {
    launch( args );
  }
}
