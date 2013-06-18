package de.travelbasys.training.util;

/**
 * util Klasse für die Ausgabe von dieversen Outputs in der Console.
 * 
 * @author haut
 * 
 */
public class AppContext {

	public static String nextLine() {
		return Console.nextLine();
	}

	public static String getMessage(String key) {
		return Config.BUNDLE.getString(key);
	}

	public static void printMessage(String key) {
		Console.println(Config.BUNDLE.getString(key));
	}

	public static String getErrString(String key) {
		return Config.BUNDLE.getString(key);
	}

	public static void printErrString(String key) {
		Console.printerr(Config.BUNDLE.getString(key));
	}

	public static void println(Object obj) {
		Console.println(obj);
	}

}