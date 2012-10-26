package de.travelbasys.training.dialog.customer.create;

import java.util.ArrayList;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.framework.Dialog;

/**
 * ist verantwortlich f�r das erzeugen eines Customer Objekts, um dieses in eine
 * Datenbank zu speichern.
 * 
 */

public class CustomerCreateDialog implements Dialog {

	private CustomerCreateModel model;
	private CustomerCreateView view;
	@SuppressWarnings("unused")
	private CustomerCreateControl control;
	
	/**
	 * f�hrt den Dialog aus.
	 */
	
	@Override
	public void run() {
		model = new CustomerCreateModel();
		view = new CustomerCreateView(model);
		control = new CustomerCreateControl(model, view);



		view.run();

		// Do something with the input!
		Customer customer = null;
		int customerid;

		customerid = CustomerDAO.getLastCustomerId() + 1;
		try {
			customer = new Customer(customerid, model.getLastname(),
					model.getFirstname(), model.getAge(),
					model.getAdress(), model.getPostalcode(),
					model.getEMail());
		} catch (Exception e) {
			e.printStackTrace();
			CustomerDAO.setCustomers(new ArrayList<Customer>());
		}
		CustomerDAO.getCustomers().add(customer);

	}

}
