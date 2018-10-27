/** GridButton class
*   Anderson, Franceschi
*/

import javafx.scene.control.Button;

public class GridButton extends Button
{
  private int row;
  private int column;
  
  /** Constructor
  * @param title
  * @param newRow row
  * @param newColumn column
  */
  public GridButton( String title, int newRow, int newColumn )
  {
    super( title );
    setRow( newRow );
    setColumn( newColumn );
  }
  
  /** getRow method, accessor for row
  * @return row
  */
  public int getRow( )
  {
    return row;
  }
  
  /** getColumn method, accessor for column
  * @return column
  */
  public int getColumn( )
  {
    return column;
  }
  
  /** setRow method, mutator for row
  * @param row, new value for row
  */
  public void setRow( int row )
  {
    if ( row >= 0 )
      this.row = row;
  }
  
  /** setColumn method
  * @param column, new value for column
  */
  public void setColumn( int column )
  {
    if ( column >= 0 )
      this.column = column;
  }
}
