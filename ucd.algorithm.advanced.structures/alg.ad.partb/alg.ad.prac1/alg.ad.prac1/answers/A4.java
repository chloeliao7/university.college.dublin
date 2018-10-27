public class A4 {
  public static void main(String[] args) { 
		int a = 2;
		int b = 6;
		int outMax = Difference(a, b); 
		System.out.println("the output of the difference is is: " + outMax);
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

  public static int Difference(int a, int b) {
	if (a > b){ // Compare operation 1
		return a - b; // a - b operation 2
	}else { // Return operation 3
		return b - a; 
	}
	}

  public static void testdurration(long a) {
    double duration = 0;
    for (int i = 0; i < 5; i++) {
    for (int j = 0; j < a; j++) {
      long start = System.currentTimeMillis(); 
      Difference(20, 10); 
      // Difference((int) (Math.random() * 100), (int) (Math.random() * 100));
      long end = System.currentTimeMillis();
      duration += end - start; 
    }
  }
    duration = duration/5; 
    System.out.println("testdurration = iterations : " + a + " running time : " + duration);
  }
}

/* 
PART 1: Algorithm Difference(a, b):
* fallow the comments in code for OPERATION

Algorithm Difference(a, b):
 Input: Two integers a and b
 Output: The difference between a and b
 if (a > b) then
 return a minus b
 else
 return b minus a

 i. the output of the difference is is: 4
 ii. * fallow the comments for operation >> TOTAL OPERATIONS: 3
 iii. O(1)
 */