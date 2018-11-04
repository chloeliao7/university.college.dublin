import java.util.*;
import java.util.Scanner;

public class A5 {
	// devide and Concert

	public static void main(String args[]) {
		Question1();
		testdurration(100 * 100);
		testdurration(10000 * 10000);
		testdurration(100000 * 100000);
		testdurration(1000000 * 1000000);
	}

	public static int MinValue(int A[], int n) {
		int minValue = A[0]; // OPERATIONS : 2
		for (int k = 1; k <= n - 1; k++) { // OPERATIONS 2n: K <= n -1
			if (minValue > A[k]) { // OPERATIONS 2(n-1):
				minValue = A[k]; // OPERATIONS 2(n-1)
			} else if (minValue < A[k]) {
			}
			// { increment counter i } // OPERATIONS 2(n-1)
		}
		return minValue;
		// OPERATIONS 1
	}

	/* 	public static int Question1() {
			int n = 5;
			int[] A = { 34, 77, 20, 30, 40, 50 };
			int minoutput = MinValue(A, n);
			System.out.println("The MinValue OUTPUT IS: " + minoutput);
			return minoutput;
		}; 
	

	public static void testdurration(int a) {
		double duration = 0;
		int[] A = new int[a]; // size of array
		for (int i = 0; i < a; i++) {
			A[i] = (int) (Math.random() * 100); // given values
			// its not the value that changes the dynamic of your algorithm
		}
		long start = System.currentTimeMillis();
		MinValue(A, a);
		long end = System.currentTimeMillis();
		duration += end - start;
		System.out.println("testdurration = Itteration ARRAY SIZE = " + a + " running time = " + duration);
	}
}

/*
PART 1: Algorithm MinValue(a, b):
* fallow the comments in code for OPERATION
ALGO MinValue(A, n):
 Input: An integer array A of size n
 Output: The smallest value in A
 minValue <- A[0]
 for k=1 to n-1 do
 if (minValue > A[k]) then
//  minValue <- A[k]
 return minValue

 | K   | A[k] | MinVal |     |
| --- | ---- | ------ | --- |
|     |      | 34     |     |
| --- | ---  | ------ | --- |
| 1   | 77   | 34     |     |
| --- | ---  | ------ | --- |
| 2   | 20   | 34     |     |
| --- | ---  | ------ | --- |
| 3   | 30   | 20     |     |
| --- | ---  | ------ | --- |
| 4   | 40   | 20     |     |
| --- | ---  | ------ | --- |
| 5   | 50   | 20     |     |
| --- | ---  | ------ | --- |

 i. The MinValue OUTPUT IS: 20
 ii. * fallow the comments for operation >> TOTAL OPERATIONS: 8n - 2
 iii. O(n)
 */