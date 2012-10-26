package de.travelbasys.training.dialog.customer.list;

import java.util.ArrayList;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.util.AppContext;

/**
 * Diese Klasse ist für die wiedergabe der aktuellen Daten aus der
 * Datenbank zuständig
 * 
 * @author tba
 * 
 */
public class CustomerList implements Dialog {

	public void run() {
		// Datei wird eingelesen und gibt alle User Objekte der Datenbank aus.
		try {
			for (Customer user : CustomerDAO.getCustomers()) {
				AppContext.println(user);
			}
		} catch (NullPointerException e) {
			CustomerDAO.setCustomers(new ArrayList<Customer>());
			run();
		}
	}
}
