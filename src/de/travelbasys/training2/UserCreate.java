package de.travelbasys.training2;

import java.util.ArrayList;
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
	 * 
	 * @param userid
	 *            Die eindeutige Identifikationsnummer des Benutzers.
	 * @param firstname
	 *            Der eingegebene Vorname
	 * @param lastname
	 *            Der eingegebene Nachname des Benutzers (Leer initialisiert).
	 * @param age
	 *            Das eingegebene Alter des Benutzers.
	 * @param adress
	 *            Die eingegebene Adresse des Benutzers.
	 * @param postalcode
	 *            Die eingegebene Postleitzahl des Benutzers.
	 * @param email
	 *            Die eingegebene e-Mail-Adresse des Benutzers.
	 **/
	public String lastname = "";
	private int userid;
	private String firstname = "";
	private String adress = "";
	private int postalcode = 0;
	private String email = "";
	private String message;
	private Scanner in = new Scanner(System.in);;
	private Scanner in2 = new Scanner(System.in);;

	/**
	 * Das eingegebene Alter des Benutzers. Wird mit 0 (=Null) initialisiert.
	 */
	public int age = 0;

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

		try {
			Output.println(bundle.getString("LastNamePrompt"));
		} catch (MissingResourceException e) {
			Output.err.println(e);
		}

		lastname = in.nextLine();

		lastname = lastname.trim();

		if (lastname.isEmpty()) {
			Output.err.println(bundle.getString("EmptyFieldErr"));
		} else {
			run2();
		}
	}

	public void run2() {

		try {
			Output.println(bundle.getString("FirstNamePrompt"));
		} catch (MissingResourceException e) {
			Output.err.println(e);
		}

		firstname = in.nextLine();

		firstname = firstname.trim();

		if (firstname.isEmpty()) {
			Output.err.println(bundle.getString("EmptyFieldErr"));
		} else {
			run3();
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
	private void run3() {
		try {
			Output.println(bundle.getString("AgePrompt"));
		} catch (MissingResourceException f) {
			System.err.println(f);
		}
		try {
			age = in2.nextInt();
		} catch (InputMismatchException e) {
			Output.err.println(bundle.getString("NumberErr"));
		}
		run4();
	}

	public void run4() {

		try {
			Output.println(bundle.getString("AdressPrompt"));
		} catch (MissingResourceException e) {
			Output.err.println(e);
		}

		adress = in.nextLine();

		adress = adress.trim();

		if (adress.isEmpty()) {
			Output.err.println(bundle.getString("EmptyFieldErr"));
		} else {
			run5();
		}
	}

	private void run5() {
		try {
			Output.println(bundle.getString("PostalPrompt"));
		} catch (MissingResourceException f) {
			System.err.println(f);
		}
		try {
			postalcode = in2.nextInt();
		} catch (InputMismatchException e) {
			Output.err.println(bundle.getString("NumberErr"));
		}
		run6();
	}

	public void run6() {

		try {
			Output.println(bundle.getString("eMailPrompt"));
		} catch (MissingResourceException e) {
			Output.err.println(e);
		}

		email = in.nextLine();

		email = email.trim();

		if (email.isEmpty()) {
			Output.err.println(bundle.getString("EmptyFieldErr"));
		} else {
			run7();
		}
	}

	/**
	 * Gibt den aktuellen Namen und das Alter nach System.out aus.
	 */
	private void run7() {
		Output.println(message + " " + HelloWorldBusiness.getDate());
		run8();
	}

	/**
	 */
	private void run8() {
		//UserID steht in Konflikt mit Löschen
		//Es wird die Liste zur Berechnung der Anzahl der neuen ID herangezogen
		//Wird ein Datensatz gelöscht bekommt der User die gleiche ID wie der letzte User
		//Es muss eine Wenn/Dann Bedingung eingeführt werden, dass wenn die letzte ID in der Liste
		//der UserID entspricht, die ID um eins erhöht wird.
		userid = 0;
		try {
			for (@SuppressWarnings("unused")
			User user : UserDB.getUsers()) {
				userid = userid +1;
			}
		} catch (NullPointerException e) {
			UserDB.setUsers(new ArrayList<User>());
			run8();
		}
		User user;
		user = new User(userid, lastname, firstname, age, adress, postalcode,
				email);
		try {
			UserDB.getUsers().add(user);
		} catch (NullPointerException e) {
			UserDB.setUsers(new ArrayList<User>());
			UserDB.getUsers().add(user);
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
	}

}
