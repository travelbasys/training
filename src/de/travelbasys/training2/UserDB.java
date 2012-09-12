package de.travelbasys.training2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Diese Klasse ist für die verarbeitung diverser Daten aus den Applikationen
 * verantwortlich.
 * 
 * @author tba
 * 
 */
public class UserDB {

	private static String FILE;

	private static String baseName = "resources.HelloWorld";
	static ResourceBundle bundle = ResourceBundle.getBundle(baseName);

	private static List<User> users = null;

	/**
	 * Finde einen User in der Datenbank mit dem gegebenen Namen.
	 * 
	 * @param username
	 *            der gegebene Name.
	 * @return ein User Objekt oder null, wenn nicht gefunden.
	 */
	public static User findUserByName(String username) {

		// Wenn gefunden...
		for (User user : UserDB.getUsers()) {
			if (user.getName().equals(username)) {
				return user;
			}
		}
		return null;
	}

	/**
	 * Überspringe den User in der Datenbank, dessen Namen mit dem Namen des
	 * gegebenen User Objekts übereinstimmt. Lösche dann die Datenbank und lege
	 * sie neu an in die der übersprungene User nicht gespeichert wird.
	 * 
	 * @param db
	 * 
	 * @param user
	 *            ein User Objekt.
	 */
	public static void init(String db) {

		setUsers(new ArrayList<User>());
		try {
			FileReader fr = new FileReader(db);
			BufferedReader br = new BufferedReader(fr);
			String s;
			while ((s = br.readLine()) != null) {
				User user = User.parse(s);
				getUsers().add(user);
			}
			fr.close();
		} catch (FileNotFoundException e) {
			System.err.println(bundle.getString("FileNotFound"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void terminate() {
		try {
			if (FILE.isEmpty()) {
				return;
			}
			FileWriter fw = new FileWriter(FILE);
			PrintWriter pw = new PrintWriter(fw);

			for (User user : getUsers()) {
				pw.println(user);
			}
			pw.close();

		} catch (Exception e) {

		}
	}

	public static List<User> getUsers() {
		return users;
	}

	public static void delUser(String username) {
		try {
			for (User user : UserDB.getUsers()) {
				if (user.getName().equals(username)) {
					UserDB.users.remove(user);
				}
			}
		} catch (Exception e) {
		}
	}

	public static void setUsers(List<User> users) {
		UserDB.users = users;
	}

}
