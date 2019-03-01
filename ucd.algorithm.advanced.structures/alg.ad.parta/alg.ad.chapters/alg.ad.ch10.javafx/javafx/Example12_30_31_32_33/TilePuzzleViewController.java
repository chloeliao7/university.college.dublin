/* Using GridPane dynamically
   Anderson, Franceschi
*/

import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class TilePuzzleViewController extends GridPane
{
  private GridButton [][] squares;
  private TilePuzzle game; // the tile puzzle game
  
  public TilePuzzleViewController( TilePuzzle newGame )
  {
    super( );
    game = newGame;
    setUpGameGUI( );
  }
  
  public void setUpGameGUI( )
  {
    // remove all components and constraints
    getChildren( ).clear( );
    getRowConstraints( ).clear( );
    getColumnConstraints( ).clear( );
    
    // set up grid constraints
    RowConstraints row = new RowConstraints( );
    row.setPercentHeight( 100.0 / game.getSide( ) );
    ColumnConstraints col = new ColumnConstraints( );
    col.setPercentWidth( 100.0 / game.getSide( ) );
    for ( int i = 0; i < game.getSide( ); i++ )
      getRowConstraints( ).add( row );
    for ( int j = 0; j < game.getSide( ); j++ )
      getColumnConstraints( ).addAll( col );
    
    squares = new GridButton [game.getSide( )][game.getSide( )];
    ButtonHandler bh = new ButtonHandler( );
    
    for ( int i = 0; i < game.getSide( ); i++ )
    {
      for ( int j = 0; j < game.getSide( ); j++ )
      {
        squares[i][j] = new GridButton( game.getTiles( )[i][j], i, j );
        
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
  
  public void update( )
  {
    for ( int i = 0; i < game.getSide( ); i++ )
      for ( int j = 0; j < game.getSide( ); j++ )
         squares[i][j].setText( game.getTiles( )[i][j] );
    
    if ( game.won( ) )
    {
      showMessageDialog( "Congratulations", 
                         "You won\nSetting up a new game" );
      Random random = new Random( );
      int sideOfPuzzle = 3 + random.nextInt( 4 );
      game.setUpGame( sideOfPuzzle );
      setUpGameGUI( );
    }
  }
  
  public void showMessageDialog( String title, String message )
  {
    Alert alert = new Alert( AlertType.INFORMATION );
    alert.setTitle( title );
    alert.setHeaderText( "" );
    alert.setContentText( message );
    alert.showAndWait( ); 
  }
 
  // private inner class event handler
  private class ButtonHandler implements EventHandler<ActionEvent>
  {
    @Override
    public void handle( ActionEvent event )
    {
      GridButton button = ( GridButton ) event.getSource( );
      if ( game.tryToPlay( button.getRow( ), button.getColumn( ) ) )
        update( );
    }
  }
}
