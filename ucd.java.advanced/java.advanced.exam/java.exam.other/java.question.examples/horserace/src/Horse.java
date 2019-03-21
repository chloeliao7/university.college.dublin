import java.util.Random;

/**
 * A simulated horse race. Each horse is modeled as a separate thread.
 *
 * @author Jonathan Engelsma (http://www.cis.gvsu.edu/~engelsma)
 *
 */
public class Horse implements Runnable {
	private String name;
	private Race race;
	private WaterTrough trough;
	private Random rand = new Random(System.currentTimeMillis());

	public Horse(String name, Race race, WaterTrough trough) {
		this.name = name;
		this.race = race;
		this.trough = trough;
	}

	/** * Called by eac	h horse to run a lap. Note that laps are run concurrently. * @return the time it took to run a lap. * @throws InterruptedException */

	public long runLap() throws InterruptedException {
		// Horse takes between 4-6 seconds to get a drink!
		long duration = Math.abs((this.rand.nextLong())) % 4000 + 2000;
		Thread.sleep(duration);
		return duration;
	}

	/** * This is the entry method for each 'Horse' thread we create. */

	public void run() {
		try {
			// lineup for the race
			this.race.getReadyToRace();
			System.out.println(this.name + " is off and running!");

			// run three laps.
			for (int i = 1; i <= 3; i++) {
				// First run a lap.
				long time = this.runLap();
				System.out.println(name + " completes lap " + i + " in " + (double)time / (double)1000.00 + " seconds!");

				// Time for a pitstop....
				time = this.trough.getDrink();
				System.out.println(name + " drinks for " + (double)time / (double)1000.00 + " seconds!");
			}

			// ok race is finished.
			int place = this.race.crossFinishLine();
			System.out.println(">>> " + name + " finishes in position " + place + "! <<<<");

		} catch (InterruptedException ie) { System.out.println(name + " apparently broke a leg and won't be finishing the race."); }
	}
}
