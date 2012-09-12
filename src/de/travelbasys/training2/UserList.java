package de.travelbasys.training2;

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

		for (User user : UserDB.getUsers()) {
			System.out.println(user);
		}
	}

	public void init() {
		// TODO Mache irgendwas.

	}
}
