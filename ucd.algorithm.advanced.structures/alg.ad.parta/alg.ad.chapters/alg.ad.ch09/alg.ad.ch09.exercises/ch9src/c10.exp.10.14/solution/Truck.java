import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
   This class represents a truck.
*/
public class Truck extends Vehicle
{   
   private final int TRUCK_WIDTH = 100;
   private final int TRUCK_HEIGHT = TRUCK_WIDTH / 2 ;

   /**
      Draw the truck.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
      Rectangle body = new Rectangle(getX(), getY() + TRUCK_HEIGHT / 5, 
            TRUCK_WIDTH / 5, TRUCK_HEIGHT * 3 / 5);
      Rectangle cargo = new Rectangle(getX() + TRUCK_WIDTH / 5, getY(), 
            TRUCK_WIDTH * 4 / 5, TRUCK_HEIGHT * 4 / 5);

      int ybottom = getY() + TRUCK_HEIGHT * 4 / 5;
      int tireDiameter = TRUCK_WIDTH / 10;

      Ellipse2D.Double frontTire
            = new Ellipse2D.Double(getX(), ybottom, tireDiameter, tireDiameter);
      
      Ellipse2D.Double midTire1 = new Ellipse2D.Double(getX() + TRUCK_WIDTH * 1 / 5,
            ybottom, tireDiameter, tireDiameter);
      
      Ellipse2D.Double midTire2 = new Ellipse2D.Double(getX() + TRUCK_WIDTH * 3 / 10,
            ybottom, tireDiameter, tireDiameter);
      
      Ellipse2D.Double rearTire1 = new Ellipse2D.Double(getX() + TRUCK_WIDTH * 4 / 5,
            ybottom, tireDiameter, tireDiameter);
      
      Ellipse2D.Double rearTire2 = new Ellipse2D.Double(getX() + TRUCK_WIDTH * 9 / 10,
            ybottom, tireDiameter, tireDiameter);

      g2.draw(body);
      g2.draw(cargo);
      g2.draw(frontTire);
      g2.draw(midTire1);
      g2.draw(midTire2);
      g2.draw(rearTire1);
      g2.draw(rearTire2);
   }

   public int getHeight()
   {
      return TRUCK_HEIGHT;
   }
   
   public int getWidth()
   {
      return TRUCK_WIDTH;
   }
}