import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
   A car shape that can be positioned anywhere on the screen.
*/
public class Car
{
   private int xLeft;
   private int yTop;
   private int xWidth;
   private int yHeight;

   /**
      Constructs a car with a given top left corner
      @param x the x coordinate of the top left corner
      @param y the y coordinate of the top left corner
      @param width the width of the car
      @param height the height of the car
   */
   public Car(int x, int y, int width, int height)
   {
      xLeft = x;
      yTop = y;
      xWidth = width;
      yHeight = height;
   }

   /**
      Draws the car.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
      Rectangle body 
            = new Rectangle(xLeft, yTop + yHeight / 3, xWidth, yHeight / 3);      
      Ellipse2D.Double frontTire 
            = new Ellipse2D.Double(xLeft + yHeight / 12, 
               yTop + yHeight * 2 / 3, 
               yHeight / 3, yHeight / 3);
      Ellipse2D.Double rearTire
            = new Ellipse2D.Double(xLeft + xWidth - yHeight * 5 / 12, 
               yTop + yHeight * 2 / 3, 
               yHeight / 3, yHeight / 3);

      // The bottom of the front windshield
      Point2D.Double r1 
            = new Point2D.Double(xLeft + xWidth / 6, yTop + yHeight / 3);
      // The front of the roof
      Point2D.Double r2 
            = new Point2D.Double(xLeft + xWidth / 3, yTop);
      // The rear of the roof
      Point2D.Double r3 
            = new Point2D.Double(xLeft + xWidth * 2 / 3, yTop);
      // The bottom of the rear windshield
      Point2D.Double r4 
            = new Point2D.Double(xLeft + xWidth * 5 / 6, yTop + yHeight / 3);

      Line2D.Double frontWindshield 
            = new Line2D.Double(r1, r2);
      Line2D.Double roofTop 
            = new Line2D.Double(r2, r3);
      Line2D.Double rearWindshield
            = new Line2D.Double(r3, r4);
   
      g2.draw(body);
      g2.draw(frontTire);
      g2.draw(rearTire);
      g2.draw(frontWindshield);      
      g2.draw(roofTop);      
      g2.draw(rearWindshield);      
   }
}
