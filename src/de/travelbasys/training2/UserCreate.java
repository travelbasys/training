package de.travelbasys.training2;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * ist verantwortlich für die Frage nach dem Namen und dem Alter des Benutzters
 * und gibt diese nach System.out aus.
 * 
 * Wird mit einer Message aus der Klasse HelloWorldBusiness initialisiert. Jede
 * Instanz der Klasse wird gezählt; der Instanzenzähler kann abgefragt und von
 * außen verändert werden.
 * 
 * @author tba
 * 
 */

public class UserCreate {
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
	private Scanner in;
	private Scanner in2;

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

		in = new Scanner(System.in);
		username = in.nextLine();

		username = username.trim();

		if (username.isEmpty()) {
			err.println(bundle.getString("EmptyFieldErr"));
		} else {
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
			in2 = new Scanner(System.in);
			age = in2.nextInt();
		} catch (InputMismatchException e) {
			out.println(bundle.getString("AgeNumberErr"));
		}
		run3();
	}

	/**
	 * Gibt den aktuellen Namen und das Alter nach System.out aus.
	 */
	private void run3() {
		PrintStream out = System.out;
		out.println(message + " " + HelloWorldBusiness.getDate());
		run4();
	}

	/**
	 */
	private void run4() {
		User user;
		user = new User(username, age);
		UserDB.getUsers().add(user);
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
	}

}
