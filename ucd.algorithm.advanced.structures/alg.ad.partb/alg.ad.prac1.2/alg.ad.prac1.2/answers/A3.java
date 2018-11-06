public class A3 {
  public static void main(String[] args) { 
		int a = 2;
		int b = 6;
		int outMax = MaxInt(a, b); 
		System.out.println("the output of the greater is: " + outMax);
	}
  public static int MaxInt(int a, int b) {
	if (a > b){ // operation compare : 1
		return a; // operation return : 2
	}else {
		return b; 
	}
	}

}

/* 
PART 1: Algorithm MaxInt(a, b):
* fallow the comments in code for OPERATION

Algorithm MaxInt(a, b):
 Input: Two integers a and b
 Output: The larger of the two integers
 if a > b then
 return a
 else
 return b

 i. the output of the greater is: 6 : return a>b
 ii. * fallow the comments for operation >> TOTAL OPERATIONS: 2
 iii. O(1)
 
 */
