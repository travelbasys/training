package de.travelbasys.training.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.util.Config;

/**
 * Diese Klasse ist für die verarbeitung diverser Daten aus den Applikationen
 * verantwortlich.
 * 
 * @author tba
 * 
 */
public class CustomerDAO {

	private static String FILE;

	private static ResourceBundle bundle = Config.BUNDLE;

	private static List<Customer> users = null;
	private static List<Customer> found_customers = null;

	/**
	 * Finde einen User in der Datenbank mit dem gegebenen Namen.
	 * 
	 * @param lastname
	 *            der gegebene Name.
	 * @return ein User Objekt oder null, wenn nicht gefunden.
	 */
	public static List<Customer> findUserByLastName(String lastname) {

		setFoundCustomers(new ArrayList<Customer>());
		try {
			for (Customer user : CustomerDAO.getUsers()) {
				if (user.getLastName().equals(lastname)) {
					CustomerDAO.getCustomers().add(user);
				}
			}
			return CustomerDAO.getCustomers();
		} catch (NullPointerException e) {
			setUsers(new ArrayList<Customer>());
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
			List<Customer> user = (List<Customer>) ois.readObject();
			try {
				setUsers(new ArrayList<Customer>(user));
			} catch (NullPointerException e) {
				setUsers(new ArrayList<Customer>());
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
			CustomerDAO.getUsers().removeAll(users);
			oos.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static List<Customer> getUsers() {
		return users;
	}

	public static void delUser(int customerid) {
		try {
			for (Customer user : CustomerDAO.getUsers()) {
				if (user.getUserID() == customerid) {
					CustomerDAO.users.remove(user);
				}
			}
		} catch (Exception e) {
		}
	}

	public static void setUsers(List<Customer> users) {
		CustomerDAO.users = users;
	}

	public static void setFoundCustomers(List<Customer> found_customers) {
		CustomerDAO.found_customers = found_customers;
	}

	public static List<Customer> getCustomers() {
		return found_customers;
	}

	public static List<Customer> findUserByID(int customerid) {
		setFoundCustomers(new ArrayList<Customer>());
		try {
			for (Customer user : CustomerDAO.getUsers()) {
				if (user.getUserID() == customerid) {
					CustomerDAO.getCustomers().add(user);
				}
			}
			return CustomerDAO.getCustomers();
		} catch (NullPointerException e) {
			setUsers(new ArrayList<Customer>());
			findUserByID(customerid);
		}

		return null;
	}
}
