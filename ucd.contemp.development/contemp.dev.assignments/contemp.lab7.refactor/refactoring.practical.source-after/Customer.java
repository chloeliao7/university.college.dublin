import java.util.ArrayList;
import java.util.List;

public class Customer {
	public Customer(String name) { _name = name; }
	public void addRental(Rental arg) { _rentals.add(arg); }
	public String getName() { return _name; }

	/* 	
	FUTURE EVOLUTION : HTML
	thisAmount += rentalAmount; get rid off
	String result2 = result; // this line ins not nessesary and can be taken out. refactoring 
*/

	public String vehicleRentalHTMLStatement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "<p>Rental Record for " + getName() + "</p>"; // changing to html

		for (Rental rental : _rentals) {
			double rentalAmount = calcualteRentalAmount(rental);

			frequentRenterPoints++;

			if ((rental.getVehicle().getVehicleType() == Vehicle.Type.ALL_TERRAIN) && rental.getDaysRented() > 1) frequentRenterPoints++; // add type since enum
			result += "<p>" + rental.getVehicle().getTitle() + "\t" + String.valueOf(rentalAmount) + "</p>"; // changing to html
			totalAmount += rentalAmount;
		}

		result += "<p>Amount owed is " + String.valueOf(totalAmount) + "</p>"; // changing to html
		result += "<span>You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points</span>"; // makign sure its html

		return result; // what we are returning : an HTML no
	}

	public String vehicleRentalStatement() { // Q$: tasks : what is a good name: vehicle rental statement :

		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";

		for (Rental rental : _rentals) {
			double rentalAmount = calcualteRentalAmount(rental);

			// add frequent renter points
			frequentRenterPoints++;

			// add bonus for a two day all terrain rental
			if ((rental.getVehicle().getVehicleType() == Vehicle.Type.ALL_TERRAIN) && rental.getDaysRented() > 1) frequentRenterPoints++; // add type since enum
			// show figures for this rental
			result += "\t" + rental.getVehicle().getTitle() + "\t" + String.valueOf(rentalAmount) + "\n";
			totalAmount += rentalAmount; // delete the amount and change to rental amount to be local
		}

		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		// String result2 = result; // this line ins not nessesary and can be taken out. refactoring
		return result;
	}

	// question 4 method create
	private double calcualteRentalAmount(Rental rental) { // passed as paranmeters as rental : )

		double rentalAmount = 0; // rename amount to rental amount for all : question 4 change single variable
		switch (rental.getVehicle().getVehicleType()) { // get vehicle type
			case CAR:
				rentalAmount += 2; // adding type to this

				if (rental.getDaysRented() > 2) rentalAmount += (rental.getDaysRented() - 2) * 1.5;
				break;

			case ALL_TERRAIN: rentalAmount += rental.getDaysRented() * 3; break; // take off unnessesary class names since its a type : use each enum constant
			case MOTORBIKE:
				rentalAmount += 1.5;
				if (rental.getDaysRented() > 3) rentalAmount += (rental.getDaysRented() - 3) * 1.5;
				break;
		}
		return rentalAmount; // local variable
	}

	private String _name;
	private List<Rental> _rentals = new ArrayList<Rental>();
}

/**
 * 
 MORE REFACTORING:  String result2 = result; // this line ins not nessesary and can be taken out. this is for Q 2 future evolution : directly return result 

   Q 1
   
   i see a lot of codesmells in this documetent = the first one is one that deals 
with rental and vehicle class : meaninf that when you look at the rental class 
you will see a method called get vehicle, this should still be in the vehicle 
class. the refactoring way to deal with this issue (code smell) would be called 
: method extraction 

Q 2
2. Future Evolution
The code works, as can be demonstrated by running the test cases. If this is all the code would ever be expected to do, then it wouldn’t matter if it were smelly or not. However, a number of new requirements are planned as follows:

• The the current statement method returns a string. It is planned to extend the program to
produce HTML output

• The classification scheme for vehicles will be changed periodically, and this will affect both the
way customers are charged for rentals and the way that frequent renter points are calculated.

Q 3
The Vehicle and Rental classes suffer from the same code . What is it? 
What sort of refactoring comes to mind to fix these smells?smell
The Customer class has a different type of problem. What is it? 
It also violates some of the principles we looked at.

- i also see that within this document you can spot that motorbike, all terrain 
and car are static final variables in the vehicle class where if you wanted to 
implimnent new types of each one of these it wouldnt be possible: the better solution would 
be to create them as normal public variables and then change them if needed 

Q 4
determine amounts for each line
what its doing: 
A: based on the cases its calculating the amount from each behicle and checking the type. 
Does the code block embody a coherent piece of functionality? 
A: changing each to rental : 
Consider the extent of the code block to extract. We’re looking at the switch statement, but does it make sense the extract the statement preceding the switch statement (double thisAmount = 0) as well?
A: question 4 method 

// removing the block that clacualtes the rental amount based on the vehicle type
// moving that code to a new method.

 switch (rental.getVehicle().getVehicleType()) { // get vehicle type 
 case CAR: thisAmount += 2; // adding type to this 
   
   if (rental.getDaysRented() > 2) thisAmount += (rental.getDaysRented() - 2) * 1.5;
   break;

 case ALL_TERRAIN: thisAmount += rental.getDaysRented() * 3; break; // take off unnessesary class names since its a type : use each enum constant
 case MOTORBIKE:
   thisAmount += 1.5;
   if (rental.getDaysRented() > 3) thisAmount += (rental.getDaysRented() - 3) * 1.5;
   break;
}

Q 5 DONE ON TOP 

Q 6 DONE AS CHANGES TO STATEMENT METHOD 
*/