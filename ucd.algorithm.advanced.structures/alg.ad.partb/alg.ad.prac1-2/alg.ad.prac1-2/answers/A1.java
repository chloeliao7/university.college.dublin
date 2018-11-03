import java.lang.Math.*;
// package answ /ers;

public class A1 {

  public static void main(String[] args) {
    int ans = Increment(1, 1); 
    testdurration(1000);
    testdurration(10000);
    testdurration(100000);
    testdurration(1000000);
    System.out.println(ans);
  }

  public static int Increment(int a, int b) {
    int ans = a + b;
    return ans;
  }

  public static void testdurration(long a) {
    double duration = 0;
    long start = System.currentTimeMillis(); 
    for (int i = 0; i < a; i++) {
      Increment((int) (Math.random() * 100), (int) (Math.random() * 100));
    }
    long end = System.currentTimeMillis();
    duration += end - start; 
    System.out.println("testdurration = iterations = " + a + " running time = " + duration);
  }
}

/* 
EXAMPLES: 
(Only for question A1 => note: i have included a variable here only so that you see a sample variable table):
A1) Algorithm Increment(a):
 Input: An integer a
 Output: a + 1
 output <= a + 1
 return output
ANSWER: 

(i) THE TEST DATA FOR THIS ALGORITHM IS A 5 AND THE DRY RUN PRODUCES THE FOLLOWING OUTPUT
OUTPUT 6

(ii) OPERATION COUNT FOR ALGORITHM
Algorithm Increment(a): 
Input: An integer a, 
Output: a + 1
output explained: 
a + 1 2 operations
return output: 
Total = 3 operations (1,2,3 operation)

(iii) big-Oh for this algorithms is O(1) 
*/