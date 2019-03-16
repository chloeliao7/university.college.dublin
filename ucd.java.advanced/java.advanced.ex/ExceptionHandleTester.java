import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.Buffer;

public class TheadBoth extends Thread implements Runnable {
	public void run() { System.out.println("hi"); }
	public static void main(String[] args) {
		Thread t1 = new TheadBoth();
		Thread t2 = new Thre(t1);
		t1.run();
		t2.start(); // calls the run method
		ct.start(); // splits into two threads but doesnt find it in a certain cpu
		ct.run(); // will run everything in one thread in sync
		t1.run();
	}
}
