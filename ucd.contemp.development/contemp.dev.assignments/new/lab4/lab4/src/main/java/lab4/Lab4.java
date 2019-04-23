package lab4;
public class Lab4 {
	public String processNumber(int number) {
		if (number == 1) {
			return "1";
		} else if (number == 2) {
			return "2";
		} else if (number % 3 == 0 && number % 5 != 0) {
			return "Bee";
		} else if (number == 4) {
			return "4";
		} else if (number % 5 == 0 && number % 3 != 0) {
			return "Bop";
		} else if (number % 5 == 0 && number % 3 == 0) {
			return "BeeBop";
		} else if (number == 7) {
			return "7";
		} else if (number == 8) {
			return "8";
		}
		// mutation portion of the code :
		else if (number != 1) {
			return "Mutation";
		} else {
			return Integer.toString(number);
			// return null;
		}
	}
}
