package de.travelbasys.training.dialog;

import java.util.MissingResourceException;

import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Console;

public class Dialog {

	public static String getString(String key) {
		try {
			AppContext.println(key);
		} catch (MissingResourceException e) {
			Console.printerr(e);
		}
		return Console.nextLine().trim();
	}

	public static int getInt(String key) {
		try {
			AppContext.println(key);
		} catch (MissingResourceException e) {
			Console.printerr(e);
		}
		return Console.nextInt();
	}

}
