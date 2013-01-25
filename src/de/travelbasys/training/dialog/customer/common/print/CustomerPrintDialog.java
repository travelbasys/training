package de.travelbasys.training.dialog.customer.common.print;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Dialog;

/**
 * zeigt dem Benutzer ein gesuchtes Customer Objekt.
 */
public class CustomerPrintDialog implements Dialog {
	private CustomerPrintModel model;
	private CustomerPrintView view;
	@SuppressWarnings("unused")
	private Customer customer;
	@SuppressWarnings("unused")
	private CustomerPrintControl control;

	/**
	 * führt den Dialog aus.
	 */
	@Override
	public void run() {
		view.run();
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Erzeugt interne Model, View und Control Instanzen und initialisiert
	 * diese. Das Model erhält bei der Initialisierung Werte eines Customer
	 * Objekts.
	 * 
	 * @param customer
	 */
	public CustomerPrintDialog(Customer customer) {
		model = new CustomerPrintModel();
		control = new CustomerPrintControl();
		view = new CustomerPrintView(model);

		model.setCustomer(customer);
	}

}
