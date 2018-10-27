/* Sprite class
   Anderson, Franceschi
*/
import javafx.scene.canvas.*;
import javafx.scene.paint.*;

public class Sprite extends Canvas
{
  
  private static final int WIDTH = 95, HEIGHT = 138;
  private int sX;
  private int sY;
  private double scale;
   
  /** default constructor
  *  sX = sY = 0; scale is set to 1
  */
  public Sprite( ) 
  {
    super( WIDTH, HEIGHT );
    scale = 1;    
  }
   
  /* overloaded constructor
  *  accepts values for starting x and y coordinates
  *  and scale
  */
  public Sprite( int sX, int sY, double scale )
  {
    super( );
    setCoordinates( sX, sY );
    this.scale = ( scale > 0.0 ? scale : 1 );
    setWidth( this.scale * WIDTH );
    setHeight( this.scale * HEIGHT );
  }
   
  /* setCoordinates 
  * accepts new values for starting x and y;
  * returns a reference to this object
  */
  public Sprite setCoordinates( int sX, int sY )
  {
    this.sX = sX;
    this.sY = sY;
    return this;
  }
   
  /* mutator for scale
  * returns a reference to this object
  */
  public Sprite setScale( double scale )
  {
    this.scale = ( scale > 0.0 ? scale : this.scale );
    return this;
  }
   
  /* draw method 
  *  draws Sprite at current sX and sY 
  *  multiplying lengths by scale
  *  accepts the GraphicsContext of the canvas
  */
  public void draw( GraphicsContext gc )
  {
    gc.setFill( Color.CORAL ); // body
    gc.fillOval( sX, sY + 15 * scale, 90 * scale, 120 * scale );
    gc.setFill( Color.DARKGOLDENROD ); // hat
    gc.fillRect( sX + 23 * scale, sY, 45 * scale, 22 * scale );
    gc.setStroke( Color.DARKGOLDENROD ); // hat brim
    gc.setLineWidth( 3 );
    gc.strokeLine( sX, sY + 23 * scale, 
                   sX + 90 * scale, sY + 23 * scale );
    gc.setFill( Color.CHOCOLATE ); // eye
    gc.fillOval( sX + 60 * scale, sY + 45 * scale, 
                 18 * scale, 12 * scale );
    gc.setFill( Color.DARKSALMON ); // feet
    gc.setLineWidth( 1 );
    gc.fillOval( sX + 45 * scale, sY + 125 * scale, 
                 45 * scale, 12 * scale );
    gc.strokeOval( sX + 45 * scale, sY + 125 * scale, 
                   45 * scale, 12 * scale );
    gc.fillOval( sX + 27 * scale, sY + 127 * scale, 
                 45 * scale, 12 * scale );
    gc.strokeOval( sX + 27 * scale, sY + 127 * scale, 
                   45 * scale, 12 * scale );
  }
}