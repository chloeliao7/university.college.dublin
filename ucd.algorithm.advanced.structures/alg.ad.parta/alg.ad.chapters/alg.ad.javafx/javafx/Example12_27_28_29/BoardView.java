/* Using GridPane to organize our window
   Anderson, Franceschi
*/

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

public class BoardView extends GridPane
{
  private BoardGame game;
  private Button [][] squares;
  
  public BoardView( BoardGame newGame )
  {
    super( );
    game = newGame;
    
    // set up grid according to Model
    int rows = game.getNumberOfRows( );
    int columns = game.getNumberOfColumns( );
    RowConstraints row = new RowConstraints( );
    row.setPercentHeight( 100.0 / rows );
    ColumnConstraints col = new ColumnConstraints( );
    col.setPercentWidth( 100.0 / columns );
    for ( int i = 0; i < rows; i++ )
      getRowConstraints( ).add( row );
    for ( int j = 0; j < columns; j++ )
      getColumnConstraints( ).add( col );
    
    squares = new Button[rows][columns];
    ButtonHandler bh = new ButtonHandler( );
    
    for ( int i = 0; i < rows; i++ )
    {
      for ( int j = 0; j < columns; j++ )
      {
        // instantiate the button with no text
        squares[i][j] = new Button( );
        
        // color the button
        squares[i][j].setStyle( "-fx-background-color:"
                                 + game.getSquareColor( i, j ) );
        
        // add the button
        add( squares[i][j], j, i );
        
        // make button fill up available width and height
        squares[i][j].setMaxWidth( Double.MAX_VALUE );
        squares[i][j].setMaxHeight( Double.MAX_VALUE );
        
        // register listener on button
        squares[i][j].setOnAction( bh );
      }
    }
  }
  
  // private inner class event handler
  private class ButtonHandler implements EventHandler<ActionEvent>
  {
    @Override
    public void handle( ActionEvent event )
    {
      for ( int i = 0; i < squares.length; i++ )
      {
        for ( int j = 0; j < squares[i].length; j++ )
        {
          if ( event.getSource( ) == squares[i][j] )
          {
            squares[i][j].setText( game.getSquareText( i, j ) );
            return;
          }
        }
      }
    }
  }
}
