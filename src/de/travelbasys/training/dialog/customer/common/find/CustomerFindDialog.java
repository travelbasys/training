package de.travelbasys.training.dialog.customer.common.find;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Dialog;

/**
 * ist verantwortlich f�r die Suche eines Customers aus der Datenbank.
 * 
 */
public class CustomerFindDialog implements Dialog {
	private CustomerFindModel model;
	private CustomerFindView view;
	@SuppressWarnings("unused")
	private CustomerFindControl control;

	/**
	 * Initalisiert die MVC-Komponenten des Find-Dialoges.
	 * 
	 */
	public CustomerFindDialog() {
		model = new CustomerFindModel();
		view = new CustomerFindView(model);
		control = new CustomerFindControl(model, view);

	}

	/**
	 * F�hrt den initalisierten View aus.
	 */
	@Override
	public void run() {
		view.run();
	}

	/**
	 * Holt den gefundenen Customer aus dem Model.
	 * 
	 * @return Das gefundene Objekt.
	 */
	public Customer getCustomer() {
		return model.getCustomer();
	}

	/**
	 * Holt die gefundene CustomerID aus dem Model.
	 * 
	 * @return Die gefundene ID.
	 */
	public int getCustomerID() {
		return model.getCustomerId();
	}
}
