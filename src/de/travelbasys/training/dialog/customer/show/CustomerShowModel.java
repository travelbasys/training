package de.travelbasys.training.dialog.customer.show;

import java.util.ArrayList;

import de.travelbasys.training.business.Customer;

/**
 * erzeugt eine Instanz der Klasse CustomerShowDialog und verwaltet Daten
 * 
 * @author
 */
@SuppressWarnings("serial")
public class CustomerShowModel extends ArrayList<String> {
	private int customerId;
	private Customer customer;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}