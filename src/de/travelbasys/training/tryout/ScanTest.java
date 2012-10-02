package de.travelbasys.training.tryout;

import java.util.Scanner;

import de.travelbasys.training.util.Console;

public class ScanTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
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
