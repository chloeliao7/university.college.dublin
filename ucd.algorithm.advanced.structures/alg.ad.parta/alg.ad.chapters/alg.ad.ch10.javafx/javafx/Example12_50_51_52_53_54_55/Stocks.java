/** Stocks class
*   Anderson, Franceschi
*/

public class Stocks extends Investment
{ 
  private static final double SLOW_GROWTH_RATE = .02;
  private static final double FAST_GROWTH_RATE = .07;
  
  /* Constructor
  * @param years the new number of years  
  */ 
  public Stocks( int newYears )
  {
    super( newYears, "Stocks" );
    setGrowthRate( SLOW_GROWTH_RATE ); 
    updateAmounts( ); 
  }
    
  /* update method 
  *  toggles the growth rate and updates amounts accordingly
  */
  public void update( )
  {
    if ( Math.abs( getGrowthRate( ) - SLOW_GROWTH_RATE ) < 0.0001 )
      setGrowthRate( FAST_GROWTH_RATE );
    else
      setGrowthRate( SLOW_GROWTH_RATE );   

    updateAmounts( ); 
  }
}
