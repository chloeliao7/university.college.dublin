import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
   The component class that displays the bar chart with negative values.
 */
public class BarChartComponent extends JComponent
{
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;
      BarChart c = new BarChart(getWidth(), getHeight());
      c.add(1.1);
      c.add(-3.6);
      c.add(4.0);
      c.add(3.7);
      c.add(-2.1);
      c.add(.7);
      c.add(2.6);
      c.draw(g2);      
   }
}
