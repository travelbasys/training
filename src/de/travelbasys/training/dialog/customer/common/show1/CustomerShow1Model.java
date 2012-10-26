package de.travelbasys.training.dialog.customer.common.show1;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Model;

/**
 * hat die Aufgabe, ein Model für den Show1 Dialog zu verwalten. Die aktuelle
 * Implementierung enthält ein Customer Objekt.
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