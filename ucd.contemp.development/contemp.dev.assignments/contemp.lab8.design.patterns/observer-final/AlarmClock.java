import java.util.List;

/************
 ALARM CLOCK 
 ************/

public class AlarmClock extends InnerObservable {
	List<InnerObserver> alarmObservers; // private List<Observer> alarmObs = new ArrayList<Observer>(); -> private int state;
	public AlarmClock(List<InnerObserver> observers) {
		hours = 0;
		minutes = 0;
		seconds = 0;
		alarmHours = 0;
		alarmMinutes = 0;
		alarmSeconds = 0;
		this.alarmObservers = observers;
	} // clocks regulations
	public void setTime(int hrs, int mins, int secs) {
		hours = hrs;
		minutes = mins;
		seconds = secs;
	}
	public void setAlarmTime(int hrs, int mins, int secs) {
		alarmHours = hrs;
		alarmMinutes = mins;
		alarmSeconds = secs;
	}

	// gets the ticks of each s.m.h -> brings it back to (0)
	public void tick() {
		if ((seconds += 1) == 60) {
			seconds = 0;
			if ((minutes += 1) == 60) {
				minutes = 0;
				if ((hours += 1) == 24) { hours = 0; }
			}
		}

		if (this.alarmReached()) {
			System.out.println("The time is: " + this.getTime());
			for (InnerObserver o : alarmObservers) {
				o.update(this); // can put in the time -> updating all object
			}
		}
	}

	// prints the string
	public String getTime() { return Integer.toString(hours) + ":" + Integer.toString(minutes) + ":" + Integer.toString(seconds); }
	private int hours, minutes, seconds; // time
	private int alarmHours, alarmMinutes, alarmSeconds; // alarm
	public boolean alarmReached() { return (hours == alarmHours && minutes == alarmMinutes && seconds == alarmSeconds); }
}
