package de.travelbasys.training2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HelloWorldMain {

	/**
	 * Legt defaults fest.
	 */
	private static final String DEFAULT_LANGUAGE = "en";
	private static final String LANG_KEY = "lang";
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
			// TODO Dokumentation Exit-Status.
			System.err.println(ERR_FILENOTFOUND);
			System.exit(EXIT_ERR_STATUS);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String lang = config.getProperty(LANG_KEY, DEFAULT_LANGUAGE);

		// Change language to en.
		try {
			Locale.setDefault(new Locale(args[0]));
		} catch (Exception e) {
			Locale.setDefault(new Locale(lang));
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
		HelloWorldUI ui = new HelloWorldUI();
		ui.init(b);
		UserList ul = new UserList();
		ul.init();

		HelloWorldMenu.show(args, ui, ul);
	}

}
