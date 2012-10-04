package de.travelbasys.training.dialog.customer;

import java.util.ArrayList;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.dialog.Dialog;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Datum;

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

public class CustomerCreate {

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
	private String lastname = "";
	private int userid = 0;
	private String firstname = "";
	private String adress = "";
	private String postalcode = "";
	private String email = "";
	private String message;
	private int age = 0;

	/**
	 * Das eingegebene Alter des Benutzers. Wird mit 0 (=Null) initialisiert.
	 */

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
		lastname = Dialog.getString("LastNamePrompt");
		lastname.trim();
		if (lastname.isEmpty()) {
			AppContext.getErrString("EmptyFieldErr");
		} else {
			run2();
		}
	}

	private void run2() {
		firstname = Dialog.getString("FirstNamePrompt");
		firstname.trim();
		if (firstname.isEmpty()) {
			AppContext.getErrString("EmptyFieldErr");

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
		age = Dialog.getInt("AgePrompt");
		if (age > 0) {
			run4();
		} else {
			AppContext.getErrString("NumberNotInRangeErr");
		}
	}

	private void run4() {
		adress = Dialog.getString("AdressPrompt");
		adress.trim();
		if (adress.isEmpty()) {
			AppContext.getErrString("EmptyFieldErr");
		} else {
			run5();
		}
	}

	private void run5() {
		postalcode = Dialog.getString("PostalPrompt");
		postalcode.trim();
		if (postalcode.isEmpty())
			AppContext.getErrString("EmptyFieldErr");
		else {
			run6();
		}
	}

	private void run6() {
		email = Dialog.getString("eMailPrompt");
		email.trim();
		if (email.isEmpty()) {
			AppContext.getErrString("EmptyFieldErr");
		} else {
			run7();
		}
	}

	/**
	 * Gibt den aktuellen Namen und das Alter nach System.out aus.
	 */
	private void run7() {
		AppContext.println(message + " " + Datum.getDate());
		run8();
	}

	/**
	 */
	private void run8() {
		userid = 0;
		try {
			for (Customer user : CustomerDAO.getUsers()) {
				userid = user.getUserID();
			}
			userid++;
			Customer user;
			user = new Customer(userid, lastname, firstname, age, adress,
					postalcode, email);
			CustomerDAO.getUsers().add(user);
		} catch (NullPointerException e) {
			CustomerDAO.setUsers(new ArrayList<Customer>());
			run8();
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
	public void init(Datum b) {
		message = b.getMessage();
	}

}
