package de.travelbasys.training2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	 * @param lastname
	 *            der gegebene Name.
	 * @return ein User Objekt oder null, wenn nicht gefunden.
	 */
	public static User findUserByLastName(String lastname) {

		// Wenn gefunden...
		try{
		for (User user : UserDB.getUsers()) {
			if (user.getLastName().equals(lastname)) {
				return user;
			}
		}
		}catch(NullPointerException e){
			setUsers(new ArrayList<User>());
			findUserByLastName(lastname);
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
		FILE = db;
	       FileInputStream fis;
		try {
			fis = new FileInputStream(FILE);
	        ObjectInputStream ois = new ObjectInputStream(fis);

			@SuppressWarnings("unchecked")
			List<User> user = (List<User>) ois.readObject();
			try{
				setUsers(new ArrayList<User>(user));
			}catch(NullPointerException e){
				setUsers(new ArrayList<User>());
			}
	        ois.close();
		} catch (FileNotFoundException e1) {
			System.err.println(bundle.getString("FileNotFound"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void terminate() {
		
        FileOutputStream fos;
		try {
			fos = new FileOutputStream(FILE);
	        ObjectOutputStream oos = new ObjectOutputStream(fos);
	        oos.writeObject(users);
	        UserDB.getUsers().removeAll(users);
	        oos.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public static List<User> getUsers() {
		return users;
	}

	public static void delUser(String lastname) {
		try {
			for (User user : UserDB.getUsers()) {
				if (user.getLastName().equals(lastname)) {
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
