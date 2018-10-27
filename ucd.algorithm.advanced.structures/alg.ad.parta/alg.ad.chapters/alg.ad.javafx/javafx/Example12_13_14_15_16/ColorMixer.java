/*  ColorMixer class
    Anderson, Franceschi
*/

public class ColorMixer
{
  public static final int RED = 0;
  public static final int GREEN = 1;
  public static final int BLUE = 2;

  private boolean [] rgb;

  /** default constructor
  *   sets all elements in the rgb array to true
  *   to represent the color white
  */
  public ColorMixer( )
  {
    rgb = new boolean[3];
    rgb[RED] = true;
    rgb[GREEN] = true;
    rgb[BLUE] = true;
  }

  /** toggleColor method
  *   toggles the color on/off
  *   @param color  the color to be toggled
  */   
  public void toggleColor( int color )
  { 
    rgb[color] = !rgb[color];
  }
  
  /** hexStringColor
  *  @return the hexadecimal representation
  *          of the color mix
  */  
  public String hexStringColor( )
  { 
    String result = "#";
    
    result += ( rgb[RED] ? "FF" : "00" );
    result += ( rgb[GREEN] ? "FF" : "00" );
    result += ( rgb[BLUE] ? "FF" : "00" );

    return result;   
  }
}