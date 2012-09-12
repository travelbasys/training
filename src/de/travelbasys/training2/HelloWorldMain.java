package de.travelbasys.training2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;
/**
 * Diese Klasse lädt alle Einstellungen für die gesamte Applikation.
 * @author tba
 *
 */
public class HelloWorldMain {

	/**
	 * Legt defaults fest.
	 */
	private static final String DEFAULT_LANGUAGE = "en";
	private static final String DEFAULT_DATABASE = "HelloWorld.txt";
	private static final String LANG_KEY = "lang";
	private static final String DATABASE_KEY = "database";
	private static final String CONFIG_FILENAME = "HelloWorld.ini";
	private static final String ERR_FILENOTFOUND = "HelloWorld.ini existiert nicht.";
	private static final int EXIT_ERR_STATUS = 1;

	/**
	 * Bindet den Resourcen Ordner ein, in dem die Properties der verschiedenen
	 * Sprachen liegen.
	 */
	private static String baseName = "resources.HelloWorld";
	static ResourceBundle bundle = ResourceBundle.getBundle(baseName);

	static Scanner in;

	public static void main(String[] args) {

		/**
		 * Lädt Konfiguration. Wenn die Konfiguration nicht vorhanden ist wird
		 * ein Fehler ausgegeben. Lädt sonst die Standard-Config.
		 */
		Properties config = new Properties();

		try {
			config.load(new FileInputStream(CONFIG_FILENAME));
		} catch (FileNotFoundException e1) {

			System.err.println(ERR_FILENOTFOUND);
			System.exit(EXIT_ERR_STATUS);
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		
		// Wir kümmern uns jetzt um die Sprache.
		try {
			Locale.setDefault(new Locale(args[0]));
		} catch (Exception e) {
			String lang = config.getProperty(LANG_KEY, DEFAULT_LANGUAGE);
			Locale.setDefault(new Locale(lang));
		}
		
		
		// Wir kümmern uns jetzt um die DATABASE.
		String db;
		try {
			db = args[1];
		} catch (Exception e) {
			db = config.getProperty(DATABASE_KEY, DEFAULT_DATABASE);
		}
			
		/**
		 * 
		 * HelloWorldUI (Schreiber) wird mit einer Message aus der Klasse
		 * HelloWorldBusiness initialisiert. UserList (Leser) wird initalisiert.
		 * Gibt aus ob der Schreiber oder Leser gestartet werden soll. Nach
		 * erfolgreicher Auswahl, wird das entsprechende Programm gestartet.
		 * Sonst: Fehler.
		 */

		HelloWorldBusiness b = new HelloWorldBusiness();
		b.init();
		UserCreate ui = new UserCreate();
		ui.init(b);
		UserList ul = new UserList();
		ul.init();
		
		// Initialisiere den Datenbankzugriff.
		UserDB.init(db);
		
		HelloWorldMenu.show(args, ui, ul);
	}

}
