package de.travelbasys.training2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * ist verantwortlich für die Frage nach dem Namen und dem Alter des Benutzters
 * und gibt diese nach System.out aus.
 * 
 * Wir mit einer Message aus der Klasse HelloWorldBusiness initialisiert. Jede
 * Instanz der Klasse wird gezählt; der Instanzenzähler kann abgefragt und von
 * außen verändert werden.
 * 
 * @author tba
 * 
 */

public class HelloWorldUI {
	
	private static final boolean APPEND = true;
	private static final String FILE = "HelloWorld.txt";
	
	/**
	 * Bindet den Resourcen Ordner ein, in dem die Properties der verschiedenen
	 * Sprachen liegen.
	 */
	private static String baseName = "resources.HelloWorld";
	private static ResourceBundle bundle = ResourceBundle.getBundle(baseName);

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
	 * Es ist nicht zulässig, einen leeren Namen einzugeben. Das Alter muss eine
	 * strikt positive ganze Zahl sein. Die Altersabfrage wird so lange
	 * wiederholt, bis ein gültiger Wert eingegeben wird, z.B. wenn eine
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

		username = username.trim();

		if (username.isEmpty()){
			err.println(bundle.getString("EmptyFieldErr"));
		}
		else {
			run2();
		}
	}

	/**
	 * fragt den Benutzer nach seinem seinem Alter.
	 * 
	 * Das Alter muss eine strikt positive ganze Zahl sein. Die Altersabfrage
	 * wird so lange wiederholt, bis ein gültiger Wert eingegeben wird, z.B.
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

		// finally {
		// if (age <= 0) {
		// out.println(bundle.getString("AgeValid"));
		// run2();
		// }
		// }
		run3();
	}

	/**
	 * Gibt den aktuellen Namen und das Alter nach System.out aus.
	 */
	private void run3() {
		PrintStream out = System.out;

		// (Intern) Lege das Datumsformat fest, welches die in HelloWorld
		// vorgegebene Sprache (Locale) verwendet.
		Calendar cal = Calendar.getInstance();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL,
				DateFormat.MEDIUM);

		// Benutze das obige Datumsformat für die aktuelle Zeit.
		out.println(message + " " + df.format(cal.getTime()));
		run4();
	}

	/**
	 */
	private void run4() {

		User user;
		user = new User(username, age);
		/*
		 * User user2 = new User(username, age); (Experimentell) try {
		 * 
		 * System.out.println(user); System.out.println(user.getName());
		 * System.out.println(user.getAge());
		 * 
		 * System.out.println(user2); System.out.println(user2.getName());
		 * System.out.println(user2.getAge());
		 * 
		 * System.out.println( user.equals( user ) ); System.out.println(
		 * user.equals( user2 ) ); System.out.println( user2.equals( user ) );
		 * 
		 * System.out.println(user.hashCode());
		 * System.out.println(user2.hashCode());
		 * 
		 * } catch (IllegalArgumentException e1) { // TODO Auto-generated catch
		 * block e1.printStackTrace(); }
		 */

		try {

			// Erzeuge einen FileWriter, der ein existierendes File öffnet
			// oder ein neues anlegt.
			FileWriter fw = new FileWriter(FILE, APPEND);

			// Erzeuge einen PrintWriter, der den Speicherort der Datei ausliest
			// aus
			// dem vorhandenen FileWriter ausliest und Daten an das File
			// anhängt.
			PrintWriter writer = new PrintWriter(fw);

			// Lese Daten aus Properties und der User-Klasse aus.
			// Anschließend schreibe in Datei.
			writer.println(user);

			// Sorge dafür, dass Ausgabe auf der Platte landet.
			writer.flush();

			// Beende den writer.
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * initialisiert die aktuelle Instanz, indem das als Parameter übergebene
	 * Business Objekt nach der gültigen Message gefragt wird und dieser Wert
	 * intern aufbewahrt wird.
	 * 
	 * Außerdem wird der interne Instanzenzähler um Eins erhöht.
	 * 
	 * @param b
	 *            ein Business Objekt.
	 */
	public void init(HelloWorldBusiness b) {
		message = b.getMessage();
		counter++;
	}

	/**
	 * fragt den aktuellen Stand des Instanzenzählers ab.
	 * 
	 * @return der Wert des Instanzenzählers.
	 */
	public static int getCounter() {
		return HelloWorldUI.counter;
	}

	/**
	 * (Experimentell) Ändert den aktuellen Wert des Instanzenzählers.
	 * 
	 * @param i
	 *            der neue Wert des Instanzenzählers; muss gerade sein!
	 * 
	 * @throws Exception
	 *             wenn ein ungerader neuer Wert angegeben wird.
	 */
	public static void setCounter(int i) throws Exception {
		if (i % 2 == 0) {
			counter = i;
		} else {
			throw new Exception(bundle.getString("UnevenErr"));
		}
	}

}
