package de.travelbasys.training.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Klasse um grundlegende Konfigurationen zu verwalten.
 * 
 * @author haut
 * 
 */
public class Config {
	public static final String CONFIG_FILENAME = "rbsjava.ini";
	private static final String baseName = "resources.rbsjava";
	public static ResourceBundle BUNDLE = ResourceBundle.getBundle(baseName);

	public static void updateLanguage(Locale locale) {

		Locale.setDefault(locale);
		BUNDLE = ResourceBundle.getBundle(baseName);

		Configuration.fireConfigurationEvent(ConfigurationEvent.LOCALE);
	}
}
