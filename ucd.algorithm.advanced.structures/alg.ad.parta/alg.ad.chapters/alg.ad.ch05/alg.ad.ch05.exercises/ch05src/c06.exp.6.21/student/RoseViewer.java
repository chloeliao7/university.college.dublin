import javax.swing.JFrame;

/**
   Test class driver for Rose class.
*/
public class RoseViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 300;
      final int FRAME_HEIGHT = 320;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("RoseViewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      RoseComponent component = new RoseComponent();
      frame.add(component);

      frame.setVisible(true);
   }
}
