package de.travelbasys.training.dao.mysql;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.CustomerDaoException;
import de.travelbasys.training.db.MySqlConnection;

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
public class MySQLCustomerDAO {

	private static String FILE;
	private static String TABLE;
	private static List<Customer> internalCustomers;

	private static Connection connect = null;
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	private static int localupdateid = 0;

	// Der Konstruktor ist privat. Somit wird verhindert, dass eine Instanz
	// der Klasse erzeugt wird und dass der Konstruktor in der JavaDoc
	// erscheint.
	public MySQLCustomerDAO() {
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
		TABLE = "tb_customer";
		try {
			OpenConnection();
			statement = connect.createStatement();

			// Legt eine neue Tabelle in der Datenbank an, wenn diese nicht
			// vorhanden ist.
			// Da aktuell diese Tabelle in der Datenbank vorliegt, wird diese
			// Funktion nicht genutzt.
			// Es ist noch nicht exakt bedacht worden (Konzept) ob die Tabelle
			// von einem Admin angelegt werden muss, oder die Anwendung darüber
			// entscheidet.
			/*
			 * preparedStatement = connect .prepareStatement("CREATE TABLE " +
			 * TABLE +
			 * " (customerid INT NOT NULL AUTO_INCREMENT, lastname VARCHAR(30) NOT NULL, firstname VARCHAR(30), age INT NOT NULL, adress VARCHAR(30) , postalcode VARCHAR(30), email VARCHAR(30), updateid BIGINT UNSIGNED NOT NULL DEFAULT '0' ,PRIMARY KEY (customerid));"
			 * ); try { preparedStatement.executeUpdate(); } catch (Exception e)
			 * { }
			 */
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("SELECT * FROM " + TABLE + ";");
			internalCustomers = new ArrayList<Customer>();
			while (resultSet.next()) {
				Customer c = new Customer(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getInt(4), resultSet.getString(5),
						resultSet.getString(6), resultSet.getString(7));
				internalCustomers.add(c);
			}
		} catch (Exception e) {
		}
		CloseCurrentConnection();
	}

	private static void CloseCurrentConnection() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
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
		internalCustomers.clear();
		CloseCurrentConnection();
	}

	/**
	 * gibt eine Kopie der <tt>internalCustomers</tt> Liste die alle Datensätze
	 * der Datenbank enthält zurück.
	 * 
	 * @return Kopie der <tt>internalCustomers</tt> Liste
	 */
	public static List<Customer> findAll() {
		terminate();
		init(FILE);
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
		OpenConnection();
		getExisting(customer);
		try {
			statement = connect.createStatement();
			int customerid = 0;
			preparedStatement = connect.prepareStatement("INSERT INTO " + FILE
					+ "." + TABLE
					+ " VALUES (default, ?, ?, ?, ? , ?, ?, default);");
			preparedStatement.setString(1, customer.getLastName());
			preparedStatement.setString(2, customer.getFirstName());
			preparedStatement.setInt(3, customer.getAge());
			preparedStatement.setString(4, customer.getAdress());
			preparedStatement.setString(5, customer.getPostalcode());
			preparedStatement.setString(6, customer.getEmail());
			preparedStatement.executeUpdate();
			customerid = createNewId();
			Customer c = new Customer(customerid, customer.getLastName(),
					customer.getFirstName(), customer.getAge(),
					customer.getAdress(), customer.getPostalcode(),
					customer.getEmail());
			internalCustomers.add(c);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		CloseCurrentConnection();
	}

	private static int createNewId() {
		int id = 0;
		try {
			resultSet = statement.executeQuery("SELECT * FROM " + TABLE + ";");
			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			if (id != 0) {
				return id;
			} else
				return 1;
		} catch (SQLException e) {
			return 1;
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
		init(FILE);
		OpenConnection();
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM " + TABLE
					+ " WHERE customerid = " + id + ";");
			resultSet.next();
			localupdateid = resultSet.getInt(8);
		} catch (SQLException e) {
		}
		CloseCurrentConnection();
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
	public static void update(Customer customer) {
		OpenConnection();
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM " + TABLE
					+ " WHERE customerid = " + customer.getId() + ";");
			resultSet.next();
			if (resultSet.getRow() == 0) {
				System.err.println("Customer had been killed.");
				return;
			}
			if (resultSet.getInt(8) == localupdateid) {
				preparedStatement = connect
						.prepareStatement("UPDATE "
								+ TABLE
								+ " SET lastname = ?, firstname = ?, age = ?, adress = ?, postalcode = ?, email = ?, updateid = ? WHERE customerid = ?;");
				preparedStatement.setString(1, customer.getLastName());
				preparedStatement.setString(2, customer.getFirstName());
				preparedStatement.setInt(3, customer.getAge());
				preparedStatement.setString(4, customer.getAdress());
				preparedStatement.setString(5, customer.getPostalcode());
				preparedStatement.setString(6, customer.getEmail());
				preparedStatement.setInt(7, (resultSet.getInt(8) + 1));
				preparedStatement.setInt(8, customer.getId());
				preparedStatement.executeUpdate();
			} else {
				System.err.println("Customer has been changed another user.");
				CloseCurrentConnection();
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
	public static void delete(Customer customer) {
		int id = customer.getId();
		OpenConnection();
		for (Customer c : internalCustomers) {
			if (c.getId() == id) {
				try {
					preparedStatement = connect
							.prepareStatement("DELETE FROM tb_customer WHERE customerid = ? ;");
					preparedStatement.setInt(1, customer.getId());
					preparedStatement.executeUpdate();
					internalCustomers.remove(internalCustomers.indexOf(c));
				} catch (Exception e) {
					e.printStackTrace();
				}
				CloseCurrentConnection();
				return;
			}
		}
	}

	private static void OpenConnection() {
		connect = MySqlConnection.getNewInstance();
	}

	/**
	 * Diese Methode prüft ob ein Customer-Objekt bereits in der Datenbank
	 * vorhanden ist. Wenn das Customer-Objekt bereits vorhanden ist dann wird
	 * true zurückgegeben, wenn nicht false
	 * 
	 * @param customer
	 *            TODO: Besseren Namen finden!!!
	 * @throws CustomerDaoException
	 */
	public static Customer getExisting(Customer customer)
			throws CustomerDaoException {

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
	public static void importCSV(String name) throws IOException {
		MySQLCustomerDAO.terminate();
		// Import ersetzt aktuell nur die vorhandene CustomerListe, nicht jedoch
		// die Tabelle der Datenbank aus Sicherheitsgründen.
		// Implementierung von Import ist im Konzept (Umstellung auf MySQL) z.Z.
		// nicht berücksichtig.
		System.out.println("Hinweis: Ersetzt nur die lokale Liste.");

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
		fr.close();
	}

}
