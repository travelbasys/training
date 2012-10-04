package de.travelbasys.training.tryout;

import java.util.Scanner;

import de.travelbasys.training.util.Console;

public class ScanTest2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		do {
			try {
				int a = in.nextInt();
				Console.println(a);
			} catch (Exception e) {
				System.err.println(e);
				in.next();
			}
		} while (true);
	}
}
