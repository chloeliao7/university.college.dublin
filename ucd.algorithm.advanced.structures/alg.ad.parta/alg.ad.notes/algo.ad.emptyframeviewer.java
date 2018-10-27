import javax.swing.JFrame;

public class EmptyFrameViewer {
	public static void main(String[] args) {
		JFrame frame = new JFrame(); // class to 
		frame.setSize(300, 400);
		frame.setTitle("An Empty Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true); // false because you can activate
		// could be false if you have multiple frames and windows 
	}
}

public class RectangleComponent extends JComponent {
	public void paintComponent(Graphics g) {
		// Drawing instructions go here
	}
}



public class RectangleComponent extends JComponent {
	public void paintComponent(Graphics g) {
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;
	}
}

public class RectangleComponent extends JComponent {
	public void paintComponent(Graphics g) {
		Rectangle box = new Rectangle(5, 10, 20, 30);
		g2.draw(box); // function that calls on you context graphics 
		draw shapes;
		// such as rectangles, ellipses, line segments, polygons
	}
}

// • Graphics class lets you manipulate the graphics state (such as current
// color) • Graphics2D class has methods to draw shape objects • Use a cast to
// recover the Graphics2D object from the

// -------------------------------

// import java.awt.Graphics;
// import java.awt.Graphics2D;
// import java.awt.Rectangle;
// import javax.swing.JComponent;

// A component that draws two rectangles.
public class RectangleComponent extends JComponent {
	public void paintComponent(Graphics g) {
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;

		// Construct a rectangle and draw it
		Rectangle box = new Rectangle(5, 10, 20, 30);
		g2.draw(box);

		// Move rectangle 15 units to the right and 25 units down
		box.translate(15, 25);

		// Draw moved rectangle
		g2.draw(box);

	}
}

// applet 
public class MyApplet extends JApplet {
	public void paint(Graphics g) {
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		// Drawing instructions go here
		
	}
}
// difference between applet and graphics
// 1. You extend JApplet, not JComponent
// 2. You place the drawing code inside the paint method, not inside paintComponent