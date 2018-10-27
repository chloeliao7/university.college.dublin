import javax.swing.JFrame;

public class CarViewer {
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setSize(300, 400);
		frame.setTitle("Two cars");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CarComponent component = new CarComponent();
		frame.add(component);

		frame.setVisible	(true);
	}
}

// Which class needs to be modified to have the two cars
// positioned next to each other?
//  Answer: CarComponent


//  2 
// Which class needs to be modified to have the car tires painted in
// black, and what modification do you need to make?
// Answer: In the draw method of the Car class, call
// g2.fill(frontTire);
// g2.fill(rearTire);

// 3 
// How do you make the cars twice as big?
//  Answer: Double all measurements in the draw method of the
//  Car class.

//4
// Rectangle leftRectangle = new Rectangle(100, 100, 30, 60);
// Rectangle rightRectangle = new Rectangle(160, 100, 30, 60);
// Line2D.Double topLine = new Line2D.Double(130, 100, 160, 100);
// Line2D.Double bottomLine = new Line2D.Double(130, 160, 160, 160);