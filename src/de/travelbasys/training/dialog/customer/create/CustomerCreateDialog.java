package de.travelbasys.training.dialog.customer.create;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.db.CustomerDaoException;
import de.travelbasys.training.framework.Dialog;

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
		try {
			int dummyId = 0;
			Customer customer = new Customer(dummyId, model.getLastname(),
					model.getFirstname(), model.getAge(), model.getAdress(),
					model.getPostalcode(), model.getEMail());
			CustomerDAO.create(customer);
		} catch (CustomerDaoException e) {
			e.printcustomererr();
		}

	}

}
