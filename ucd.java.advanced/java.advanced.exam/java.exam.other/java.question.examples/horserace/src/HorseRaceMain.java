
/**
 *
 * This class contains the main routine that initiates the multi-threaded
 * horse race simulation.
 *
 * @author Jonathan Engelsma (http://www.cis.gvsu.edu/~engelsma)
 *
 */
public class HorseRaceMain {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException {
		// Create a race instance and a water trough for the thirsty race horses.
		Race race = new Race();
		WaterTrough trough = new WaterTrough();

		// spin off four eager horses!
		new Thread(new Horse("Mine That Bird", race, trough)).start();
		new Thread(new Horse("Big Brown", race, trough)).start();
		new Thread(new Horse("Street Sense", race, trough)).start();
		new Thread(new Horse("Barbaro", race, trough)).start();

		// Ok, now we need to wait a bit to make sure each thread gets off to the finish line...
		System.out.print("Get ready...");
		Thread.sleep(2000);
		System.out.print("get set...");
		Thread.sleep(2000);
		System.out.println("GO!!");
		race.startRace();
		
		
	}
}
