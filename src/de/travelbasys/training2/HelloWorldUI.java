package de.travelbasys.training2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * ist verantwortlich f�r die Frage nach dem Namen und dem Alter des Benutzters
 * und gibt diese nach System.out aus.
 * 
 * Wir mit einer Message aus der Klasse HelloWorldBusiness initialisiert. Jede
 * Instanz der Klasse wird gez�hlt; der Instanzenz�hler kann abgefragt und von
 * au�en ver�ndert werden.
 * 
 * @author tba
 * 
 */

public class HelloWorldUI {
	/**
	 * Bindet den Resourcen Ordner ein, in dem die Properties der verschiedenen
	 * Sprachen liegen.
	 */
	String baseName = "resources.HelloWorld";
	ResourceBundle bundle = ResourceBundle.getBundle(baseName);

	/**
	 * Das eingegebene Alter des Benutzers. Wird mit 0 (=Null) initialisiert.
	 */
	public int age = 0;

	/**
	 * Der eingegebene Name des Benutzers; anfangs leer.
	 */
	public String username = "";

	private String message;
	private static int counter = 0;

	/**
	 * fragt den Benutzer nach seinem Namen und seinem Alter.
	 * 
	 * Es ist zul�ssig, einen leeren Namen einzugeben. Das Alter muss eine
	 * strikt positive ganze Zahl sein. Die Altersabfrage wird so lange
	 * wiederholt, bis ein g�ltiger Wert eingegeben wird, z.B. wenn eine
	 * negative Zahl oder Null, oder ein nicht-numerischer Textstring eingegeben
	 * wird.
	 * 
	 * Am Ende werden Name und Alter nach System.out ausgegeben.
	 */
	public void run() {
		PrintStream out = System.out;
		PrintStream err = System.err;

		try {
			out.println(bundle.getString("UsernamePrompt"));
		} catch (MissingResourceException e) {
			err.println(e);
		}
		Scanner in = new Scanner(System.in);
		username = in.nextLine();
		run2();
	}

	/**
	 * fragt den Benutzer nach seinem seinem Alter.
	 * 
	 * Das Alter muss eine strikt positive ganze Zahl sein. Die Altersabfrage
	 * wird so lange wiederholt, bis ein g�ltiger Wert eingegeben wird, z.B.
	 * wenn eine negative Zahl oder Null, oder ein nicht-numerischer Textstring
	 * eingegeben wird.
	 */
	private void run2() {
		PrintStream out = System.out;
		PrintStream err = System.err;

		try {
			out.println(bundle.getString("AgePrompt"));
		} catch (MissingResourceException f) {
			err.println(f);
		}
		try {
			Scanner in = new Scanner(System.in);
			age = in.nextInt();
		} catch (InputMismatchException e) {
			out.println(bundle.getString("AgeNumberErr"));
		}

		finally {
			if (age <= 0) {
				out.println(bundle.getString("AgeValid"));
				run2();
			}
		}
		run3();
	}

	/**
	 * Gibt den aktuellen Namen und das Alter nach System.out aus.
	 */
	private void run3() {
		PrintStream out = System.out;
		// TODO Change Date to Calender
		out.println(message + " " + new Date());
		run4();
	}

	/**
	 */
	private void run4() {

		try {

			// Erzeuge einen Writer, der ein existierendes File �ffnet
			// oder ein neues anlegt um Daten hinten an das File
			// anzuh�ngen.
			FileWriter writer = new FileWriter("HelloWorld.txt", true);

			// Schreibe in Datei.
			writer.write(bundle.getString("Username"));
			writer.write(username);
			writer.write(System.getProperty("line.separator"));
			writer.write(bundle.getString("Age"));
			writer.write(String.valueOf(age));
			writer.write(System.getProperty("line.separator"));
			writer.write(System.getProperty("line.separator"));

			// Sorge daf�r, dass Ausgabe auf der Platte landet.
			writer.flush();

			// Beende den writer.
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * initialisiert die aktuelle Instanz, indem das als Parameter �bergebene
	 * Business Objekt nach der g�ltigen Message gefragt wird und dieser Wert
	 * intern aufbewahrt wird.
	 * 
	 * Au�erdem wird der interne Instanzenz�hler um Eins erh�ht.
	 * 
	 * @param b
	 *            ein Business Objekt.
	 */
	public void init(HelloWorldBusiness b) {
		message = b.getMessage();
		counter++;
	}

	/**
	 * fragt den aktuellen Stand des Instanzenz�hlers ab.
	 * 
	 * @return der Wert des Instanzenz�hlers.
	 */
	public static int getCounter() {
		return HelloWorldUI.counter;
	}

	/**
	 * (Experimentell) �ndert den aktuellen Wert des Instanzenz�hlers.
	 * 
	 * @param i
	 *            der neue Wert des Instanzenz�hlers; muss gerade sein!
	 * 
	 * @throws Exception
	 *             wenn ein ungerader neuer Wert angegeben wird.
	 */
	public static void setCounter(int i) throws Exception {
		if (i % 2 == 0) {
			counter = i;
		} else {
			throw new Exception("*** Nur gerade Werte erlaubt *** ");
		}
	}

}
