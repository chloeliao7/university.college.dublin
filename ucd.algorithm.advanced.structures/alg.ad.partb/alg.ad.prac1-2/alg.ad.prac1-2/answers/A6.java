import java.util.*;
import java.util.Scanner;

public class A6 {
  public static int k = 1;
  public static int counter = 0;
  public static void main(String args[]) {

		int ans = Question6(); 
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
    System.out.println("The MinValueIndex Output IS : " + ans);
  }


	public static int Question6() {
    int m = 30; 
    int[] Arr = new int[m];
    int[] A = {5, 3, 4, 1, 2};
    int outputNow = MinValueIndex(A, m);
  return outputNow; 
  }; 



  public static int MinValueIndex(int[] A, int m) {
		int minValueIndex = 0; // OPERATIONS : 1
    for (k = 1; k <= A.length - 1; k++) { 
      // OPERATIONS: 2(n), k <= A.length 
      // OPERATIONS: 2(n -1)  k++: 
      if (A[minValueIndex] > A[k]) { // OPERATIONS : 3(n-1)
        minValueIndex = k; // OPERATIONS : 1(n-1)
      } else if (A[minValueIndex] < A[k]) { 
      }
    }
    return minValueIndex; // OPERATIONS : 1
  }

  public static void testdurration(int a) {
		double duration = 0;
		int[] A = new int[a]; // size of array 
    // int[] B = new int[a]; // size of array 
    for (int i = 0; i < a; i++) {
      A[i] = (int)(Math.random() * 100); // given values 
			// its not the value that changes the dynamic of your algorithm 
    }
    for (int j = 0; j < 5; j++) {
		long start = System.currentTimeMillis(); 
    MinValueIndex(A, A.length); 
		long end = System.currentTimeMillis();
		duration += end - start; 
  }
	  duration = duration/5; 
    System.out.println("testdurration = Itteration ARRAY SIZE = " + a + " running time = " + duration);
  }

}

/*
PART 1: Algorithm MinValueIndex(A, n):
* fallow the comments in code for OPERATION
Algorithm MinValueIndex(A, n):
 Input: An integer array A of size n
 Output: The position of the smallest value in A
 minValueIndex <-- 0
 for k=1 to n-1 do
 if (A[minValueIndex] > A[k]) then
 minValueIndex <-- k
 return minValueIndex 

 i. the output of is 3
 ii. * fallow the comments for operation >> TOTAL OPERATIONS: 8n - 2

 | K   | A[k]   | A[MinValueIndex] | A.length |
| --- | ------ | ---------------- | -------- |
|     |        |                  |          |
| --- | ---    | ------------     | ------   |
| 1   | 3true  | 5true            | 5        |
| --- | ---    | ------------     | ------   |
| 2   | 4false | 3false           | 5        |
| --- | ---    | ------------     | ------   |
| 3   | 1true  | 3true            | 5        |
| --- | ---    | ------------     | ------   |
| 4   | 2false | 1false           | 5        |
| --- | ---    | ------------     | ------   |

 iii. O(n)
 */

/* 
--------------> EXTRA: 
ASSIGN OPERATION #1 ASSIGNING: int minValueIndex = 0
ASSIGN OPERATION #2 ASSIGNING: First: Forloop: int k = 1
ASSIGN OPERATION #3 ASSIGNING: k < A.length : 1 < 5
ASSIGN OPERATION #4 ASSIGNING: minValueIndex = k: IN IF 1
EVALUATE OPERATION #5 EVALUATING A[minValueIndex] > A[k] IN IF : 3 > 3
ITERATE OPERATION #6 ITTERATING: K ++: 1
ASSIGN OPERATION #7 ASSIGNING: k < A.length : 2 < 5
EVALUATE OPERATION #8 EVALUATING A[minValueIndex] < A[k] IN ELSE : 3 < 4
ITERATE OPERATION #9 ITTERATING: K ++: 2
ASSIGN OPERATION #10 ASSIGNING: k < A.length : 3 < 5
ASSIGN OPERATION #11 ASSIGNING: minValueIndex = k: IN IF 3
EVALUATE OPERATION #12 EVALUATING A[minValueIndex] > A[k] IN IF : 1 > 1
ITERATE OPERATION #13 ITTERATING: K ++: 3
ASSIGN OPERATION #14 ASSIGNING: k < A.length : 4 < 5
EVALUATE OPERATION #15 EVALUATING A[minValueIndex] < A[k] IN ELSE : 1 < 2
ITERATE OPERATION #16 ITTERATING: K ++: 4
EVALUATE OPERATION #17 EVALUATING LAST: k < A.length : 5 < 5
RETURN OPERATION #18 RETURNING: minValueIndex : 3
 */