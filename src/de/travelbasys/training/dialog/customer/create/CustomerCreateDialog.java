package de.travelbasys.training.dialog.customer.create;

import java.util.ArrayList;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.framework.Dialog;

/**
 * ist verantwortlich für das erzeugen eines Customer Objekts, um dieses in eine
 * Datenbank zu speichern.
 * 
 */

public class CustomerCreateDialog implements Dialog {

	private CustomerCreateModel model;
	private CustomerCreateView view;
	private CustomerCreateControl control;
	
	/**
	 * führt den Dialog aus.
	 */
	
	@Override
	public void run() {
		model = new CustomerCreateModel();
		control = new CustomerCreateControl();
		view = new CustomerCreateView();

		view.init(model);
		control.init(model, view);

		view.run();

		// Do something with the input!
		Customer customer = null;
		int customerid;

		customerid = CustomerDAO.getLastCustomerId() + 1;
		try {
			customer = new Customer(customerid, model.getCustomerLastname(),
					model.getCustomerFirstname(), model.getCustomerAge(),
					model.getCustomerAdress(), model.getCustomerPostalcode(),
					model.getCustomerEMail());
		} catch (Exception e) {
			e.printStackTrace();
			CustomerDAO.setUsers(new ArrayList<Customer>());
		}
		CustomerDAO.getUsers().add(customer);

	}

}
