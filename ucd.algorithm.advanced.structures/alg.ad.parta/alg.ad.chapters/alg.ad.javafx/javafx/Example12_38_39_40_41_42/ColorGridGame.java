/* ColorGridGame interface
*  Anderson, Franceschi
*/

import javafx.scene.paint.Color;

public interface ColorGridGame
{
  public String getTitle( );
  public int getSize( );
  public int getNumberOfColors( );
  public String getLabel( int index );
  public int getIndex( String label );
  public boolean isCorrect( int index );
  public String getGridHexColor( int row, int col );
}

