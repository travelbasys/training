package de.travelbasys.training.dialog.customer;

import java.util.ArrayList;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.util.Console;

/**
 * Diese Klasse ist für die wiedergabe der aktuellen Daten aus der
 * HelloWorld.txt zuständig
 * 
 * @author tba
 * 
 */
public class CustomerList {

	public static void run() {
		// Datei wird eingelesen und gibt alle User Objekte der Datenbank aus.
		try {
			for (Customer user : CustomerDAO.getUsers()) {
				Console.println(user);
			}
		} catch (NullPointerException e) {
			CustomerDAO.setUsers(new ArrayList<Customer>());
			run();
		}
	}
}
