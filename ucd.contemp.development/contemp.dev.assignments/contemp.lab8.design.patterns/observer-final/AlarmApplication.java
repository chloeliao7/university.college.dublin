import java.util.Arrays;

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
