/** ColorFrequencyGame class
    Anderson, Franceschi
*/

import java.util.Random;
import javafx.scene.paint.Color;

public class ColorFrequencyGame implements ColorGridGame
{
  public static char [] hexDigits =
     { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
       'A', 'B', 'C', 'D', 'E', 'F' };
  
  private final int DEFAULT_SIZE = 8;
  private Color [][] gridColors;
  private Color [] coloringColors;
  private int [] counts; // color frequencies in gridColors
  
  private String [] labels;
  
  /** Constructor
  * @param size number of rows and columns in gridColors
  * @param colors array of colors
  * @param labels the starting labels
  */
  public ColorFrequencyGame( int size, Color [] colors,
                            String [] labels )
  {
    if ( size <= 0 )
      size = DEFAULT_SIZE;
    gridColors = new Color[size][size];
    coloringColors = colors;
    counts = new int[coloringColors.length];
    fillGridWithColors( );
    this.labels = labels;
  }
  
  /** fillGridWithColors method
  *   randomly fills gridColors with colors from coloringColors
  */
  public void fillGridWithColors( )
  {
    Random random = new Random( );
    for ( int i = 0; i < gridColors.length; i++ )
    {
      for ( int j = 0; j < gridColors[i].length; j++ )
      {
        int colorIndex = random.nextInt( coloringColors.length );
        gridColors[i][j] = coloringColors[colorIndex];
        counts[colorIndex] += 1;
      }
    }
  }
  
  /** getSize method
  * @return length of gridColors
  */
  public int getSize( )
  {
    return gridColors.length;
  }
  
  /** getNumberOfColors method
  * @return length of coloringColors
  */
  public int getNumberOfColors( )
  {
    return coloringColors.length;
  }
  
  /** getGridHexColor method
  * @param row, an int, the row index
  * @param col, an int, the column index
  * @return a String, the hex equivalent of gridColor[row][col]
  */
  public String getGridHexColor( int row, int col )
  {
    String colorText = "#"
      + toHex( ( int ) ( 255 * gridColors[row][col].getRed( ) ) )
      + toHex( ( int ) ( 255 * gridColors[row][col].getGreen( ) ) )
      + toHex( ( int ) ( 255 * gridColors[row][col].getBlue( ) ) );
    return colorText;
  }
  
  /** toHex method
  * @return a String, the Hex equivalent of colorIntensity
  */
  public String toHex( int colorIntensity )
  {
    if ( colorIntensity > 255 )
      colorIntensity = 255;
    else if ( colorIntensity < 0 )
      colorIntensity = 0;
    
    int firstDigit = colorIntensity / 16;
    int secondDigit = colorIntensity % 16;
    return String.valueOf( hexDigits[firstDigit] ) + hexDigits[secondDigit];
  }
  
  /** highestCount method
  * @return the highest color frequency in the grid
  */
  public int highestCount( )
  {
    int max = counts[0];
    for ( int i = 1; i < counts.length; i++ )
    {
      if ( counts[i] > max )
        max = counts[i];
    }
    return max;
  }
  
  /** isCorrect method
  * @param index the index in the coloringColors array to check
  * @return true if the frequency of the color for index
  * is the highest, false otherwise
  */
  public boolean isCorrect( int index )
  {
    return counts[index] == highestCount( );
  }
  
  /** getTitle method
  * @return a String representing a title for this object
  */
  public String getTitle( )
  {
    return "What is the most frequent color?";
  }
  
  /** getLabel method
  * @param index the index of the color name
  * @return the color name
  */
  public String getLabel( int index )
  {
    return labels[index];
  }
  
  /** getIndex method
  * @param label the color name in the labels array 
  * @return index of the color namein the labels array
  */
  public int getIndex( String label )
  {
    for ( int i = 0; i < labels.length; i++ )
    {
      if ( labels[i].equals( label ) )
        return i;
    }
    return -1;
  }
}
