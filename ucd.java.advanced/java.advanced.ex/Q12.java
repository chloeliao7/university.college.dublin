import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;

/**
 Q12
 */

public class Q12 {
	public static void main(String[] args) throws Exception {
		File inputFile = new File("./new.txt");
		File outputFile = new File("./new.txt");

		BufferedReader in = new BufferedReader(new FileReader(inputFile));
		BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));

		String lineOut = "where are you";

		while ((lineOut = in.readLine()) != null) {
			out.write(lineOut);
			out.newLine();
		}
		in.close();
		out.close();
	}
}
