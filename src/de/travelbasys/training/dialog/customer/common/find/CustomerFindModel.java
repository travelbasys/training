package de.travelbasys.training.dialog.customer.common.find;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Model;

/**
 * hat die Aufgabe, ein Model für den Find-Dialog zu verwalten.
 */
public class CustomerFindModel implements Model {
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