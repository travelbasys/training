package de.travelbasys.training.experiment;

import java.util.Scanner;

public class IO {
	private static final Scanner SCANNER = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("W E L C O M E");
		System.out.println();
		System.out.print("Enter your first name: ");

		String input = "";
		input = SCANNER.nextLine();

		System.out.println("You entered: " + input);
		System.out.print("Enter your last name: ");
		System.out.flush();
		input = SCANNER.nextLine();
		System.out.println("You entered: " + input);
		System.out.println("<*>");
	}
}
