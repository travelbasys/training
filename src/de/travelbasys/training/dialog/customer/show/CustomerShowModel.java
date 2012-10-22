package de.travelbasys.training.dialog.customer.show;

import de.travelbasys.training.business.Customer;

/**
 * Model Objekt für den CustomerShow Dialog.
 */
public class CustomerShowModel implements Model {
	private Customer customer;
	private int customerId;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}