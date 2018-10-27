import javax.swing.JFrame;

/**
   Displays a bar chart, with negative values.
*/
public class ChartViewer
{  
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 300;
      final int FRAME_HEIGHT = 400;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("ChartViewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      BarChartComponent component = new BarChartComponent();
      frame.add(component);

      frame.setVisible(true);
   }
}
