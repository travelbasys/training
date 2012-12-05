package experiment.scan;

import java.util.Scanner;

import de.travelbasys.training.util.Console;

public class ScanTest {

	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		do {
			if (in.hasNextInt()) {
				int a = in.nextInt();
				Console.println(a);
			} else {
				in.next();
				System.err.println("Kein Int");
			}
		} while (true);
	}
}
