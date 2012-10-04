package de.travelbasys.training.dialog.customer;

import java.util.ArrayList;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.dialog.Dialog;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Datum;

/**
 * ist verantwortlich für den Dialog mit dem Benutzer, um alle Daten für ein
 * Customer Objekt abzufragen und das Objekt dann zu erzeugen.
 * 
 * @author tba
 */

public class CustomerCreate {

	private String lastname = "";
	private int userid = 0;
	private String firstname = "";
	private String adress = "";
	private String postalcode = "";
	private String email = "";
	private String message;
	private int age = 0;

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

}
