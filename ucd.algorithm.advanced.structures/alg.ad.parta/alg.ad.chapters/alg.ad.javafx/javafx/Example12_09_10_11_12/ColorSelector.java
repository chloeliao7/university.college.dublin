/*  ColorSelector class
    Anderson, Franceschi
*/

public class ColorSelector
{
  public static final int RED = 0;
  public static final int GREEN = 1;
  public static final int BLUE = 2;

  /** colorToHexString method
  *  @param selection  the selected color
  *  @return the hex representation of the selected color
  */
  public static String colorToHexString( int selection )
  { 
    String result = "#";
    if ( selection == RED )
      result += "FF0000";
    else if ( selection == GREEN )
      result += "00FF00";
    else if ( selection == BLUE )
      result += "0000FF";
    return result;   
  }
}