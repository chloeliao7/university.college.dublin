import javax.swing.JFrame;

/**
   This program displays a checkerboard.
*/
public class CheckerBoardViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 330;
      final int FRAME_HEIGHT = 360;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("CheckerBoardViewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      CheckerBoardComponent component = new CheckerBoardComponent();
      frame.add(component);

      frame.setVisible(true);
   }
}
