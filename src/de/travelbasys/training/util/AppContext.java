package de.travelbasys.training.util;

public class AppContext {

	public static String getMessage(String key){
		return Config.BUNDLE.getString(key);
	}

	public static void printMessage(String key){
		Console.println(Config.BUNDLE.getString(key));
	}

	public static void getErrString(String key) {
		Console.printerr(Config.BUNDLE.getString(key));
	}
	public static void println(Object obj){
		Console.println(obj);
	}
}