package de.travelbasys.training.util;

import java.io.PrintStream;
import java.util.Scanner;

public class Console {
	public static final PrintStream err = System.err;
	private static Scanner sCANNER_STR;
	private static Scanner sCANNER_NUB;

	public static void println(Object obj) {
		System.out.println(obj);
		System.out.flush();
	}

	public static void print(Object obj) {
		System.out.print(obj);
		System.out.flush();
	}

	public static void printerr(Object obj) {
		System.err.println(obj);

		// Wir brauchen flush nicht zu benutzen, weil der err Stream
		// das automatisch macht.
	}

	public static String nextLine() {
		sCANNER_STR = new Scanner(System.in);
		return sCANNER_STR.nextLine();
	}

	public static int nextInt() {
		sCANNER_NUB = new Scanner(System.in);
		return sCANNER_NUB.nextInt();
	}
}
