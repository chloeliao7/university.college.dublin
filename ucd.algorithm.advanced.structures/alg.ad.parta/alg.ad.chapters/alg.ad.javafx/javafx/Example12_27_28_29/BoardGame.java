/* BoardGame class
   Anderson, Franceschi
*/

import javafx.scene.paint.Color;

public class BoardGame
{
  public static char [ ] hexDigits =
         { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
           'A', 'B', 'C', 'D', 'E', 'F' };
  private int [ ] rows;
  private char [ ] columns;
  private Color [ ] colors; // to color the rows and columns
  
  /** Overloaded Constructor
  * @param newRows the rows
  * @param newColumns the columns
  * @param newColors the colors
  */
  public BoardGame( int [ ] newRows, char [ ] newColumns,
                    Color [ ] newColors )
  {
    rows = newRows;
    columns = newColumns;
    colors = newColors;
  }
  
  /** getSquareText method
  * @param row the row index
  * @param column the column index
  * @return a String, a concatenation of columns[column] and rows[row]
  */
  public String getSquareText( int row, int column )
  {
    return String.valueOf( columns[column] ) + rows[row];
  }
  
  /** getSquareColor method
  * @param row the row index
  * @param column the column index
  * @return a String, a hex representation of
  * colors[(row + col) % colors.length]
  */
  public String getSquareColor( int row, int col )
  {
    Color squareColor = colors[(row + col) % colors.length];
    return toHexString( squareColor );
  }
  
  /** toHex utility method
  * @param colorIntensity a double between 0 and 1 inclusive
  * @return a String, the hex representation of colorIntensity times 255
  */
  public String toHex( double colorIntensity )
  {
    int colorIntensityAsInt = ( int ) ( colorIntensity * 255 );
    if ( colorIntensityAsInt > 255 )
      colorIntensityAsInt = 255;
    else if ( colorIntensityAsInt < 0 )
      colorIntensityAsInt = 0;
    
    int firstDigit = colorIntensityAsInt / 16;
    int secondDigit = colorIntensityAsInt % 16;
    
    return String.valueOf( hexDigits[firstDigit] ) + hexDigits[secondDigit];
  }
  
  /** toHexString method
  * @param color a Color
  * @return a String, a hex representation of color
  */
  public String toHexString( Color color )
  {
    String colorText = "#" + toHex( color.getRed( ) )
      + toHex( color.getGreen( ) )
      + toHex( color.getBlue( ) );
    return colorText;
  }
  
  /** getNumberOfRows method
  * @return the number of rows
  */
  public int getNumberOfRows( )
  {
    return rows.length;
  }
  
  /** getNumberOfColumns method
  * @return the number of columns
  */
  public int getNumberOfColumns( )
  {
    return columns.length;
  }
}
