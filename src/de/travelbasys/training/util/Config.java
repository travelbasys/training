package de.travelbasys.training.util;

import java.util.ResourceBundle;

public class Config {
	public static final String CONFIG_FILENAME = "rbsjava.ini";

	private static String baseName = "resources.rbsjava";
	public static ResourceBundle BUNDLE = ResourceBundle.getBundle(baseName);
}
