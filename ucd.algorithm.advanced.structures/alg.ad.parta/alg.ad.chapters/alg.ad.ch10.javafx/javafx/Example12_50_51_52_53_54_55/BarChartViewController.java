/** BarChartViewController class
*   Anderson, Franceschi
*/

import javafx.event.*;
import javafx.scene.control.*;

public class BarChartViewController implements EventHandler<ActionEvent>
{
  private BarChartView view;
  private Investment [] investments;
  
  public BarChartViewController( BarChartView view, 
                                 Investment [] investments )
  {
    this.investments = investments;
    this.view = view;    
    this.view.setButtonListener( this );
  }
  
  public void handle( ActionEvent event )
  {
    // update the model
    for ( int i = 0; i < investments.length; i++ )
      investments[i].update( );
    // update the view
    view.update( investments ); 
  }
}
