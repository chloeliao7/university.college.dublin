/** BorderedLabelGridView class
* Reusable generic layout using a BorderPane's
* left and center positions.
* The left VBox is made up of a vertical array of buttons.
* The center position is made up of a grid of labels.
* Accessors are provided so that a Controller can access
* the array of buttons and the 2-dim array (grid) of labels.
* Anderson, Franceschi
*/

import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BorderedLabelGridView extends BorderPane
{
  private VBox buttonPanel; // left, holds array of buttons
  private Button [ ] buttons;
  private GridPane grid; // center, holds grid of labels
  private Label [ ][ ] labels; // grid of labels
  
  // numberOfButtons and gridSize must be greater than 0
  public BorderedLabelGridView( int numberOfButtons, int gridSize )
  {
    super( );
    grid = new GridPane( );
    
    // set up grid as gridSize by gridSize
    RowConstraints row = new RowConstraints( );
    row.setPercentHeight( 100.0 / gridSize );
    ColumnConstraints col = new ColumnConstraints( );
    col.setPercentWidth( 100.0 / gridSize );
    for ( int i = 0; i < gridSize; i++ )
      grid.getRowConstraints( ).add( row );
    for ( int j = 0; j < gridSize; j++ )
      grid.getColumnConstraints( ).addAll( col );
    
    labels = new Label[gridSize][gridSize];
    for ( int i = 0; i < labels.length; i++ )
    {
      for ( int j = 0; j < labels[i].length; j++ )
      {
        labels[i][j] = new Label( );
        // make label fill up available width and height
        labels[i][j].setMaxWidth( Double.MAX_VALUE );
        labels[i][j].setMaxHeight( Double.MAX_VALUE );
        grid.add( labels[i][j], j, i );
      }
    }
    
    buttonPanel = new VBox( );
    
    buttons = new Button[numberOfButtons];
    for ( int i = 0; i < buttons.length; i++ )
    {
      buttons[i] = new Button( );
      // make button fill up available width and height
      buttons[i].setMaxWidth( Double.MAX_VALUE );
      buttons[i].setMaxHeight( Double.MAX_VALUE );
      VBox.setVgrow( buttons[i], Priority.ALWAYS );
      buttonPanel.getChildren( ).add( buttons[i] );
    }
    
    setLeft( buttonPanel );
    setCenter( grid );
  }
  
  public void setButtonText( int row, String text )
  {
    buttons[row].setText( text );
  }
  
  public void setButtonListener( int row, EventHandler<ActionEvent> eh )
  {
    buttons[row].setOnAction( eh );
  }
  
  public void setLabelBackground( int row, int col, String hexColor )
  {
    labels[row][col].setStyle( "-fx-background-color: " + hexColor );
  }
}
