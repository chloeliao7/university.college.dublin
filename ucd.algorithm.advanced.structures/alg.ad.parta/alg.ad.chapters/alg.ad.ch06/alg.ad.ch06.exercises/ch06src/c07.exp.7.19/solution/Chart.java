import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
   This class draws a stick chart.
*/
public class Chart
{
   private double width;
   private double height;
   private ArrayList<Integer> values;

   /**
      Constructs a Chart object.
      @param aWidth the width
      @param aHeight the height
   */
   public Chart(double aWidth, double aHeight)
   {
      width = aWidth;
      height = aHeight;
      values = new ArrayList<Integer>();
   }
   
   /**
      Adds the data value to the list.
      @param value the data value
   */
   public void add(int data)
   {
      values.add(new Integer(data));
   }
   
   /**
      Draws the stick chart.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {  
      int i = 0;
      double max = 0;
      
      double xwidth = width - 1;
      double yheight = height - 1;

      double xleft = 10; // x position to draw next stick
      for (i = 0; i < values.size(); i++)
      {  
         int x = values.get(i);        
         double xright = xwidth * (i + 1) / values.size();

         g2.draw(new Line2D.Double(
            new Point2D.Double(xleft, yheight),
            new Point2D.Double(xleft, x)));
         
         xleft = xright;
      }
   }   
}
