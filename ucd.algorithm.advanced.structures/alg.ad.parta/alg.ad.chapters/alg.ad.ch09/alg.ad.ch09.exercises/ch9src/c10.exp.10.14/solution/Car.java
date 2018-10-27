import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
   This class represents a car.
*/
public class Car extends Vehicle
{   
   private final int CAR_WIDTH = 60;
   private final int CAR_HEIGHT = CAR_WIDTH / 2 ;

   /**
      Draw the car.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
      Rectangle body = new Rectangle(getX(), getY() + CAR_HEIGHT / 3,
            CAR_WIDTH, CAR_HEIGHT / 3);

      Ellipse2D.Double frontTire = new Ellipse2D.Double(getX() + CAR_WIDTH / 6,
               getY() + CAR_HEIGHT * 2 / 3, CAR_WIDTH / 6, CAR_WIDTH / 6);
      Ellipse2D.Double rearTire = new Ellipse2D.Double(getX() + CAR_WIDTH * 4 / 6,
            getY() + CAR_HEIGHT * 2 / 3, CAR_WIDTH / 6, CAR_WIDTH / 6);

      Point2D.Double r1 = new Point2D.Double(getX() + CAR_WIDTH / 6,
            getY() + CAR_HEIGHT / 3); // the bottom of the front windshield
         
      Point2D.Double r2 = new Point2D.Double(getX() + CAR_WIDTH * 2 / 6, getY());
         // the front of the roof
      Point2D.Double r3 = new Point2D.Double(getX() + CAR_WIDTH * 4 / 6, getY());
         // the rear of the roof
      Point2D.Double r4 = new Point2D.Double(getX() + CAR_WIDTH * 5 / 6,
            getY() + CAR_HEIGHT / 3); // the bottom of the rear windshield

      Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
      Line2D.Double roofTop = new Line2D.Double(r2, r3);
      Line2D.Double rearWindshield = new Line2D.Double(r3, r4);

      g2.draw(body);
      g2.draw(frontTire);
      g2.draw(rearTire);
      g2.draw(frontWindshield);
      g2.draw(roofTop);
      g2.draw(rearWindshield);
   }

   public int getHeight()
   {
      return CAR_HEIGHT;
   }
   
   public int getWidth()
   {
      return CAR_WIDTH;
   }
}