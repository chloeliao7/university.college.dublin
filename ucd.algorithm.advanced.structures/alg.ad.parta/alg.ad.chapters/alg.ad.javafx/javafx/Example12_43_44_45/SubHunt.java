/* SubHunt class
*  Anderson, Franceschi
*/

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;

public class SubHunt
{
  public static int DEFAULT_GAME_SIZE = 300;
  public static int SIDE = 36; // size of submarine

  private int gameSize;
  private int xCtr; // x coordinate of center of submarine
  private int yCtr; // y coordinate of center of submarine
  private String status = "";
  private boolean hit;

  /** Constructor
  * @param gameSize the game size
  */
  public SubHunt( int gameSize )
  {
    if ( gameSize > SIDE )
       this.gameSize = gameSize;
    else
       this.gameSize = DEFAULT_GAME_SIZE;
    // generate submarine center
    Random random = new Random( );
    xCtr = SIDE / 2 + random.nextInt( this.gameSize - SIDE );
    yCtr = SIDE / 2 + random.nextInt( this.gameSize - SIDE );
    hit = false; 
  }
 
  /** getStatus Accessor
  * @return status
  */
  public String getStatus( )
  {
    return status;
  }

  /** getGameSize Accessor
  * @return gameSize
  */
  public int getGameSize( )
  {
    return gameSize;
  }

  /** isHit method
  * @return hit, which indicates whether sub has been hit
  */
  public boolean isHit( )
  {
    return hit;
  }

  /** play method
  * @param x the x coordinate of the play
  * @param y the y coordinate of the play
  */
  public void play( int x, int y )
  {
    // is click within the submarine?
    if ( Math.abs( x - xCtr ) < SIDE / 2
         && Math.abs( y - yCtr ) < SIDE / 2 )
    {
      status = "Sunk!";
      hit = true;
    }
    // is click close?
    else if ( Math.abs( x - xCtr ) < 2 * SIDE
              && Math.abs( y - yCtr ) < 2 * SIDE )
      status = "Close ...";
    // click is too far from submarine
    else
      status = "In the water";
  }

  /** draw method
  * @param gc a GraphicsContext object
  * @param x the x coordinate of the play
  * @param y the y coordinate of the play
  */
  public void draw( GraphicsContext gc, int x, int y )
  {
    if ( status.equals( "Sunk!" ) )
    {
      // draw sunken submarine
      gc.setFill( Color.BLACK );
      gc.fillRoundRect( xCtr - SIDE/2, yCtr - SIDE/2, 
                        SIDE/2, SIDE, SIDE/2, SIDE/2 ); 
                          
      gc.fillRoundRect( xCtr - SIDE/4, yCtr - SIDE/3, 
                        SIDE/2, SIDE/2, SIDE/4, SIDE/4 ); 
                          
      gc.strokeLine( xCtr + SIDE/4, yCtr - SIDE/9,
                     xCtr + SIDE/2, yCtr - SIDE/9 );
      
      // draw red depth charge
      gc.setFill( Color.RED );
      gc.fillOval( x - SIDE/2, y - SIDE/2, SIDE, SIDE );
    }
    else if ( status.equals( "In the water" ) ) // draw blue circle
    {
      gc.setFill( Color.BLUE );
      gc.fillOval( x - SIDE/2, y - SIDE/2, SIDE, SIDE );
    }
    // else Close ... , do not draw
  }
}