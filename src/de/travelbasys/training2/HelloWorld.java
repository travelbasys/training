package de.travelbasys.training2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

/**
 * Dieses ist die Hauptklasse. Enthält die Main-Methode.
 * 
 * @author tba
 * 
 */

public class HelloWorld {

	public static void main(String[] args) {
		Properties config = new Properties();

		try {
			config.load(new FileInputStream("HelloWorld.ini"));
		} catch (FileNotFoundException e1) {
			// TODO Dokumentation Exit-Status.
			System.err.println ("HelloWorld.ini existiert nicht.");
			System.exit(1);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String lang = config.getProperty("lang", "en");

		// Change language to en.
		try {
			Locale.setDefault(new Locale(args[0]));
		} catch (Exception e) {
			Locale.setDefault(new Locale(lang));
		}

		/**
		 * Initialisiert HelloWorldBusiness mit dem Alias b
		 */
		HelloWorldBusiness b = new HelloWorldBusiness();
		b.init();
		/**
		 * Initialisiert HelloWorldUI mit dem Alias ui1 und übergibt den String
		 * von HelloWorldBusiness. Führt danach die Methode run der Klasse
		 * HelloWorldUI aus.
		 */
		HelloWorldUI ui1 = new HelloWorldUI();
		ui1.init(b);
		ui1.run();
		/*
		 * HelloWorldUI ui2 = new HelloWorldUI(); ui2.init( b ); ui2.run();
		 * 
		 * HelloWorldUI ui3 = new HelloWorldUI(); ui3.init( b ); ui3.run();
		 * 
		 * System.err.println( b.version ); b.version = "XXX";
		 * System.err.println( b.version );
		 * 
		 * System.err.println( HelloWorldUI.getCounter() ); try {
		 * HelloWorldUI.setCounter( 99 ); } catch (Exception e) {
		 * 
		 * e.printStackTrace(); } System.err.println( HelloWorldUI.getCounter()
		 * ); try { HelloWorldUI.setCounter( 100 ); } catch (Exception e) {
		 * e.printStackTrace(); } System.err.println( HelloWorldUI.getCounter()
		 * );
		 */
	}

}
