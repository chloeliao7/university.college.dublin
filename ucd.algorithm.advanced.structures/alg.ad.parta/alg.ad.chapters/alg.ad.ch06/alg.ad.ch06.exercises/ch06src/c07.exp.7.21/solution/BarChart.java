import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.Rectangle;

/**
   This class draws a bar chart.
*/
public class BarChart
{
   private int width;
   private int height;
   private ArrayList<Double> values;

   /**
      Constructs a BarChart object.
      @param aWidth the width
      @param aHeight the height
   */
   public BarChart(int aWidth, int aHeight)
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
      values.add(data);
   }
   
   /**
      Draws the bar chart.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {  
      int i = 0;
      double max = 0;
      double min = 0;
      
      for (double x : values)
      {
         if(max < x)
            max = x;
         if (min > x)
            min = x;
      }

      int xwidth = width - 1;
      int yheight = height - 1;

      int xleft = 0;
      int ybase = (int) Math.round(yheight * max / (max - min));
         
      for (i = 0; i < values.size(); i++)
      {  
         int xright = xwidth * (i + 1) / values.size();
         int barWidth = xwidth / values.size();
         int y = (int) Math.round(yheight * values.get(i) / (max - min)); // scale the bar
          
         if (values.get(i) > 0)
         {
            Rectangle bar = 
               new Rectangle(xleft, ybase - y, barWidth, Math.abs(y));
            g2.draw(bar);
         }
         else
         {
            Rectangle bar = 
               new Rectangle(xleft, ybase, barWidth, Math.abs(y));
            g2.draw(bar);
         }
         xleft = xright;
      }
   }   
}
