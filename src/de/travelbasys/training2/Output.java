package de.travelbasys.training2;

import java.io.PrintStream;

public class Output {
	public static PrintStream err = System.err;

	public static void println(String string) {
		System.out.println(string);
		System.out.flush();
	}

}
