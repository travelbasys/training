package de.travelbasys.training.dao;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.util.AppContext;

@SuppressWarnings("serial")
public class CustomerDaoException extends Exception {

	private String error;
	private Customer customer;

	public CustomerDaoException(String string) {
		error = string;
	}

	public CustomerDaoException(String string, Customer customer) {
		error = string;
		this.customer = customer;
	}

	public void printcustomererr() {
		if (error != null && customer != null) {
			System.err.println(AppContext.getMessage(error) + "" + customer);
		} else {
			System.err.println(AppContext.getMessage("CriticalErr"));
		}
	}

	public void printcustomeriderr() {
		if (error != null && customer != null) {
			System.err.println(AppContext.getMessage(error) + ""
					+ customer.getId());
		} else {
			System.err.println(AppContext.getMessage("CriticalErr"));
		}
	}

	public void printerr() {
		System.err.println(AppContext.getMessage(error));
	}

}
