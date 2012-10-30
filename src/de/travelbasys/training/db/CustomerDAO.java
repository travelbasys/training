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
 * Diese Klasse repräsentiert eine "Datenbank" von {@see Customer} Objekten.
 * 
 * <p>
 * Sie stellt Operation zum
 * </p>
 * <ol>
 * <li>Erzeugen (Create)</li>
 * <li>Auslesen (Read)</li>
 * <li>Aktualisieren (Update)</li>
 * <li>Löschen (Delete)</li>
 * </ol>
 * <p>
 * von {@see Customer} Objekten bereit.
 * </p>
 * <p>
 * Damit besitzt sie den Standard CRUD Funktionsumfang für Datenbanken.
 * </p>
 */
public class CustomerDAO {

	private static String FILE;
	private static List<Customer> InternalCustomers = null;
	private static List<Customer> found_customers = null;
	private static Customer customer1;

	// Der Konstruktor ist privat. Somit wird verhindert, dass eine Instanz
	// der Klasse erzeugt wird und dass der Konstruktor in der JavaDoc
	// erscheint.
	private CustomerDAO() {
	}

	/**
	 * initialisiert den internen Zustand von <tt>CustomerDao</tt>.
	 * 
	 * <p>
	 * Diese Implementierung benutzt eine Textdatei als Datenbank. Sie liest
	 * sämtliche Datensätze der Datenbank aus der Datei und speichert sie intern
	 * ab. Der Name der Datei wird als Parameter angegeben und ebenfalls
	 * gespeichert.
	 * </p>
	 * 
	 * <p>
	 * Beim Programmende muss die {@see #terminate()} Methode aufgerufen werden,
	 * um die Daten in die Datei zurückzuschreiben; sonst gehen sie verloren.
	 * 
	 * @param db
	 *            Name der Datenbank, momentan der Name der Textdatei, in dem
	 *            die Datensätze gespeichert sind.
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
	 * schreibt alle intern gespeicherten Datensätze zurück in die Textdatei,
	 * aus der sie ursprünglich stammen.
	 * 
	 * <p>
	 * Der Name der Textdatei ist derjenige, der von der {@see #init(String)}
	 * Methode gespeichert wurde.
	 * </p>
	 */

	public static void terminate() {

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(FILE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(InternalCustomers);
			CustomerDAO.findAll().removeAll(InternalCustomers);
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
	public static List<Customer> findAll() {
		List<Customer> result = new ArrayList<Customer>();
		for (Customer customer : InternalCustomers) {
			result.add(customer.clone());
		}
		return result;
	}


	

	/**
	 * Diese Methode löscht ein Customer-Objekt aus der customers Liste. Anhand
	 * einer customerid wird entschieden um welchen eintrag in der Datenbank es
	 * sich handelt.
	 * 
	 * @param customerid
	 *            (dieser Wert wird benötigt um bei verwendung dieser Methode
	 *            ein ergebnis zu erhalten)
	 */
	public static void delCustomer(int customerid) {
		try {
			for (Customer customer : CustomerDAO.findAll()) {
				if (customer.getId() == customerid) {
					CustomerDAO.InternalCustomers.remove(customer);
				}
			}
		} catch (Exception e) {
		}
	}

	/**
	 * Diese Methode ändert einen Customer der sich in der customers Liste
	 * befindet. Mit einem vorher festgelegtem Customer, wird Anhand der
	 * customerid entschieden welcher eintrag der customers Liste geändert
	 * werden soll, um anschließend die Daten anhand eines Customer-Objekts zu
	 * ändern.
	 * 
	 * @param customerid
	 * @param customer
	 */
	public static void replaceCustomer(int customerid, Customer customer) {
		try {
			for (Customer customer1 : CustomerDAO.findAll()) {
				if (customer1.getId() == customerid) {
					CustomerDAO.InternalCustomers.set(
							CustomerDAO.InternalCustomers.indexOf(customer1),
							customer);
				}
			}
		} catch (Exception e) {
		}
	}

	private static void setCustomers(List<Customer> customers) {
		CustomerDAO.InternalCustomers = customers;
	}

	public static void setFoundCustomers(List<Customer> found_customers) {
		CustomerDAO.found_customers = found_customers;
	}

	public static List<Customer> getFoundCustomers() {
		return found_customers;
	}

	/**
	 * Diese Methode sucht einen Customer in der customers Liste anhand seiner
	 * customerid.
	 * 
	 * @param id
	 *            "PRIMARY KEY" (Die eindeutige Ziffer die den Customer
	 *            identifiziert)
	 * @return eine Kopie dieses Customers wird anschließend zurückgegeben.
	 */
	public static List<Customer> findCustomerById(int id) {
		setFoundCustomers(new ArrayList<Customer>());
		try {
			for (Customer customer : CustomerDAO.findAll()) {
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
	 * Diese Methode sucht in der Customers Liste nach dem letzten Customer und
	 * gibt dessen customerid zurück
	 * 
	 * @return customerid "PRIMARY KEY" (Die eindeutige Ziffer die den Customer
	 *         identifiziert)
	 */
	public static int getLastCustomerId() {
		int customerid = 0;
		for (Customer customer : findAll()) {
			customerid = customer.getId();
		}
		return customerid;
	}

	/**
	 * Diese Methode prüft ob ein Customer-Objekt bereits in der customers Liste
	 * vorhanden ist. Wenn das Customer-Objekt bereits vorhanden ist dann wird
	 * true zurückgegeben, wenn nicht dann false
	 * 
	 * @param customer
	 */
	public static boolean checkExistenceOfCustomer(Customer customer) {

		for (Customer customertemp : CustomerDAO.findAll()) {
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

	public static void createCustomer(Customer customer1) {
				InternalCustomers.add(customer1);
	}

	public static void DBrepair(){
		CustomerDAO.setCustomers(new ArrayList<Customer>());
	}
	
}
