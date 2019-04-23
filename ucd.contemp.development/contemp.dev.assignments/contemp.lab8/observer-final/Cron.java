
public class Cron implements InnerObserver { // OBSERVER -> same as person
	@Override
	public void update(InnerObservable clock) { // something that can be observed -> alarm clock
		AlarmClock alarm = (AlarmClock)clock;
		System.out.println("run Cron"); // this.wakeUp(); -> wokenUpAt = alarm.getTime();
	}
}


