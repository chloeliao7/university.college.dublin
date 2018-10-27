import javax.swing.JFrame;

/**
   Test driver class.
*/
public class CubicCurveViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 400;
      final int FRAME_HEIGHT = 400;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("CubicCurveViewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      CubicCurveComponent component 
         = new CubicCurveComponent(0.00005, -0.03, 4, 200);
      frame.add(component);

      frame.setVisible(true);
   }
}
