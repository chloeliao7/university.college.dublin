/* TreasureHunt class
*  Anderson, Franceschi
*/

import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TreasureHunt 
{
 public static int DEFAULT_GAME_SIZE = 300; // side of window
 public static int SIDE = 40; // side of treasure

 private int gameSize;
 private int xCtr; // x coordinate of center of treasure
 private int yCtr; // y coordinate of center of treasure
 private String status = ""; // message
 private boolean gameOver = false;

 /** Constructor
 * @param gameSize the size of the game
 */
 public TreasureHunt( int gameSize )
 {
  if ( gameSize > SIDE )
    this.gameSize = gameSize;
  else
    this.gameSize = DEFAULT_GAME_SIZE;
  // generate treasure center
  Random random = new Random( );
  xCtr = SIDE / 2 + random.nextInt( this.gameSize - SIDE );
  yCtr = SIDE / 2 + random.nextInt( this.gameSize - SIDE );
 }

 /** getGameSize accessor
 * @return gameSize
 */
 public int getGameSize( )
 {
  return gameSize;
 }

 /** isGameOver method
 * @return gameOver
 */
 public boolean isGameOver( )
 {
  return gameOver;
 }

 /** play method
 * @param x the x coordinate of the play
 * @param y the y coordinate of the play
 */
 public void play( int x, int y )
 {
  // is mouse within treasure?
  if ( Math.abs( x - xCtr ) < SIDE / 2
       && Math.abs( y - yCtr ) < SIDE / 2 )
  {
    gameOver = true;
    status = "Found";
  }
  // is mouse within half-length of the treasure?
  else if ( Math.abs( x - xCtr ) < ( 1.5 * SIDE )
            && Math.abs( y - yCtr ) < ( 1.5 * SIDE ) )
    status = "Hot";
  // is mouse within 1 length of the treasure?
  else if ( Math.abs( x - xCtr ) < ( 2 * SIDE )
            && Math.abs( y - yCtr ) < ( 2 * SIDE ) )
    status = "Warm";
  // is mouse within 2 lengths of the treasure?
  else if ( Math.abs( x - xCtr ) < ( 3 * SIDE )
            && Math.abs( y - yCtr ) < ( 3 * SIDE ) )
    status = "Lukewarm";
  else // mouse is not near treasure
    status = "Cold";
 }

 /** draw method
 * @param gc a GraphicsContext reference
 * @param x the x coordinate of the play
 * @param y the y coordinate of the play
 */
 public void draw( GraphicsContext gc, int x, int y )
 {
  gc.clearRect( 0, 0, gameSize, gameSize );
  gc.setFill( Color.BLUE );
  gc.setFont( new Font( 24 ) );

  if ( status.equals( "Found" ) ) // if found, draw treasure
  {
   gc.setFont( new Font( 16 ) );
   gc.setFill( Color.RED );
   gc.fillRect( xCtr - SIDE / 2, yCtr - SIDE / 2, SIDE, SIDE );
   gc.setFill( Color.GREEN );
   gc.fillText( "$$$", xCtr - SIDE / 3, yCtr + SIDE / 6 );
  }
  else
   gc.fillText( status, x, y ); // display current status
 }
}