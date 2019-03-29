public class Demeter {
	static final String CURRENCY_SYMBOL = "Euro ";
	public static void main(String[] args) {
		ShopKeeper john = new ShopKeeper();
		Wallet wallet = new Wallet(95);
		System.out.println("Initial value in wallet is: " + CURRENCY_SYMBOL + wallet.getTotalMoney());
		Customer aoife = new Customer(wallet);
		john.chargeCustomer(aoife, 50);
		System.out.println("Value in wallet after purchase is: " + CURRENCY_SYMBOL + wallet.getTotalMoney());
	}
}

class ShopKeeper {
	// changed what talked to the wallet
	public void chargeCustomer(Customer cust, float amount) {
		if (cust.getAmountInWallet() > amount) {
			cust.Subtraction(amount);
		} else {
		}
	}
}

class Customer {
	public Customer(Wallet wallet) {
		name = "";
		myWallet = wallet;
	}
	// both methods that talk to the wallet
	public float getAmountInWallet() { return myWallet.getValue(); }
	public void Subtraction(float amount) { myWallet.subtractMoney(amount); }
	public String getName() { return name; }
	public Wallet getWallet() { return myWallet; }
	private String name;
	private Wallet myWallet; // customer object of wallet
}

class Wallet {
	public float getTotalMoney() { return value; }
	public Wallet(float newValue) { value = newValue; }
	public void addMoney(float deposit) { value += deposit; }
	public void subtractMoney(float debit) { value -= debit; }
	public float getValue() { return value; }
	private float value;
}
