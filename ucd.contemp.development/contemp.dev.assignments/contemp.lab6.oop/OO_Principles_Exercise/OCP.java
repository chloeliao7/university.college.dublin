public class OCP {
	public static void main(String[] args) {
		Shape square = new Square(10.1);
		PostageStamp stamp = new PostageStamp(square);
		System.out.println(stamp.toString());
	}
}

// Look at the classes PostageStamp and Square - open closed
// stamps may have different shapes
// if correct it will be possible to create stamps of different shapes without changing the PostageStamp
// >> modification but open for extension.

class PostageStamp {
	public PostageStamp(Shape s) { this.shape = s; }
	public String toString() { return "stamp, contained in a " + shape.toString(); }
	Shape shape;
}

// Look at the classes PostageStamp and Square - open closed
class Square implements Shape {
	public Square(double d) { setLength(d); }
	public void setLength(double d) { this.length = d; }
	public double getLength() { return length; }
	public String toString() { return "square, side of length " + length; }
	private double length;
}

interface Shape {
	public String toString();
	public double getLength();
	public void setLength(double length);
}

