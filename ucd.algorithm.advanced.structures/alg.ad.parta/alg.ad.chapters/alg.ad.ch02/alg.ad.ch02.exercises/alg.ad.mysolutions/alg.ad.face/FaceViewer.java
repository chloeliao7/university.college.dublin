import javax.swing.JFrame;

public class FaceViewer {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(150, 250);
		frame.setTitle("An Alien Face");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		FaceComponent component = new FaceComponent();
		frame.add(component);

		frame.setVisible(true);
	}
}

// 1
// Give instructions to draw a circle with center (100, 100) and
// radius 25.
// Answer:
// g2.draw(new Ellipse2D.Double(75, 75, 50, 50));

// g2.draw(new Ellipse2D.Double(75, 75, 50, 50))

// 2
// What happens if you call g.draw(box) instead of
// g2.draw(box)?
// Answer: The compiler complains that g doesn’t have a draw
// method. 

// 3
// How do you modify the program to draw one rectangle and one
// square?
// Answer: Replace the call to box.translate(15, 25) with
// box = new Rectangle(20, 35, 20, 20);

// 4
// Give instructions to draw a letter "V" by drawing two line
// segments.
// Answer:
// Line2D.Double segment1 = new Line2D.Double(0, 0, 10, 30);
// g2.draw(segment1);
// Line2D.Double segment2 = new Line2D.Double(10, 30, 20, 0);
// g2.draw(segment2);

// 5
// Give instructions to draw a string consisting of the letter "V”.
// Answer:
// g2.drawString("V", 0, 30);



// 6
// What are the RGB color values of Color.BLUE?
// Answer: 0, 0, and 255


// 7
// How do you draw a yellow square on a red background?
// Answer: First fill a big red square, then fill a small yellow
// square inside:
// g2.setColor(Color.RED);
// g2.fill(new Rectangle(0, 0, 200, 200));
// g2.setColor(Color.YELLOW);
// g2.fill(new Rectangle(50, 50, 100, 100));


// 8 
// How can you use the methods of the public interface to empty the
// harrysChecking bank account?
// Answer:
// harrysChecking.withdraw(harrysChecking.getBalance())


// 9 
// What is wrong with this sequence of statements?
// BankAccount harrysChecking = new BankAccount(10000);
// System.out.println(harrysChecking.withdraw(500));

// Answer: The withdraw method has return type void. It
// doesn’t return a value. Use the getBalance method to obtain the
// balance after the withdrawal.
