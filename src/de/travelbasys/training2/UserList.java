package de.travelbasys.training2;

import java.util.ArrayList;

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
			for (User user : UserDB.getUsers()) {
				System.out.println(user);
			}
		} catch (NullPointerException e) {
			UserDB.setUsers(new ArrayList<User>());
			run(args);
		}
	}

	public void init() {
		// TODO Mache irgendwas.

	}
}
