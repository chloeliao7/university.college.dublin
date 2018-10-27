/* SavingsAccount class
*  Anderson, Franceschi
*/

import java.text.DecimalFormat;

// 1. ***** indicate that SavingsAccount inherits
//          from BankAccount
public class SavingsAccount extends BankAccount
{
   public final double DEFAULT_RATE = .03;
   private double interestRate; // this will be the interestRate variable as a double and private

   // 2. ****** define the private interestRate instance variable
   // interestRate, a double, represents an annual rate
   
   // 3 ***** write the default constructor
   /** default constructor
   *   explicitly calls the BankAccount default constructor
   *   set interestRate to default value DEFAULT_RATE
   *   print a message to System.out indicating that this
   *     constructor is called
   */
  
  public SavingsAccount() { // here we are creating the default constructor 
    super(); // here we are calling the inherited class 
    interestRate = DEFAULT_RATE; // here we are reasigning the DEFAULT_RATE variable and giving it another name 
    System.out.println("the default constructor has been called "); // printing the constructor 
  }; 
   
   // 4 ***** write the overloaded constructor
   /** overloaded constructor
   *   explicitly call BankAccount overloaded constructor
   *   call setInterestRate method, passing interestRate
   *   print a message to System.out indicating that this
   *     constructor is called
   *  @param  balance      starting balance
   *  @param  interestRate starting interest rate
   */
   
  public SavingsAccount(double balance, double interestRate){ // here we are calling the default constructor and giving it two double params 
    super(balance); // here we are sending the balance param to the inherited class from SavingsAccount 
    setInterestRate(interestRate); // here we are sending interestRate to the setInterestRate Method 
    System.out.println("the BankAccount overloaded constructor has been called "); // print 
  }

   // 5 ****** write this method:
   /** applyInterest method, no parameters.
   *   call the deposit method, passing a month's worth of interest
   *   remember that the interestRate instance variable is the annual rate
   *   
   *   @return a reference to this object 
   */

  public SavingsAccount applyInterest() { //  here we are using the Savings Account class to access appyInterest and calling the method as it is 
    double rateofmonth;  // creating a double rateofmonth 
    rateofmonth = interestRate/12; // deviding the interestRate by 12 so it can give us an months net worth of interest 
    deposit(rateofmonth);  // sending it into the deposite method located in bank account 
    return this; // needs to be retruned bacl to savings Account 
  }
  
   /** accessor method for interestRate
   *  @return  interestRate
   */
  
   public double getInterestRate( ) 
   {
     return interestRate;
   }

   /** mutator method for interestRate
   *  @param  interestRate new value for interestRate
   *          interestRate must be >= 0.0
   *            if not, do not change the value
   *          stores interestRate as input value / 100
   *          that is, 3.5 is stored as .035
   *  @return  a reference to this object
   */
   public SavingsAccount setInterestRate( double interestRate )
   {
     if ( interestRate >= 0.0 )
        this.interestRate = interestRate / 100;
     return this;
   }

   // 6 *****  write this method
   /* toString method
   *  @return a String containing formatted balance and interestRate
   *    invokes superclass toString to format balance
   *    formats interestRate as percent using a DecimalFormat object
   *    To create a DecimalFormat object for formatting percentages
   *    use this pattern in the constructor: "0.00%"
   */

  @Override
   public String toString(){ // writitng a two string method so it can be outputted and formated correctly
     return "this is the balance: " + super.toString() + "this is the interestRate: "  + MONEY.format(interestRate); // return the tostring 
   }
}
