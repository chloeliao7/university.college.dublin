import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Graphics;
// java.lang.Object
// java.awt.Component
// java.awt.Container
// java.awt.Window
// java.awt.Frame
// javax.swing.JFrame
// import com.sun.prism.Graphics


public class EmptyFrameViewer extends JFrame {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(300, 400);
		frame.setTitle("An Empty frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public class RectangleCompnent extends JComponent {
		public void paintComponent(Graphics g) { // recover Graphics2D
			Graphics2D g2 = (Graphics2D) g; // casting 
		}
	}
}

