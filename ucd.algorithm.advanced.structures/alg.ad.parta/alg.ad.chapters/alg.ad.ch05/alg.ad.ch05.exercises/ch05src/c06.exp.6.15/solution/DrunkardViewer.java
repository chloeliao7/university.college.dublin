import javax.swing.JFrame;

/**
   This class tests the Drunkard and Grid classes.
*/
public class DrunkardViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 270;
      final int FRAME_HEIGHT = 300;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("DrunkardViewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      DrunkardComponent component = new DrunkardComponent();
      frame.add(component);

      frame.setVisible(true);
   }
}
