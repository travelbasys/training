package de.travelbasys.training.util;

public class AppContext {

	public static void getString(String key) {
		Console.println(Config.BUNDLE.getString(key));
	}

	public static void getErrString(String key) {
		Console.printerr(Config.BUNDLE.getString(key));

	}
	public static void println(Object obj){
		Console.println(obj);
	}
}