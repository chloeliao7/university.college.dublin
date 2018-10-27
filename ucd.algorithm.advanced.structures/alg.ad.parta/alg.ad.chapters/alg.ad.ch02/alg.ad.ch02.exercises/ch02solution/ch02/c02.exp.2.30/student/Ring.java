import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
   A class that draw the Olympic rings.
*/
public class Ring
{
   ...
   /**
      Constructs a circle that represents the Olympic rings.
      @param anX the x coordinate
      @param aY the y coordinate
      @param aRadius the radius of the circle
      @param aColor the color of the ring
   */
   public Ring(double anX, double aY, double aRadius, Color aColor)
   {
      ...
   }

   /**
      Draws the ring.
      @param g2 the graphic context
   */
   public void draw(Graphics2D g2)
   {
      ...
   }
}
