package de.travelbasys.training.dialog.customer.update;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.dialog.customer.find.CustomerFindDialog;
import de.travelbasys.training.dialog.customer.showandchange.ShowAndChangeDialog;
import de.travelbasys.training.dialog.customer.yesno.YesNoDialog;
import de.travelbasys.training.framework.Dialog;

/**
 * 
 */
public class CustomerUpdateDialog implements Dialog {
	private String firstname;
	private String lastname;
	private int age;
	private String adress;
	private String postalcode;
	private String email;

	@Override
	public void run() {
		final String key = "SaveQ";

		CustomerFindDialog d1 = new CustomerFindDialog();
		d1.init();
		d1.run();

		Customer customer = d1.getCustomer();
		if (customer == null) {
			return;
		}
		ShowAndChangeDialog d2 = new ShowAndChangeDialog();
		d2.setCustomer(customer);
		d2.init();
		d2.run();

		YesNoDialog d3 = new YesNoDialog();
		d3.init(key);
		d3.run();

		if (d3.getFlag() == true) {
			int customerid = customer.getUserID();
			firstname = d2.getCustomerFirstname();
			lastname = d2.getCustomerLastname();
			age = d2.getCustomerAge();
			adress = d2.getCustomerAdress();
			postalcode = d2.getCustomerPostalcode();
			email = d2.getCustomerEMail();
			CustomerDAO.setSingleUserLastname(customerid, lastname);
			CustomerDAO.setSingleUserFirstname(customerid, firstname);
			CustomerDAO.setSingleUserAge(customerid, age);
			CustomerDAO.setSingleUserAdress(customerid, adress);
			CustomerDAO.setSingleUserPostalcode(customerid, postalcode);
			CustomerDAO.setSingleUserEMail(customerid, email);
		}
	}
}
