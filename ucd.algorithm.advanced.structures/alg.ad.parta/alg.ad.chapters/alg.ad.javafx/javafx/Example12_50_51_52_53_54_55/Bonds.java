/** Bonds class
*   Anderson, Franceschi
*/

public class Bonds extends Investment
{ 
  private final double BOND_GROWTH_RATE = .03;
  
  /* Constructor
  * @param newYears the new number of years  
  */
  public Bonds( int newYears )
  {
    super( newYears, "Bonds" );
    setGrowthRate( BOND_GROWTH_RATE );
    updateAmounts( ); 
  }
    
  /* update method 
  * do nothing method: Leaves the growth rate unchanged
  */
  public void update( ) 
  {
    // growth rate does not change
  }
}
