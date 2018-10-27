import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class CubicCurveComponent extends JComponent
{
   private double a;
   private double b;
   private double c;
   private double d;

   /**
      Constructs a component that paints a cubic curve
      @param aCoeff the coefficient of x*x*x
      @param bCoeff the coefficient of x*x
      @param cCoeff the coefficient of x
      @param dCoeff the constant coefficient
   */
   public CubicCurveComponent(double aCoeff, double bCoeff, double cCoeff, double dCoeff) 
   {
      a = aCoeff;
      b = bCoeff;
      c = cCoeff;
      d = dCoeff;
   }
   
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      final double SEGMENTS = 100;

      double xmin = 0;
      double xmax = getWidth();
      double delta = (xmax - xmin) / SEGMENTS;

      Point2D.Double last = null;
      double x = xmin;
      
      for (int i = 1; i <= SEGMENTS; i++)
      {
         double y = a * x * x * x + b * x * x + c * x + d;;
         Point2D.Double next = new Point2D.Double(x, getHeight() - y);
         if (i > 1)
            g2.draw(new Line2D.Double(last, next));
         last = next;
         x = x + delta;
      }
   }
}
