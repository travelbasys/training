package de.travelbasys.training.dao.text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.CustomerDAO;
import de.travelbasys.training.dao.CustomerDaoException;
import de.travelbasys.training.db.MDBConnection;

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
public class TxtCustomerDAO implements CustomerDAO {

	private static Connection importCon = null;
	private static String importAbsolutePath = null;
	private static Statement statement = null;
	private static ResultSet importResultSet = null;
	private static int localimportcounter = 0;
	private static String FILE;
	private static List<Customer> internalCustomers;
	private static List<String> tables;
	private final String SELECT = "SELECT * FROM ";

	private static Map<String, Object> internalDB;

	// Der Konstruktor ist privat. Somit wird verhindert, dass eine Instanz
	// der Klasse erzeugt wird und dass der Konstruktor in der JavaDoc
	// erscheint.
	public TxtCustomerDAO() {
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
	@Override
	public void init(String db) {
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
	@Override
	public void terminate() {

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
	@Override
	public List<Customer> findAll() {
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
	@Override
	public void create(Customer customer) throws CustomerDaoException {
		getExisting(customer);
		int customerid = createNewId();
		Customer c = new Customer(customerid, customer.getLastName(),
				customer.getFirstName(), customer.getBirthdate(),
				customer.getAdress(), customer.getPostalcode(),
				customer.getEmail());
		internalCustomers.add(c);
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
	@Override
	public Customer findById(int id) {
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
	@Override
	public void update(Customer customer) {
		int id = customer.getId();
		for (Customer c : internalCustomers) {
			if (c.getId() == id) {
				internalCustomers.set(internalCustomers.indexOf(c),
						customer.clone());
				return;
			}
		}
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
	@Override
	public void delete(Customer customer) {
		int id = customer.getId();
		for (Customer c : internalCustomers) {
			if (c.getId() == id) {
				internalCustomers.remove(internalCustomers.indexOf(c));
				return;
			}
		}
	}

	/**
	 * sucht in der internalDB nach der als letztes vergebenen Id, addiert diese
	 * mit 1 und gibt sie zurück.
	 * 
	 * @return id die schon um den wert 1 erhöhte id
	 */
	@Override
	public int createNewId() {
		try {
			int id = (Integer) internalDB.get("id") + 1;
			internalDB.put("id", id);
			return id;
		} catch (Exception e) {
			return 1;
		}
	}

	/**
	 * Diese Methode prüft ob ein Customer-Objekt bereits in der Datenbank
	 * vorhanden ist. Wenn das Customer-Objekt bereits vorhanden ist dann wird
	 * true zurückgegeben, wenn nicht false
	 * 
	 * @param customer
	 * 
	 * @throws CustomerDaoException
	 */
	// TODO: Besseren Namen finden!!!
	@Override
	public Customer getExisting(Customer customer) throws CustomerDaoException {

		for (Customer c : internalCustomers) {
			if (c.equals(customer)) {
				throw new CustomerDaoException("ExistErr", c);
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
	@Override
	public void importCSV(String name) throws IOException {
		// Alte Daten speichern.
		terminate();

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

	@Override
	public void CloseCurrentConnection() {
	}

	@Override
	public void OpenConnection() {
	}

	/**
	 * Diese Methode ist für das einlesen der Tabellennamen einer MDB-Datei
	 * (.mdb), anhand des Absoluten Pfads verantwortlich und
	 */
	@Override
	public void importMDB(String absolutePath) throws IOException,
			CustomerDaoException {
		importAbsolutePath = absolutePath;
		importCon = MDBConnection.getInstance(importAbsolutePath);
		tables = new ArrayList<String>();
		ResultSet res;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			DatabaseMetaData meta = importCon.getMetaData();
			res = meta.getTables(null, null, null, new String[] { "TABLE" });
			System.out.println("List of tables: ");
			while (res.next()) {
				String tableName = res.getString("TABLE_NAME");
				tables.add(tableName);
				System.out.println(tableName);
			}
			res.close();
			importCon.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
	}

	@Override
	public ObservableList<String> getSelectedImportMDBTables() {
		return FXCollections.observableArrayList(tables);
	}

	@Override
	public int getImportedCustomersNumber() {
		return localimportcounter;
	}

	@Override
	public ResultSet getImportResultSet() {
		return null;
	}

	/**
	 * Diese Methode ist verantwortlich für das einlesen von Customer Objekten
	 * in einer Tabelle aus einer MDB-Datei (.mdb) und fügt die noch nicht
	 * vorhandenen Customer Objekte zur Datenbank hinzu.
	 */
	@Override
	public void batchUpdateSelectedMDBTable(String table)
			throws CustomerDaoException {
		importCon = MDBConnection.getInstance(importAbsolutePath);
		localimportcounter = 0;
		try {
			statement = importCon.createStatement();
			importResultSet = statement.executeQuery(SELECT + table + ";");
			if (importResultSet.next()) {
				do {
					try {
						Customer c = new Customer(importResultSet.getInt(1),
								importResultSet.getString(2),
								importResultSet.getString(3),
								importResultSet.getDate(4),
								importResultSet.getString(5),
								importResultSet.getString(6),
								importResultSet.getString(7));
						create(c);
						localimportcounter++;
					} catch (CustomerDaoException e) {
						continue;
					}
				} while (importResultSet.next());
			} else {
				throw new CustomerDaoException("");
			}
			importResultSet.close();
			importCon.close();
		} catch (SQLException e) {
			System.err
					.println("Table not found. Please ask your local administrator for further information.");
		}
	}
}
