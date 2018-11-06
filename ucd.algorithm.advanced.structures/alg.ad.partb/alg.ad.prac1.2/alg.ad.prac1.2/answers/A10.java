import java.util.*;
import java.util.Scanner;

public class A10 {

	public static void main(String args[]) {
		int ans = Question10(); 
		System.out.println("the output for the LinearSearch is " + ans);
     testdurration(10000000);
     testdurration(20000000);
     testdurration(30000000);
     testdurration(40000000);
     testdurration(50000000);
     testdurration(60000000);
     testdurration(70000000);
     testdurration(80000000);
     testdurration(90000000);
 		 testdurration(100000000);
	}

	public static int Question10() {
		int n = 5; // what value we want to have in our array
		int q = 45; // what value we want to search for
		int[] A = { 55, 32, 12, 45, 55 };
		int outLinear = LinearSearch(A, n, q);
		return outLinear; 
}
	
	public static int LinearSearch(int A[], int n, int q) {
		int index = 0; // OPERATIONS 1 
		while ((index < n) && (A[index] != q)) { // OPERATIONS: 4 (n)
			index = index + 1; // 2(n-1)
		} if (index == n) { // OPERATIONS 1
			return -1; // OPERATIONS 1 {hits when not found}
		} else { 
			return index; // OPERATIONS 1 {hits when found}
		}
	}

public static void testdurration(int a) {
	double duration = 0;
	int[] A = new int[a]; 
	for (int i = 0; i < a; i++) {
		 A[i] = (int)(Math.random() * 100); 
	}
	for (int j = 0; j < 5; j++) {
		long start = System.nanoTime(); 
		LinearSearch(A, A.length, A[A.length - 1]); 
		long end = System.nanoTime();
		duration += end - start; 
	}
	duration = duration/5; 
	// duration = duration / 5; 
	System.out.println("testdurration = Itteration ARRAY SIZE = " + a + " running time = " + duration);

}
}

/* 
 i. the output 3 since it is at the third slot of the array

 ii. * fallow the comments for operation >> TOTAL OPERATIONS: 6n + 1

| A[index]: 32 | Index : 1 | q: 45 | n: 5 |
| A[index]: 12 | Index : 2 | q: 45 | n: 5 |
| A[index]: 45 | Index : 3 | q: 45 | n: 5 |

 iii. O(n)
 */