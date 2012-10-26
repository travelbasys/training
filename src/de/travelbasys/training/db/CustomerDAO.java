package de.travelbasys.training.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import de.travelbasys.training.business.Customer;

/**
 * Diese Klasse ist für die verarbeitung diverser Daten aus den Applikationen
 * verantwortlich.
 * 
 * @author tba
 * 
 */
public class CustomerDAO {

	private static String FILE;
	private static List<Customer> customers = null;
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
			for (Customer user : CustomerDAO.getCustomers()) {
				if (user.getLastName().equals(lastname)
						|| user.getLastName().toLowerCase().equals(lastname)
						|| user.getLastName().toUpperCase().equals(lastname)) {
					CustomerDAO.getFoundCustomers().add(user);
				}
			}
			return CustomerDAO.getFoundCustomers();
		} catch (NullPointerException e) {
			setCustomers(new ArrayList<Customer>());
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
				setCustomers(new ArrayList<Customer>(user));
			} catch (NullPointerException e) {
				setCustomers(new ArrayList<Customer>());
			}
			ois.close();
		} catch (FileNotFoundException e1) {
			System.err.println("File not found");
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
			oos.writeObject(customers);
			CustomerDAO.getCustomers().removeAll(customers);
			oos.close();
		} catch (Exception e) {
			setCustomers(new ArrayList<Customer>());
		}

	}

	public static List<Customer> getCustomers() {
		List<Customer> result = new ArrayList<Customer>();
		for (Customer customer : customers) {
			result.add(customer.clone());
		}
		return result;
	}

	public static void delUser(int customerid) {
		try {
			for (Customer user : CustomerDAO.getCustomers()) {
				if (user.getId() == customerid) {
					CustomerDAO.customers.remove(user);
				}
			}
		} catch (Exception e) {
		}
	}

	public static void replaceUser(int customerid, Customer customer) {
		try {
			for (Customer user : CustomerDAO.getCustomers()) {
				if (user.getId() == customerid) {
					CustomerDAO.customers.set(CustomerDAO.customers.indexOf(user),
							customer);
				}
			}
		} catch (Exception e) {
		}
	}

	public static void setCustomers(List<Customer> customers) {
		CustomerDAO.customers = customers;
	}

	public static void setFoundCustomers(List<Customer> found_customers) {
		CustomerDAO.found_customers = found_customers;
	}

	public static List<Customer> getFoundCustomers() {
		return found_customers;
	}

	public static List<Customer> findCustomerById(int id) {
		setFoundCustomers(new ArrayList<Customer>());
		try {
			for (Customer customer : CustomerDAO.getCustomers()) {
				if (customer.getId() == id) {

					CustomerDAO.getFoundCustomers().add(customer.clone());
				}
			}
			return CustomerDAO.getFoundCustomers();
		} catch (NullPointerException e) {
			setCustomers(new ArrayList<Customer>());
			findCustomerById(id);
		}

		return null;
	}

	public static int getLastCustomerId() {
		int userid = 0;
		for (Customer user : getCustomers()) {
			userid = user.getId();
		}
		return userid;
	}
	
}
