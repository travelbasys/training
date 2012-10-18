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
	private static CustomerUpdateModel model;
	private static CustomerUpdateView view;
	private static CustomerUpdateControl control;

	@Override
	public void run() {
		model = new CustomerUpdateModel();
		control = new CustomerUpdateControl(model);
		view = new CustomerUpdateView(model, control);

		view.run();
		view.updatemenu();

	}

	public static void setFirstname() {
		int customerid = model.getCustomerid();
		view.firstname();
		String firstname = model.getFirstname();
		CustomerDAO.setSingleUserFirstname(customerid, firstname);

	}

	public static void setLastname() {
		int customerid = model.getCustomerid();
		view.lastname();
		String lastname = model.getLastname();
		CustomerDAO.setSingleUserLastname(customerid, lastname);

	}

	public static void setAge() {
		int customerid = model.getCustomerid();
		view.age();
		int age = model.getAge();
		CustomerDAO.setSingleUserAge(customerid, age);

	}

	public static void setAdress() {
		int customerid = model.getCustomerid();
		view.adress();
		String adress = model.getAdress();
		CustomerDAO.setSingleUserAdress(customerid, adress);

	}

	public static void setPostalcode() {
		int customerid = model.getCustomerid();
		view.postalcode();
		String postalcode = model.getPostalcode();
		CustomerDAO.setSingleUserPostalcode(customerid, postalcode);

	}

	public static void setEmail() {
		int customerid = model.getCustomerid();
		view.email();
		String email = model.getEmail();
		CustomerDAO.setSingleUserEmail(customerid, email);

	}

	public static void end() {
		view.abort();
		return;

	}

}