public class BankRobber {
  public static void main(String[] args) {
    BankAccount momsSavings = new BankAccount(1000);
    momsSavings.balance = 0; // because its inaccesible 
  }
}


// why doesnt it work
// Answer: Because the balance instance variable is
// accessed from the main method of BankRobber. The compiler
// will report an error because balance has private access in
// BankAccount.

// 2
// The Rectangle class has four instance variables: x, y, width,
// and height. Give a possible implementation of the getWidth
// method.
// Answer:
// public int getWidth() {
//  return width;
// }

// 3
// Give a possible implementation of the translate method of the
// Rectangle class.
// Answer: There is more than one correct answer. One
// possible implementation is as follows:
// public void translate(int dx, int dy) {
//  int newx = x + dx;
//  x = newx;
//  int newy = y + dy;
//  y = newy;
// }