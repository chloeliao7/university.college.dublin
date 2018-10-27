/**  Tortoise class
*    inherits from abstract Racer class
*    Anderson, Franceschi
*/

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;

public class Tortoise extends Racer
{
   private int speed;
	private Random rand;

   /** Default Constructor: calls Racer default constructor
   */
   public Tortoise( )
   {
     super( );

     // percentage of time (between 90 - 99%) that this tortoise moves each turn
	  rand = new Random( );
     speed = rand.nextInt( 10 ) + 90;
   }

   /** Constructor
   *    @param ID  racer Id, passed to Racer constructor
   *    @param x   x position, passed to Racer constructor
   *    @param y    y position, passed to Racer constructor
   */
   public Tortoise( String ID, int x, int y )
   {
     super( ID, x, y );

     // percentage of time (between 90 - 99%) that this tortoise moves each turn
	  rand = new Random( );
     speed = rand.nextInt( 10 ) + 90;
   }

   /** move:  calculates the new x position for the racer
   *   Tortoise move characteristics: "slow & steady wins the race"
   *      increment x by 1 most of the time
   */
   public void move( )
   {
     int move =  rand.nextInt( 100 )  + 1;
     if ( move < speed )
       setX( getX( ) + 1 );
   }

   /** draw: draws the Tortoise at current (x, y) coordinate
   *       @param gc   GraphicsContext
   */
   public void draw( GraphicsContext gc )
   {
     int startX = getX( );
     int startY = getY( );

     gc.setFill( Color.rgb( 34, 139, 34 ) ); // dark green

     //body
     gc.fillOval( startX - 52, startY, 37, 22.5 );

     //head
     gc.fillOval( startX - 22, startY + 7.5, 22.5, 15 );

     //flatten bottom
     gc.setFill( Color.WHITE );
     gc.fillRect( startX - 52, startY + 16.5, 52.5, 6 );

     //feet
     gc.setFill( Color.rgb( 34, 139, 34 ) ); // dark green
     gc.fillOval( startX - 47.5, startY + 15,  7.5, 7.5 );
     gc.fillOval( startX - 26.5, startY + 15, 7.5, 7.5 );
     
   }
}