package de.travelbasys.training2;

/**
 * Diese Klasse ist f�r die wiedergabe der aktuellen Daten aus der
 * HelloWorld.txt zust�ndig
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
