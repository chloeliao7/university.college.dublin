import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
   A class that draw the Olympic rings.
*/
public class Ring
{
   private double x;
   private double y;
   private double radius;
   private Color color;

   /**
      Constructs a circle that represents the Olympic rings.
      @param anX the x coordinate
      @param aY the y coordinate
      @param aRadius the radius of the circle
      @param aColor the color of the ring
   */
   public Ring(double anX, double aY, double aRadius, Color aColor)
   {
      x = anX;
      y = aY;
      radius = aRadius;
      color = aColor;
   }

   /**
      Draws the ring.
      @param g2 the graphic context
   */
   public void draw(Graphics2D g2)
   {
      g2.setColor(color);

      Ellipse2D.Double e = new Ellipse2D.Double(x, y, 2 * radius, 2 * radius);

      g2.draw(e);
   }
}
