import java.util.Random;

/**
 * Represents a pitstop at a Horse Race - a water trough!
 *
 * @author Jonathan Engelsma (http://www.cis.gvsu.edu/~engelsma)
 *
 */
public class WaterTrough {
	private Random rand = new Random(System.currentTimeMillis());
	private int drinkers = 0;

	/**
	 * This method is synchronized so it permits only one horse to drink at
	 * a time.
	 * @return The length of time the horse drank.
	 * @throws InterruptedException
	 */

	public synchronized long getDrink() throws InterruptedException {
		// Horse takes between 1-3 seconds drinking!
		long duration = Math.abs((this.rand.nextLong()) % 2000) + 1000;
		Thread.sleep(duration);
		return duration;
	}

	/**
	 * This method is an alternate implementation that allows 2 or less horses to drink at a time.
	 * @return The length of time the horse drank.
	 * @throws InterruptedException
	 */

	public long getDrinkTwoHorseTrough() throws InterruptedException {
		synchronized (this) {
			while (this.drinkers >= 2) { this.wait(); }
			this.drinkers++;
		}

		System.out.println("horse drinking");

		// Horse takes between 1-3 seconds drinking!
		long duration = Math.abs((this.rand.nextLong()) % 2000) + 1000;
		Thread.sleep(duration);

		synchronized (this) {
			this.drinkers--;
			this.notifyAll();
		}

		System.out.println("horse done drinking");
		return duration;
	}
}
