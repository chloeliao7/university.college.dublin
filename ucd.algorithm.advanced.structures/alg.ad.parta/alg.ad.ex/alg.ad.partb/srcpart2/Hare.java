/**
 * Hare class
 *   inherits from abstract Racer class
 *   Anderson, Franceschi
 */
import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Hare extends Racer {
  
  /** * Default Constructor: calls Racer default constructor */
	public Hare() { super(); }
  
  /** * Constructor * @param ID racer Id, passed to Racer constructor * @param x x position, passed to Racer constructor * @param y y position, passed to Racer constructor */
	public Hare(String ID, int x, int y) { super(ID, x, y); }
  
  /** * move: calculates the new x position for the racer * generates random number between 1 & 10 * for 1 - 6, no change to x position; Hare sleeps * when x is < 100, for 7-10 move 4 * when x >= 100, for 9-10, move 4 */
	public void move() {
		Random rand = new Random();
		int move = rand.nextInt(10) + 1;
		if (getX() < 100) {
			if (move > 6) setX(getX() + 4);
		} else {
			if (move > 8) setX(getX() + 4);
		}
	}
  
  /** * draw: draws the Hare at current (x, y) coordinate * @param gc GraphicsContext */
	public void draw(GraphicsContext gc) {
		int startY = getY();
		int startX = getX();
		// tail
		gc.setFill(Color.LIGHTGRAY);
		gc.fillOval(startX - 55.5, startY + 12, 18, 18);
		// body
		gc.setFill(Color.GRAY);
		gc.fillOval(startX - 45, startY, 30, 30);
		// head
		gc.fillOval(startX - 19.5, startY + 3, 19.5, 12);
		gc.fillOval(startX - 19.5, startY - 12, 12, 42);
		// flatten bottom
		gc.setFill(Color.WHITE);
		gc.fillRect(startX - 55.5, startY + 22.5, 48, 7.5);
	}
}