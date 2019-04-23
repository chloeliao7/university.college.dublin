// import java.util.ArrayList;
// import java.util.Observer;
import java.util.Arrays;
import java.util.List;

// BIRDS EYE VIEW -> OBSERVER PATTERN

public class ObserverEx {
	
/***************
 InnerObserver 
***************/

public interface InnerObserver { public void update(InnerObservable io); }
public abstract class InnerObservable {}

public class Cron implements InnerObserver { // OBSERVER -> same as person
	@Override
	public void update(InnerObservable clock) { // something that can be observed -> alarm clock
		AlarmClock alarm = (AlarmClock)clock;
		System.out.println("run Cron"); // this.wakeUp(); -> wokenUpAt = alarm.getTime();
	}
}

 /********
 PERSON 
 ********/

public class Person implements InnerObserver { // OBSERVER
	private String name;
	public Person(String a_name) { name = a_name; }
	public void goToBed() { System.out.println(name + " is going to bed..."); }
	public void wakeUp() { System.out.println(name + " has woken up!"); }
	private String wokenUpAt;
	
	@Override
	public void update(InnerObservable clock) { // something that can be observed -> alarm clock
		AlarmClock alarm = (AlarmClock)clock;
		this.wakeUp();
		wokenUpAt = alarm.getTime();
	}
}

/******************
 ALARM APPLICATION 
 ******************/

public class AlarmApplication {
	public void main(String[] args) {
		Person jack = new Person("Jack");
		Cron cr = new Cron(); // obs for the alarm
		
		AlarmClock alarmClock = new AlarmClock(Arrays.asList(jack, cr)); // both cron and jack update
		alarmClock.setAlarmTime(7, 30, 0); // h, m, s
		alarmClock.setAlarmTime(7, 30, 0); // h, m, s
		jack.goToBed(); // this is when he goes to bed 
		for (int i = 1; i <= SECONDS_IN_DAY; i++) {
			alarmClock.tick(); // reach
		}
	}
	public static final int SECONDS_IN_DAY = 86400;
}

/************
 ALARM CLOCK 
 ************/

public class AlarmClock extends InnerObservable {
	List<InnerObserver> alarmObservers; // private List<Observer> alarmObs = new ArrayList<Observer>(); -> private int state;
	public AlarmClock(List<InnerObserver> observers) { hours = 0; minutes = 0; seconds = 0; alarmHours = 0; alarmMinutes = 0; alarmSeconds = 0; this.alarmObservers = observers; } // clocks regulations
	public void setTime(int hrs, int mins, int secs) { hours = hrs; minutes = mins; seconds = secs; }
	public void setAlarmTime(int hrs, int mins, int secs) { alarmHours = hrs; alarmMinutes = mins; alarmSeconds = secs; }
	
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
	
	
	
	// prints  the string
	public String getTime() { return Integer.toString(hours) + ":" + Integer.toString(minutes) + ":" + Integer.toString(seconds); }
	private int hours, minutes, seconds; // time
	private int alarmHours, alarmMinutes, alarmSeconds; // alarm
	public boolean alarmReached() { return (hours == alarmHours && minutes == alarmMinutes && seconds == alarmSeconds); }
}

}
