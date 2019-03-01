/** abstract Investment class
*   Anderson, Franceschi
*/

public abstract class Investment
{ 
  public static final int DEFAULT_YEARS = 4;
  public static final double BEGIN_INVEST_AMOUNT = 100;
  private double [] amounts;
  private int years;
  private double growthRate;
  private String type;
   
  /* Constructor
  * @param years, an int, the new value of years 
  * @param type, a String, the new value for the investment type 
  */ 
  public Investment( int years, String type )
  {
    if ( years < 1 )
      this.years = DEFAULT_YEARS;
    else
      this.years = years;
      
    amounts = new double[this.years];
    amounts[0] = BEGIN_INVEST_AMOUNT;
     
    this.type = type;
  }
   
  /* getAmounts method 
  * @return a copy of amounts, a double []
  */ 
  public double [] getAmounts( )
  {
    double [] temp = new double[amounts.length];
    for ( int i = 0; i < amounts.length; i++ )
        temp[i] = amounts[i];
    return temp;
  }
  
  /* Accessor method for years 
  * @return number of years
  */ 
  public int getYears( )
  {
    return years;
  }
  
  /* Accessor method for type 
  * @return investment type
  */ 
  public String getType( )
  {
    return type;
  }
 
  /* Accessor method for growthRate 
  * @return growthRate
  */ 
  public double getGrowthRate( )
  {
    return growthRate;
  }

  /* Mutator method for growthRate
  * @param growthRate, the new value for growthRate 
  * @return a reference to this object
  */ 
  public Investment setGrowthRate( double growthRate )
  {
    this.growthRate = growthRate;
    return this;
  }

  /* updateAmounts method
  * updates amounts based on growthRate
  */ 
  public void updateAmounts( )
  {
    for ( int i = 1; i < amounts.length; i++ )  
      amounts[i] = amounts[i-1] * ( 1 + growthRate );
  }
  
  /* update abstract method 
  */ 
  public abstract void update( );
}
