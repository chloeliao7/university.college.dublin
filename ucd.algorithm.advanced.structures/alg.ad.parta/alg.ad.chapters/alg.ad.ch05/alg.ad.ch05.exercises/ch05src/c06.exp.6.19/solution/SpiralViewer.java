import javax.swing.JFrame;

/**
   Test driver for Spiral class.
*/
public class SpiralViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 400;
      final int FRAME_HEIGHT = 400;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("SpiralViewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      SpiralComponent component = new SpiralComponent();
      frame.add(component);

      frame.setVisible(true);
   }
}
