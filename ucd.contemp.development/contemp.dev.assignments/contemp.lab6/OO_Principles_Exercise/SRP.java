public class SRP {
	public static void main(String[] args) {
		Hexapod h = new Hexapod("barney");
		Dog d = new Dog("stew");
		d.bark("aaah dog");
		h.walk("WALKING LEG THING");
	}
}

// a human has his own responsibilities 
class Hexapod {
	public Hexapod(String name) { this.name = name; }
	public void throwStick(String stick) { this.stick = stick; }
	public void walk(String walk) { System.out.println(name + " is walking"); }
	String stick; 
	String walk;
	String name;
}


// a dog has his own responsibilities 
class Dog {
	public Dog(String name) { this.name = name; }
	public void bark(String bark) { System.out.println(bark + " says Woof!"); }
	public void fetchStick(String fetch) { System.out.println(fetch + " is fetching a stick"); }
	String name;
	String fetch;
	String bark;
}
