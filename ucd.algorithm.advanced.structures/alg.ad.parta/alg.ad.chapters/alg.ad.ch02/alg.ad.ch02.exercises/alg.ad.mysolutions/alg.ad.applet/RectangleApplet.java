import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JApplet;
import java.awt.geom.Ellipse2D;
/**
 * RectangleApplet
 */
public class RectangleApplet extends JApplet {
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		// construct Rectangle 
		Rectangle box = new Rectangle(5, 10, 20, 30);
		g2.draw(box); // sets the box into the g2 draw of paint
		box.translate(15, 25);
		g2.draw(box); // draw moved rec 
		// to draw a line 
		Line2D.Double segment = new Line2D.Double(x1, y1, x2, y2);
		g2.draw(segment);
		g2.drawString("Message", 50, 100);
		g2.setColor(magenta);
		g2.fill(rectangle); 
		// Ellipse2D.Double ellipse = new Ellipse2D.Double(x, y, width, height);// g2.draw(ellipse); // or 
		/* Point2D.Double from = new Point2D.Double(x1, y1);
		Point2D.Double to = new Point2D.Double(x2, y2);
		Line2D.Double segment = new Line2D.Double(from, to);
		g2.draw(segment); */
	}
}
