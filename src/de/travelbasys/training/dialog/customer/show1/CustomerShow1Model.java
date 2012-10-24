package de.travelbasys.training.dialog.customer.show1;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Model;

/**
 * Model Objekt für den CustomerShow1 Dialog.
 */
public class CustomerShow1Model implements Model {
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}