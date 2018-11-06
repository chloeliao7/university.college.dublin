import java.util.*;
import java.util.Scanner;

public class A9 {

	public static void main(String args[]) {
		int a = 2;
		int b = 4;
		int d = Power(a, b);
		System.out.println("the output is " + d);
	}

	public static int Power(int a, int b) {
		int power = 1;
		double duration = 0;
		int k;
		for (k = 1; k <= b; k++) {
        /***
         OPERATIONS: 2(n), k <= a -1 
         OPERATIONS: 2(n -1) k++ 
         ****/
			power = power * a; // OPERATIONS: 2(n)
			System.out.println("K : " + k + "    b : " + b + "    power : " + power);
		}
		return power; // OPERATIONS: 1
	}
}

/*
PART 1: Algorithm Factorial(a):
* fallow the comments in code for OPERATION
Algorithm Factorial(a):
 Input: An integer a
 Output: The value of a factorial (a!)
 factorial <-- 1
 for k=1 to a do
 factorial <-- factorial * k
 return factorial

 i. the output 16

 ii. * fallow the comments for operation >> TOTAL OPERATIONS: 6n

K : 1    b : 4    power : 2
K : 2    b : 4    power : 4
K : 3    b : 4    power : 8
K : 4    b : 4    power : 16

 iii. O(n)
 */

/*
-------> Extra :
ASSIGN OPERATION #1 ASSIGNING: 1 to variable power
EVALUATE OPERATION #2 EVALUATING FIRST Evaluation: Forloop: int k = 1
ASSIGN OPERATION #3 ASSIGNING: power = power * a power = 2
ITERATE OPERATION #4 ITTERATING: ITERATING: k++ : 1
ASSIGN OPERATION #5 ASSIGNING: power = power * a power = 4
ITERATE OPERATION #6 ITTERATING: ITERATING: k++ : 2
EVALUATE OPERATION #7 EVALUATING LAST: k < b : 3 < 3
RETURN OPERATION #8 RETURNING: return power RETURN power = 4
the output is 4
*/