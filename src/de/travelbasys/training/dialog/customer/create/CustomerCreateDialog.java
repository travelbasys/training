package de.travelbasys.training.dialog.customer.create;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Console;

/**
 * ist verantwortlich für das erzeugen eines Customer Objekts, um dieses in eine
 * Datenbank zu speichern.
 * 
 */

public class CustomerCreateDialog implements Dialog {

	private CustomerCreateModel model;
	private CustomerCreateView view;
	@SuppressWarnings("unused")
	private CustomerCreateControl control;

	/**
	 * führt den Dialog aus.
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
					model.getFirstname(), model.getAge(), model.getAdress(),
					model.getPostalcode(), model.getEMail());
			if (CustomerDAO.checkExistenceOfCustomer(customer)) {
				Console.printerr(AppContext.getMessage("ExistErr")
						+ CustomerDAO.getExistentCustomer());
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		CustomerDAO.createCustomer(customer);

	}

}
