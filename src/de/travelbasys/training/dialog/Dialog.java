package de.travelbasys.training.dialog;

import java.util.MissingResourceException;

import de.travelbasys.training.util.Config;
import de.travelbasys.training.util.Console;

public class Dialog {

	public static String getString(String key) {
		try {
			Console.println(Config.BUNDLE.getString(key));
		} catch (MissingResourceException e) {
			Console.printerr(e);
		}
		return Console.nextLine().trim();
	}

	public static int getInt(String key) {
		try {
			Console.println(Config.BUNDLE.getString(key));
		} catch (MissingResourceException e) {
			Console.printerr(e);
		}
		return Console.nextInt();
	}

}
