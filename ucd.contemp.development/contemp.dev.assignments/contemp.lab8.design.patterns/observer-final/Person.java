

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
