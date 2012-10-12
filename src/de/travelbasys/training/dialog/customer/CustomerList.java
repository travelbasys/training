package de.travelbasys.training.dialog.customer;

import java.util.ArrayList;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.util.AppContext;

/**
 * Diese Klasse ist f�r die wiedergabe der aktuellen Daten aus der
 * Datenbank zust�ndig
 * 
 * @author tba
 * 
 */
public class CustomerList {

	public static void run() {
		// Datei wird eingelesen und gibt alle User Objekte der Datenbank aus.
		try {
			for (Customer user : CustomerDAO.getUsers()) {
				AppContext.println(user);
			}
		} catch (NullPointerException e) {
			CustomerDAO.setUsers(new ArrayList<Customer>());
			run();
		}
	}
}
