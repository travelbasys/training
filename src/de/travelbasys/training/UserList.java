package de.travelbasys.training;

import java.util.ArrayList;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;

/**
 * Diese Klasse ist für die wiedergabe der aktuellen Daten aus der
 * HelloWorld.txt zuständig
 * 
 * @author tba
 * 
 */
public class UserList {

	public static void run(String[] args) {
		// Datei wird eingelesen und gibt alle User Objekte der Datenbank aus.
		try {
			for (Customer user : CustomerDAO.getUsers()) {
				System.out.println(user);
			}
		} catch (NullPointerException e) {
			CustomerDAO.setUsers(new ArrayList<Customer>());
			run(args);
		}
	}

	public void init() {
		// TODO Mache irgendwas.

	}
}
