import java.awt.Graphics2D;

/**
   This class represents a vehicle.
*/
public abstract class Vehicle
{
   private int xleft;
   private int ytop;

   /**
      Construct a Vehicle object.
   */
   public Vehicle()
   {
      xleft = 0;
      ytop = 0;
   }

   /**
      Draw the specified vehicle.
      @param g2 the graphics context
   */
   public abstract void draw(Graphics2D g2);

   /**
      Set the location of the vehicle.
      @param x the x coordinate
      @param y the y coordinate
   */
   public void setLocation(int x, int y)
   {
      xleft = x;
      ytop = y;
   }
   
   /**
      Returns the x coordinate of the left-top corner of the vehicle
      @return the x coordinate
    */
   public int getX()
   {
      return xleft;
   }
   
   /**
      Returns the y coordinate of the left-top corner of the vehicle
      @return the y coordinate
    */
   public int getY()
   {
      return ytop;
   }
   
   public abstract int getHeight();
   public abstract int getWidth();
}