package de.travelbasys.training.db;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * 
 * <p>
 * TODO: Behandlung von eindeutigen Id's und Verhalten beim Löschen.
 * </p>
 */
public class CustomerDAO {

	private static String FILE;
	private static List<Customer> internalCustomers;

	private static Map<String, Object> internalDB;

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
	@SuppressWarnings("unchecked")
	public static void init(String db) {
		FILE = db;
		FileInputStream fis;
		internalDB = null;
		try {
			fis = new FileInputStream(FILE);
			ObjectInputStream ois = new ObjectInputStream(fis);
			internalDB = (Map<String, Object>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e1) {
			System.err.println("File not found");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (internalDB == null) {
				internalDB = new HashMap<String, Object>();
				internalDB.put("id", 0);
				internalDB.put("customers", new ArrayList<Customer>());
			}
			internalCustomers = (List<Customer>) internalDB.get("customers");
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
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream(FILE);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(internalDB);
			internalCustomers.clear();
			internalDB.clear();

			oos.close();
		} catch (Exception e) {
		}
	}

	/**
	 * gibt eine Kopie der <tt>internalCustomers</tt> Liste die alle Datensätze
	 * der Datenbank enthält zurück.
	 * 
	 * @return Kopie der <tt>internalCustomers</tt> Liste
	 */
	public static List<Customer> findAll() {
		List<Customer> result = new ArrayList<Customer>();
		for (Customer customer : internalCustomers) {
			result.add(customer.clone());
		}
		return result;
	}

	/**
	 * Fügt den gegebenen <tt>Customer</tt> der Datenbank hinzu.
	 * 
	 * <p>
	 * Der <tt>Customer</tt> darf noch nicht in der Datenbank enthalten sein,
	 * was mittels der <tt>equals</tt> Methode überprüft wird.
	 * </p>
	 * 
	 * @param customer
	 *            das <tt>Customer</tt> Objekt, welches der Datenbank
	 *            hinzugefügt wird.
	 * @throws <tt>CustomerDaoException</tt> wenn das gegebene <tt>Customer</tt>
	 *         Objekt schon in der Datenbank vorhanden ist.
	 */
	public static void create(Customer customer) throws CustomerDaoException {
		if (getExisting(customer) != null) {
			// TODO: Welche Exception???
			throw new CustomerDaoException("...");
		} else {
			int customerid = CustomerDAO.createNewId();
			Customer c = new Customer(customerid, customer.getLastName(),
					customer.getFirstName(), customer.getAge(),
					customer.getAdress(), customer.getPostalcode(),
					customer.getEmail());
			internalCustomers.add(c);
		}
	}

	/**
	 * gibt eine Kopie des <tt>Customer</tt> Objekts mit der gegebenen
	 * <tt>id</tt> zurück.
	 * 
	 * @param id
	 *            die <tt>Id</tt>.
	 * @return Kopie des <tt>Customer</tt> Objekts mit der gegebenen <tt>id</tt>
	 *         oder <tt>null</tt>, wenn kein solches Objekt existiert.
	 */
	public static Customer findById(int id) {
		for (Customer customer : internalCustomers) {
			if (customer.getId() == id) {
				return customer.clone();
			}
		}
		return null;
	}

	/**
	 * Ändert die Attribute des gegebenen <tt>Customer</tt> der Datenbank.
	 * 
	 * <p>
	 * Der <tt>Customer</tt> darf noch nicht in der Datenbank enthalten sein,
	 * was mittels der <tt>equals</tt> Methode überprüft wird.
	 * </p>
	 * 
	 * @param customer
	 *            das <tt>Customer</tt> Objekt, welches in der Datenbank
	 *            geändert wird.
	 * @throws <tt>CustomerDaoException</tt> wenn das gegebene <tt>Customer</tt>
	 *         Objekt schon in der Datenbank vorhanden ist.
	 */
	public static void update(Customer customer) throws CustomerDaoException {
		int id = customer.getId();
		for (Customer c : internalCustomers) {
			if (c.getId() == id) {
				internalCustomers.set(internalCustomers.indexOf(c),
						customer.clone());
				return;
			}
		}
		throw new CustomerDaoException("...");
	}

	/**
	 * Entfernt den gegebenen <tt>Customer</tt> aus der Datenbank.
	 * 
	 * @param customer
	 *            das <tt>Customer</tt> Objekt, welches aus der Datenbank
	 *            entfernt wird.
	 * @throws <tt>CustomerDaoException</tt> wenn das gegebene <tt>Customer</tt>
	 *         Objekt nicht gelöscht werden kann.
	 */
	public static void delete(Customer customer) throws CustomerDaoException {
		int id = customer.getId();
		for (Customer c : internalCustomers) {
			if (c.getId() == id) {
				internalCustomers.remove(internalCustomers.indexOf(c));
				return;
			}
		}
		throw new CustomerDaoException("...");
	}

	/**
	 * sucht in der internalDB nach der als letztes vergebenen Id, addiert diese
	 * mit 1 und gibt sie zurück.
	 * 
	 * @return id die schon um den wert 1 erhöhte id
	 */
	private static int createNewId() {
		int id = (Integer) internalDB.get("id") + 1;
		internalDB.put("id", id);
		return id;
	}

	/**
	 * Diese Methode prüft ob ein Customer-Objekt bereits in der Datenbank
	 * vorhanden ist. Wenn das Customer-Objekt bereits vorhanden ist dann wird
	 * true zurückgegeben, wenn nicht false
	 * 
	 * @param customer
	 *            TODO: Besseren Namen finden!!!
	 */
	public static Customer getExisting(Customer customer) {

		for (Customer c : internalCustomers) {
			if (c.equals(customer)) {
				return c;
			}
		}
		return null;
	}

	/**
	 * Diese Methode ist dafür verantwortlich, die alte Datenbank speichern und
	 * leeren zu lassen, um dann zeilenweise eine CSV Datei einzulesen und jedes
	 * geparste Customerobjekt durch die Methode {@see parseCSV} der internen
	 * Datenbank hinzuzufügen.
	 * 
	 * @param name
	 *            Name der Datei.
	 * @throws IOException
	 *             Dieser Fehler tritt auf, wenn die Datei nicht vorhanden oder
	 *             schreibgeschützt ist.
	 */
	public static void importCSV(String name) throws IOException {
		// Alte Daten speichern.
		CustomerDAO.terminate();

		internalDB.put("customers", internalCustomers);

		FileReader fr = new FileReader(name);
		BufferedReader br = new BufferedReader(fr);

		// Erste Zeile überspringen, in der die Spaltennamen stehen.
		br.readLine();
		String s;
		while ((s = br.readLine()) != null) {
			internalCustomers.add(Customer.parseCSV(s));
		}

		int id = 0;
		for (Customer customer : internalCustomers) {
			if (customer.getId() > id) {
				id = customer.getId();
			}
		}
		internalDB.put("id", id);
		fr.close();
	}

}
