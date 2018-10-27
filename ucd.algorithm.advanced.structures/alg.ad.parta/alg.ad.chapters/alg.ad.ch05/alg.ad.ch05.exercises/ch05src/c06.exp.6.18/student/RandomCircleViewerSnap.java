import javax.swing.JFrame;

/**
   Snap driver class for RandomCircleComponent class.
*/
public class RandomCircleViewerSnap
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 400;
      final int FRAME_HEIGHT = 400;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("RandomCircleViewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      RandomCircleComponent component = new RandomCircleComponent(10);
      frame.add(component);

      frame.setVisible(true);
   }
}
