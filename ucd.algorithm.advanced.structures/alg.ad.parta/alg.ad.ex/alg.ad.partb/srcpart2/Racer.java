/**  Racer class
*    abstract class intended for racer hierarchy
*    Anderson. Franceschi
*/

import javafx.scene.canvas.GraphicsContext;

public abstract class Racer
{
  private String ID;  // racer ID
  private int x;      // x position
  private int y;      // y position

  /** default constructor
  *    Sets ID to blank
  */
  public Racer( )
  {
    ID = "";
  }

  /** constructor
  *    @param ID   racer ID
  *    @param x    x position
  *    @param y    y position
  */
  public Racer( String ID, int x, int y )
  {
    this.ID = ID;
    this.x = x;
    this.y = y;
  }

  /** accessor for ID
  *   @return  ID
  */
  public String getID( )
  {
    return ID;
  }

  /** accessor for x
  *   @return  current x value
  */
  public int getX( )
  {
    return x;
  }

  /** accessor for y
  *   @return  current y value
  */
  public int getY( )
  {
    return y;
  }

  /** mutator for x
  *   @param  x new value for x
  *   @return a reference to this object
  */
  public Racer setX( int x )
  {
    this.x = x;
    return this;
  }

  /** mutator for y
  *   @param  y new value for y
  *   @return a reference to this object
  */
  public Racer setY( int y )
  {
    this.y = y;
    return this;
  }

  /** abstract method for Racer's move
  */
  public abstract void move( );

  /** abstract method for drawing Racer
  *   @param gc GraphicsContext
  */
  public abstract void draw( GraphicsContext gc );
}
