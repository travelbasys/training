package de.travelbasys.training.dialog.customer.common.show1;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Dialog;

/**
 * zeigt dem Benutzer ein gesuchtes Customer Objekt.
 */
public class CustomerShow1Dialog implements Dialog {
	private CustomerShow1Model model;
	private CustomerShow1View view;
	@SuppressWarnings("unused")
	private Customer customer;
	@SuppressWarnings("unused")
	private CustomerShow1Control control;

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
	 * @param customer 
	 */
	public CustomerShow1Dialog(Customer customer) {
		model = new CustomerShow1Model();
		control = new CustomerShow1Control();
		view = new CustomerShow1View(model);

		model.setCustomer(customer);
	}

}
