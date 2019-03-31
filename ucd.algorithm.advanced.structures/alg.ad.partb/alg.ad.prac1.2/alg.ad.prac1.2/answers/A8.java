import java.util.*;
import java.util.Scanner;

public class A8 {

  public static void main(String args[]) {
    int a = 5;
    int d = Factorial(a);
    System.out.println("FACTORIAL OUTPUT IS: " + d);
  }

  public static int Factorial(int a) {
    int k;
    int factorial = 1; // OPERATIONS: 1
    for (k = 1; k <= a; k++) {
      // OPERATIONS: 2(n), k <= a -1 // OPERATIONS: 2(n -1) k++
      factorial = factorial * k; // OPERATIONS: 2(n) 
      System.out.println("K : " + k + "    A : " + a + "    Factorial : " + factorial);

    }

    return factorial; // OPERATIONS: 1
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

 i. the output 120
 ii. * fallow the comments for operation >> TOTAL OPERATIONS: 6n 

K : 1    A : 5    Factorial : 1
K : 2    A : 5    Factorial : 2
K : 3    A : 5    Factorial : 6
K : 4    A : 5    Factorial : 24
K : 5    A : 5    Factorial : 120

 iii. O(n)
 */

/* 
ASSIGN OPERATION #1 ASSIGNING: 1 to factorial 
EVALUATE OPERATION #2 EVALUATING First Evaluation: Forloop: inwt k = 1 
ASSIGN OPERATION #3 ASSIGNING: factorial = factorial * k : 1 
ITERATE OPERATION #4 ITTERATING: K++ : 1 
ASSIGN OPERATION #5 ASSIGNING: factorial = factorial * k : 2 
ITERATE OPERATION #6 ITTERATING: K++ : 2 
ASSIGN OPERATION #7 ASSIGNING: factorial = factorial * k : 6 
ITERATE OPERATION #8 ITTERATING: K++ : 3 
ASSIGN OPERATION #9 ASSIGNING: factorial = factorial * k : 24 
ITERATE OPERATION #10 ITTERATING: K++ : 4 
EVALUATE OPERATION #11 EVALUATING LAST: k < a : 5 < 5 
RETURN OPERATION #12 RETURNING: return factorial : 24  
*/