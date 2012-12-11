package de.travelbasys.training.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

//Initialisiert die Configuration für das Hauptprogramm.
//Enthalten sind Sprache als auch Datenbank.
//Verwendet dazu den Parser unserer CommandLine-Methode, welche ein Optionsobjekt ausgibt.

public class Configuration {

	private static final String DEFAULT_LANGUAGE = "en";
	private static final String DEFAULT_DATABASE = "testdb";
	private static String DEFAULT_DATABASE_TYPE = "default";
	private static final String LANG_KEY = "lang";
	private static final String DATABASE_KEY = "database";
	private static String DATABASE_TYPE_KEY = "database_type";
	private static final String STYLESHEET_KEY = "stylesheet";
	private static final String STYLESHEET_PATH = "./resources/";
	private static final String DEFAULT_STYLESHEET = "rbsjava.css";
	
	private static final String ERR_FILENOTFOUND = (Config.CONFIG_FILENAME + " existiert nicht.");
	private static final int EXIT_ERR_STATUS = 1;

	private static final Map<String, String> DATA = new HashMap<String, String>();
	
	private static List<ConfigurationListener> listeners = new ArrayList<ConfigurationListener>();

	public static void init(Map<?, ?> options) {
		/**
		 * Lädt Konfiguration. Wenn die Konfiguration nicht vorhanden ist wird
		 * ein Fehler ausgegeben. Lädt sonst die Standard-Config.
		 */
		Properties config = new Properties();

		try {
			config.load(new FileInputStream(Config.CONFIG_FILENAME));
		} catch (FileNotFoundException e1) {

			System.err.println(ERR_FILENOTFOUND);
			System.exit(EXIT_ERR_STATUS);
		} catch (IOException e1) {

			e1.printStackTrace();
		}

		// Wir kümmern uns jetzt um die Sprache.
		// Lesen aus der Argumentenliste anhand des Keys lang.
		// Wenn der Key nicht gefunden wird, dann übernimmt unser
		// Properties-Objekt den Wert aus einer Ini-Datei,
		// Ist dies auch nicht möglich wird die Standardsprache (Englisch)
		// gewählt.
		try {
			String lang = (String) CommandLine.getOptions().get("lang");
			Locale.setDefault(new Locale(lang.trim()));
		} catch (Exception e) {
			String lang = config.getProperty(LANG_KEY, DEFAULT_LANGUAGE);
			Locale.setDefault(new Locale(lang.trim()));
		}
		// Wir kümmern uns jetzt um die DATABASE.

		String dbtype;
		String dbtype1 = "txt";
		String dbtype2 = "mysql";
		String dbtype3 = "access";
		dbtype = (String) CommandLine.getOptions().get("database_type");
		if (dbtype == null) {
			dbtype = config.getProperty(DATABASE_TYPE_KEY,
					DEFAULT_DATABASE_TYPE);
		}
		if (dbtype.equals(dbtype1)) {
			DATA.put("dbtype", "1");
		} else if (dbtype.equals(dbtype2)) {
			DATA.put("dbtype", "2");
		} else if (dbtype.equals(dbtype3)) {
			DATA.put("dbtype", "3");
		} else {
			DATA.put("dbtype", "default");
		}

		String db;
		db = (String) CommandLine.getOptions().get("database");
		if (db == null) {
			db = config.getProperty(DATABASE_KEY, DEFAULT_DATABASE);
		}
		DATA.put("db", db.trim());
		
		String stylesheet;
		stylesheet = (String) CommandLine.getOptions().get("stylesheet");
		if (stylesheet == null) {
			stylesheet = config.getProperty(STYLESHEET_KEY, STYLESHEET_PATH + DEFAULT_STYLESHEET);
		}
		DATA.put("stylesheet",STYLESHEET_PATH + stylesheet.trim());
		
	}

	public static Object get(String key) {
		return DATA.get(key);
	}

	public static void addConfigurationListener(ConfigurationListener listener){
		listeners.add(listener);
	}
	
	public static void removeConfigurationListener(ConfigurationListener listener){
		listeners.remove(listener);
	}

	public static void fireConfigurationEvent(ConfigurationEvent e) {
		for (ConfigurationListener listener : listeners) {
			listener.handleConfigurationEvent(e);
		}
	}
}
