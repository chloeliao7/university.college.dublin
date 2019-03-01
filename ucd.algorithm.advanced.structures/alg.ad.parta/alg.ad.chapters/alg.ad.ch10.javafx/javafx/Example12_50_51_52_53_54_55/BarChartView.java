/** BarChartView class
* Layout using a BorderPane's
* bottom and center positions.
* The bottom HBox is made up of one button.
* The center position is made up of a BarChart.
* Anderson, Franceschi
*/

import java.util.ArrayList;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.chart.*;

public class BarChartView extends BorderPane
{
  private HBox buttonPanel; // bottom, holds button
  private Button button;
  private BarChart<String, Number> bc; // center, holds chart

  ArrayList<XYChart.Series<String, Number>> series;
  private int startingYear;
  
  public BarChartView( int startingYear, Investment [] investments )
  {
    super( );
    this.startingYear = startingYear; 
    
    buttonPanel = new HBox( );
    button = new Button( );
    button.setText( "NEXT SCENARIO" );
    buttonPanel.setAlignment( Pos.CENTER );
    buttonPanel.getChildren( ).add( button );
    setBottom( buttonPanel );
    
    addBarChart( investments );
  }
  
  public void addBarChart( Investment [] investments )
  {         
    // Create a BarChart for investment
    CategoryAxis xAxis = new CategoryAxis( );
    NumberAxis yAxis = new NumberAxis( );
    bc = new BarChart<String, Number>( xAxis, yAxis );
    bc.setTitle( "Investment Scenarios" );
    xAxis.setLabel( "Year" );       
    yAxis.setLabel( "Value" );
  
    // Create an ArrayList of XYChart.Series using investments data
    series = new ArrayList<XYChart.Series<String, Number>>( );        
          
    for ( int i = 0; i < investments.length; i++ )
    {  
      XYChart.Series<String, Number> currentInvestmentSeries 
        = new XYChart.Series<String, Number>( );
      currentInvestmentSeries.setName( investments[i].getType( ) );
        
      double [] currentAmounts = investments[i].getAmounts( );
      for ( int j = 0; j < currentAmounts.length; j++ )
      {      
        currentInvestmentSeries.getData( ).add( 
           new XYChart.Data<String, Number>( "" 
             + ( startingYear + j ), currentAmounts[j] ) );
      }      
      series.add( currentInvestmentSeries );
    }       
    // Fill BarChart with XYChart.Series array
    bc.getData( ).addAll( series ); 
    setCenter( bc );
  }

  public void update( Investment [] investments )
  {
    // update investments
    for ( int i = 0; i < investments.length; i++ )
    {
      // do not update bonds series
      if ( ! investments[i].getType( ).equals( "Bonds" ) )
      {
        // retrieve series
        XYChart.Series<String, Number> currentInvestmentSeries 
          = series.get( i );
        
        // change data of series
        currentInvestmentSeries.getData( ).clear( );
        double [] currentAmounts = investments[i].getAmounts( );
        for ( int j = 0; j < currentAmounts.length; j++ )
        {          
           currentInvestmentSeries.getData( ).add( 
             new XYChart.Data<String, Number>(  
               String.valueOf( startingYear + j ), currentAmounts[j] ) );
        }
                
        // update series
        series.set( i, currentInvestmentSeries );
      } 
    } 
  }
    
  public void setButtonListener( EventHandler<ActionEvent> eh )
  {
    button.setOnAction( eh );
  }
}
