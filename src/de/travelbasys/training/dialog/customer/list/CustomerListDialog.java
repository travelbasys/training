package de.travelbasys.training.dialog.customer.list;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.util.AppContext;

/**
 * Diese Klasse ist für die wiedergabe der aktuellen Daten aus der Datenbank
 * zuständig
 * 
 * @author tba
 * 
 */
public class CustomerListDialog implements Dialog {

	public void run() {
		for (Customer customer : Dao.getDAO().findAll()) {
			AppContext.println(customer);
		}
	}
}
