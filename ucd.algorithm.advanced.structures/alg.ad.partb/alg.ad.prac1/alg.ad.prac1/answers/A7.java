import java.util.*;
import java.util.Scanner;

public class A7 {

  public static void main(String args[]) {
    int minValueIndex = 0;
    
    int[] A = { 5, 10, 20, 30, 40, 50 };
    int runningSum = 0;
    int n = 6;
    int B[] = new int[n];
    B = PrefixAverages2(runningSum, A, n);
    
    for(int i=0; i<n; i++){
      System.out.print(B[i] + " ");
   }
  }

  public static int[] PrefixAverages2(int runningSum, int A[], int n) {
    int j = 0; 
    
    for (j = 0; j <= n -1; j++) { 
      // OPERATIONS: 2(n), j <= n -1 
      // OPERATIONS: 2(n -1)  j++
      
      runningSum = runningSum + A[j]; // OPERATION : 3(n - 1) // ASSIGN J to A[] + adding both + assign it to runningSum
      A[j] = runningSum / (j + 1); // OPERATION : 4(n - 1) // (j + 1) + runningSum / (j + 1) + A[j] = runningSum / (j + 1) + A[j] <-- j
 
    }

    return A; // OPERATION : 1 
  }
}

/* 
PART 1: Algorithm PrefixAverages2(A, n):
* fallow the comments in code for OPERATION

Algorithm PrefixAverages2(A, n):
 Input: An integer array A of size n.
 Output: An array X of size n such that X[j] is the average of A[0], A[j].
 Let X be an integer array of size n
 runningSum <-- 0
 for j=0 to n-1 do
 runningSum <-- runningSum + A[k]
 X[j] <-- runningSum / (j+1)
 return X

 i. the output -> 5 7 11 16 21 25
 ii. * fallow the comments for operation >> TOTAL OPERATIONS: 11n - 2

| j   | n   | A[j]      | runningSum | A {array}  | 
| --- | --- | --------- | ---------- | ---------- |
| 0   | 6   | 5         | 0          | 5          | 
| --- | --- | --------- | ------     | ------     |
| 1   | 6   | 10        | 5          | 7          |
| --- | --- | --------- | ------     | ------     |
| 2   | 6   | 20        | 15         | 11         |
| --- | --- | --------- | ------     | ------     |
| 3   | 6   | 30        | 35         | 16         |
| --- | --- | --------- | ------     | ------     |
| 4   | 6   | 40        | 65         | 21         |
| --- | --- | --------- | ------     | ------     |
| 5   | 6   | 50        | 105        | 25         |
| --- | --- | --------- | ------     | ------     |

 iii. O(n)
 */

/* 
---------->> `EXTRA: 
ASSIGN OPERATION #1 ASSIGNING: int minValueIndex = 0 
ASSIGN OPERATION #2 ASSIGNING: runningSum = 0 
ASSIGN OPERATION #3 ASSIGNING: int n = 6 
ASSIGN OPERATION #4 ASSIGNING: new int[n] to B 
ASSIGN OPERATION #5 ASSIGNING: First: Forloop: int j = 0 
ITERATE OPERATION #6 ITTERATING: runningSum = runningSum + A[j] : 5 
ITERATE OPERATION #7 ITTERATING: A[j] = runningSum/(j+1) : 5 
ITERATE OPERATION #8 ITTERATING: runningSum = runningSum + A[j] : 15 
ITERATE OPERATION #9 ITTERATING: A[j] = runningSum/(j+1) : 7 
ITERATE OPERATION #10 ITTERATING: runningSum = runningSum + A[j] : 35 
ITERATE OPERATION #11 ITTERATING: A[j] = runningSum/(j+1) : 11 
ITERATE OPERATION #12 ITTERATING: runningSum = runningSum + A[j] : 65 
ITERATE OPERATION #13 ITTERATING: A[j] = runningSum/(j+1) : 16 
ITERATE OPERATION #14 ITTERATING: runningSum = runningSum + A[j] : 105 
ITERATE OPERATION #15 ITTERATING: A[j] = runningSum/(j+1) : 21 
ITERATE OPERATION #16 ITTERATING: runningSum = runningSum + A[j] : 155 
ITERATE OPERATION #17 ITTERATING: A[j] = runningSum/(j+1) : 25 
EVALUATE OPERATION #18 EVALUATING LAST: j < n : 6 < 6 
RETURN OPERATION #19 RETURNING: return A : 155 
*/