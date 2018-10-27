import java.util.Scanner;

public class CashRegisterSimulator {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		CashRegister register = new CashRegister();
		System.out.print("Enter price: ");
		doubleprice = in.nextDouble();
		register.recordPurchase(price);
		System.out.print("Enter dollars: ");
		intdollars = in.nextInt();
		System.out.print("Enter quarters: ");
		intquarters = in.nextInt();
		System.out.print("Enter dimes: ");
		intdimes = in.nextInt();
		System.out.print("Enter nickels: ");
		intnickels = in.nextInt();
		System.out.print("Enter pennies: ");
		intpennies = in.nextInt();
		register.enterPayment(dollars, quarters, dimes, nickels, pennies);
		System.out.print("Your change: ");
		System.out.println(register.giveChange());
	}
}


// Why can’t input be read directly from System.in? Answer:The class only has a method to read a single byte. It would be very tedious to form characters, strings, and numbers from those bytes.
//! String input = JOptionPane.showInputDialog(prompt)