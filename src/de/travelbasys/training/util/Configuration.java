package de.travelbasys.training.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

//Initialisiert die Configuration für das Hauptprogramm.
//Enthalten sind Sprache als auch Datenbank.
//Verwendet dazu den Parser unserer CommandLine-Methode, welche ein Optionsobjekt ausgibt.

public class Configuration {

	private static final String DEFAULT_LANGUAGE = "en";
	private static final String DEFAULT_DATABASE = "test.db";
	private static final String LANG_KEY = "lang";
	private static final String DATABASE_KEY = "database";
	private static final String ERR_FILENOTFOUND = (Config.CONFIG_FILENAME + " existiert nicht.");
	private static final int EXIT_ERR_STATUS = 1;

	private static final Map<String, String> DATA = new HashMap<String, String>();

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
			Locale.setDefault(new Locale(lang));
		} catch (Exception e) {
			String lang = config.getProperty(LANG_KEY, DEFAULT_LANGUAGE);
			Locale.setDefault(new Locale(lang));
		}
		// Wir kümmern uns jetzt um die DATABASE.
		String db;
		db = (String) CommandLine.getOptions().get("db");
		if (db == null) {
			db = config.getProperty(DATABASE_KEY, DEFAULT_DATABASE);
		}
		DATA.put("db", db);
	}

	public static Object get(String key) {
		return DATA.get(key);
	}

}
