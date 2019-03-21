import java.util.ArrayList;

// public class test {
// 	public static void main(String args[]) {
// 		int i = 1, j = 1;
// 		try {
// 			i++;
// 			j--;
// 			if (i == j) i++;
// 		} catch (ArithmeticException e) { System.out.println(0); } catch (ArrayIndexOutOfBoundsException e) {
// 			System.out.println(1);
// 		} catch (Exception e) { System.out.println(2); }

// 		finally {
// 			System.out.println(3);
// 		}
// 		System.out.println(4);
// 	}
// }


// --------------

// if a string sais "anything" than its true

// import java.io.*;
// public class CodeInsert {
// 	public static void main(String args[]) throws Exception {
// 		File file = new File("Cafe4Java.txt");
// 		//// INSERT CODE HERE ////
// 		w.write("Cafe4Java", 0, 9);
// 		w.flush();
// 		w.close();
// 		ystem.out.println(new BufferedReader(new FileReader(file)).readLine());

// 	}
// }

/* A. BufferedWriter w = new BufferedWriter (new FileWriter (new PrintWriter (file))); 
B. BufferedWriter w = new BufferedWriter (new PrintWriter (new FileWriter (file))); 
C. PrintWriter w = new PrintWriter (new FileWriter (new BufferedWriter (file)));
D. FileWriter w = new FileWriter (new BufferedWriter (new PrintWriter (file)));
E. PrintWriter w = new PrintWriter (new BufferedWriter (new FileWriter (file))); 
F. FileWriterw=newFileWriter(newPrintWriter(newBufferedWriter(file))); */




public class Q12 {
	public static void main(String args[]) {
		String s1 = "abc";
		String s2 = new String("abc");
		if (s1 == s2)
			System.out.println(1);
		else
			System.out.println(2);
		if (s1.equals(s2))
			System.out.println(3);
		else
			System.out.println(4);

		System.out.println(s1.hashCode());
	}
}

class Synch {
	int i;
	synchronized void go() {
		Synch s = new Synch();
		synchronized (this) {}
		synchronized (s) {}
	}
}

/* 21. The TreeSet class is used to directly implement which collection interface?
A. Set
B. SortedSet C. List
D. Tree
 */

 ArrayList<ObjectOne> list = new ArrayList<ObjectOne>(); 
 list.add(new ObjectOne());
 class ObjectOne {
 private int x = 0;
 private int y = 0;
 }
 
// all this works but if you do int x in there it wont work 


