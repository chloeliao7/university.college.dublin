import java.util.Random;
/**
 * Representation of a horse race.  This class is used to synchronize the
 * start of the race and the race ending.
 *
 * @author Jonathan Engelsma (http://www.cis.gvsu.edu/~engelsma)
 *
 */
public class Race {
	private int place = 0;
	/**
	 * Called by each horse to line up at the starting line.
	 * @throws InterruptedException
	 */
	public synchronized void getReadyToRace() throws InterruptedException { this.wait(); }
	/**
	 * Called to start the race.
	 */
	public synchronized void startRace() { this.notifyAll(); }
	/**
	 * Called by each horse to cross the finish line.
	 */
	public synchronized int crossFinishLine() { return ++place; }
}
