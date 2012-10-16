package de.travelbasys.training.dialog.customer.Update;

import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.dialog.Dialog;

/**
 * Diese Klasse ist für das ändern der vorhandenen Daten eines Customer Objekts
 * verantwortlich.
 * 
 * @author tba
 * 
 */

public class CustomerUpdateDialog implements Dialog {
	private CustomerUpdateModel model;
	private CustomerUpdateView view;
	private static CustomerUpdateControl control;

	@Override
	public void run() {
		model = new CustomerUpdateModel();
		control = new CustomerUpdateControl(model, view);
		view = new CustomerUpdateView(model, control);

		view.run();

	}

	public static void setFirstname(int customerid, String firstname) {
		CustomerDAO.setSingleUserFirstname(customerid, firstname);
		
	}

	public static void setLastname(int customerid, String lastname) {
		CustomerDAO.setSingleUserLastname(customerid, lastname);

	}

	public static void setAge(int customerid, int age) {
		CustomerDAO.setSingleUserAge(customerid, age);

	}

	public static void setAdress(int customerid, String adress) {
		CustomerDAO.setSingleUserAdress(customerid, adress);

	}

	public static void setPostalcode(int customerid, String postalcode) {
		CustomerDAO.setSingleUserPostalcode(customerid, postalcode);
	
	}

	public static void setEmail(int customerid, String email) {
		CustomerDAO.setSingleUserEmail(customerid, email);

	}

	public static boolean end() {
		return false;
		
	}

}