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
				if (user.getLastName().equals(lastname) || user.getLastName().toLowerCase().equals(lastname) || user.getLastName().toUpperCase().equals(lastname)) {
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
			oos.writeObject(users);
			CustomerDAO.getUsers().removeAll(users);
			oos.close();
		} catch (Exception e) {
			setUsers(new ArrayList<Customer>());
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

	public static void setSingleUserFirstname(int customerid, String firstname) {
		try {
			for (Customer user : CustomerDAO.getUsers()) {
				if (user.getUserID() == customerid) {
					user.setFirstName(firstname);
				}
			}
		} catch (Exception e) {
		}
	}

	public static void setSingleUserEMail(int customerid, String email) {
		try {
			for (Customer user : CustomerDAO.getUsers()) {
				if (user.getUserID() == customerid) {
					user.setEMail(email);
				}
			}
		} catch (Exception e) {
		}
	}

	public static void setSingleUserLastname(int customerid, String lastname) {
		try {
			for (Customer user : CustomerDAO.getUsers()) {
				if (user.getUserID() == customerid) {
					user.setLastName(lastname);
				}
			}
		} catch (Exception e) {
		}
	}

	public static void setSingleUserAge(int customerid, int age) {
		try {
			for (Customer user : CustomerDAO.getUsers()) {
				if (user.getUserID() == customerid) {
					user.setAge(age);
				}
			}
		} catch (Exception e) {
		}
	}

	public static void setSingleUserAdress(int customerid, String adress) {
		try {
			for (Customer user : CustomerDAO.getUsers()) {
				if (user.getUserID() == customerid) {
					user.setAdress(adress);
				}
			}
		} catch (Exception e) {
		}
	}

	public static void setSingleUserPostalcode(int customerid, String postalcode) {
		try {
			for (Customer user : CustomerDAO.getUsers()) {
				if (user.getUserID() == customerid) {
					user.setPostalcode(postalcode);
				}
			}
		} catch (Exception e) {
		}
	}

	public static int getLastCustomerId() {
		int userid = 0;
		for (Customer user : getUsers()) {
			userid = user.getUserID();
		}
		return userid;
	}
}
