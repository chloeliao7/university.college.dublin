import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
   This class draws a pie chart.
*/
public class PieChart
{
   private double width;
   private double height;
   private ArrayList<Double> values;   

   /**
      Constructs a PieChart object.
      @param aWidth the width
      @param aHeight the height
   */
   public PieChart(double aWidth, double aHeight)
   {
      width = aWidth;
      height = aHeight;
      values = new ArrayList<Double>();
   }
   
   /**
      Adds the data value to the list.
      @param value the data value
   */
   public void add(double data)
   {
      values.add(new Double(data));
   }
   
   /**
      Draws a pie chart.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {  
      double total = 0;
      for (Double element : values)
         total = total + element;

      double xwidth = width - 1;
      double yheight = height - 1;
      double radius = Math.min(xwidth, yheight) / 2;

      g2.draw(new Ellipse2D.Double(0, 0, 2 * radius, 2 * radius));
      
      Point2D.Double center = new Point2D.Double(radius, radius);

      double angle = 0;
      for (Double element : values)
      {
         angle = angle + 2 * Math.PI * element / total;
         Point2D.Double p
            = new Point2D.Double(radius + radius * Math.cos(angle),
               radius + radius * Math.sin(angle));
         g2.draw(new Line2D.Double(center, p));
      }
   }
}
