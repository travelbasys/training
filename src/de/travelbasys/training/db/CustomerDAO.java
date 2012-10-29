package de.travelbasys.training.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
	private static Customer customer1;

	/**
	 * Diese Methode liest alle Customer-Ojekte aus der Datenbank aus und
	 * schreibt diese in eine Temporäre Liste vom Typ Customer. Diese ist zur
	 * verwendung während der ganzen Laufzeit des Programms gedacht.
	 * 
	 * @param db (der Name der Datenbank)
	 */
	public static void init(String db) {
		FILE = db;
		FileInputStream fis;
		try {
			fis = new FileInputStream(FILE);
			ObjectInputStream ois = new ObjectInputStream(fis);

			@SuppressWarnings("unchecked")
			List<Customer> customer = (List<Customer>) ois.readObject();
			try {
				setCustomers(new ArrayList<Customer>(customer));
			} catch (NullPointerException e) {
				setCustomers(new ArrayList<Customer>());
			}
			ois.close();
		} catch (FileNotFoundException e1) {
			System.err.println("File not found");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Diese Methode Schreibt alle Customer-Daten aus der temporären Customer
	 * Liste in eine textbasierte Datenbank
	 * 
	 */

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

	/**
	 * Diese Methode erzeugt eine neue Liste vom typ Customer welche einen
	 * vorhandenen Customer enthält. Man erhält eine "Kopie" eines vorhandenen
	 * Customer-Objekts um diese beliebig zu ändern, ohne einträge in die
	 * Datenbank zu tätigen
	 * 
	 * @return ein temporärer Klon eines vorhandenen Customers
	 */
	public static List<Customer> getCustomersClone() {
		List<Customer> result = new ArrayList<Customer>();
		for (Customer customer : customers) {
			result.add(customer.clone());
		}
		return result;
	}

	public static List<Customer> getCustomers() {
		return customers;
	}

	/**
	 * Diese Methode löscht ein Customer-Objekt aus der Datenbank. Anhand einer
	 * customerid wird entschieden um welchen eintrag in der Datenbank es sich
	 * handelt.
	 * 
	 * @param customerid
	 *            (dieser Wert wird benötigt um bei verwendung dieser Methode
	 *            ein ergebnis zu erhalten)
	 */
	public static void delCustomer(int customerid) {
		try {
			for (Customer customer : CustomerDAO.getCustomers()) {
				if (customer.getId() == customerid) {
					CustomerDAO.customers.remove(customer);
				}
			}
		} catch (Exception e) {
		}
	}

	/**
	 * Diese Methode ändert einen Customer der sich in der Datenbank befindet,
	 * mit einem vorher festgelegtem Customer. Anhand der customerid wird
	 * entschieden welcher eintrag der Datenbank geändert werden soll, um
	 * anschließend die Daten anhand eines Customer-Objekts zu ändern.
	 * 
	 * @param customerid
	 * @param customer
	 */
	public static void replaceCustomer(int customerid, Customer customer) {
		try {
			for (Customer customer1 : CustomerDAO.getCustomersClone()) {
				if (customer1.getId() == customerid) {
					CustomerDAO.customers.set(
							CustomerDAO.customers.indexOf(customer1), customer);
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

	/**
	 * Diese Methode sucht einen Customer in der Datenbank anhand seiner
	 * customerid.
	 * 
	 * @param id
	 * @return eine Kopie dieses Customers wird anschließend zurückgegeben.
	 */
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

	/**
	 * Diese Methode sucht in der Datenbank nach dem letzten Customer und gibt
	 * dessen customerid zurück
	 * 
	 * @return
	 */
	public static int getLastCustomerId() {
		int customerid = 0;
		for (Customer customer : getCustomers()) {
			customerid = customer.getId();
		}
		return customerid;
	}

	/**
	 * Diese Methode prüft ob ein Customer-Objekt bereits in der Datenbank
	 * vorhanden ist. Wenn das Customer-Objekt bereits vorhanden ist dann wird
	 * true zurückgegeben, wenn nicht dann false
	 * 
	 * @param customer
	 */
	public static boolean checkExistenceOfCustomer(Customer customer) {

		for (Customer customertemp : CustomerDAO.getCustomers()) {
			if (customertemp.equals(customer)) {
				customer1 = customertemp;
				return true;
			}

		}
		return false;
	}

	public static Customer getExistentCustomer() {
		return customer1;
	}

}
