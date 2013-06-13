package de.travelbasys.training.dialog.customer.create;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.CustomerDaoException;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.util.Datum;

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
		try {
			int dummyId = 0;
			// TODO: Implementierung des Geburtstag.
			Customer customer = new Customer(dummyId, model.getLastname(),
					model.getFirstname(), Datum.getFormattedDate(model
							.getBirthdate()), model.getAdress(),
					model.getPostalcode(), model.getEMail());
			Dao.getDAO().create(customer);
		} catch (CustomerDaoException e) {
			e.printcustomererr();
		}

	}

}
