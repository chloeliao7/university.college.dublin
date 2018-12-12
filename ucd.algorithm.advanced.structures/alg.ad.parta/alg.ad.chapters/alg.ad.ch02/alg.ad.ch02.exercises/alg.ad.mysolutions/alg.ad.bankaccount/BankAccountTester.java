/**
A class to test the BankAccount class.
*/
public class BankAccountTester {
  /**
  Tests the methods of the BankAccount class.
  @param args not used
  */
  public static void main(String[] args) {
    BankAccount harrysChecking = new BankAccount();
    harrysChecking.deposit(2000);
    harrysChecking.withdraw(500);
    System.out.println(harrysChecking.getBalance());
    System.out.println("Expected: 1500");
  }
}

// When you run the BankAccountTester program, how many objects
// of class BankAccount are constructed? How many objects of type
// BankAccountTester?
//  Answer: One BankAccount object, no BankAccountTester
//  object. The purpose of the BankAccountTester class is
//  merely to hold the main method.

// 2
// Why was it necessary to introduce the local variable change in
// the giveChange method? That is, why didn’t the method simply
// end with the statement
// return payment - purchase;
//  Answer: After computing the change due, payment and
// purchase were set to zero. If the method returned payment -
// purchase, it would always return zero.

// 3
// What do local variables and parameter variables have in
// common? In which essential aspect do they differ?
//  Answer: Variables of both categories belong to methods – they
//  come alive when the method is called, and they die when the
//  method exits. They differ in their initialization. Parameter
//  variables are initialized with the call values; local variables must
//  be explicitly initialized.

// 4
// Why was it necessary to introduce the local variable change in
// the giveChange method? That is, why didn’t the method simply
// end with the statement
// return payment - purchase;
//  Answer: After computing the change due, payment and
// purchase were set to zero. If the method returned payment -
// purchase, it would always return zero.

// 5
// The implicit parameter of a method is the object on which the
// method is invoked
// • public void deposit(double amount)
//  {
//  balance = balance + amount;
//  }

// 6
// How many implicit and explicit parameters does the withdraw
// method of the BankAccount class have, and what are their names
// and types?
//  Answer: One implicit parameter, called this, of type
//  BankAccount, and one explicit parameter, called amount, of
//  type double.