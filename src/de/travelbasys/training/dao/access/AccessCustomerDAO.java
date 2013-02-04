package de.travelbasys.training.dao.access;

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
import de.travelbasys.training.dao.CustomerDAO;
import de.travelbasys.training.dao.CustomerDaoException;
import de.travelbasys.training.db.AccessConnection;

/**
 * Diese Klasse repr�sentiert eine "Datenbank" von {@see Customer} Objekten.
 * 
 * <p>
 * Sie stellt Operation zum
 * </p>
 * <ol>
 * <li>Erzeugen (Create)</li>
 * <li>Auslesen (Read)</li>
 * <li>Aktualisieren (Update)</li>
 * <li>L�schen (Delete)</li>
 * </ol>
 * <p>
 * von {@see Customer} Objekten bereit.
 * </p>
 * <p>
 * Damit besitzt sie den Standard CRUD Funktionsumfang f�r Datenbanken.
 * </p>
 * 
 */
public class AccessCustomerDAO implements CustomerDAO {

	private static String FILE;
	private static String TABLE;
	private static List<Customer> internalCustomers;

	private static Connection connect = null;
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	private static int localupdateid = 0;
	private final String INSERT = "INSERT INTO ";
	private final String VALUES = " VALUES (default, ?, ?, ?, ?, ?, ?, default);";
	private final String SELECT = "SELECT * FROM ";
	private final String WHERECUSTOMERID = " WHERE customerid = ";
	private final String UPDATEATTRIBUTES = " SET lastname = ?, firstname = ?, birthdate = ?, adress = ?, postalcode = ?, email = ?, updateid = ? WHERE customerid = ?;";
	private final String DELETE = "DELETE FROM ";
	private final String FIELDS = "(lastname, firstname, birthdate, adress, postalcode, email)";

	// Der Konstruktor ist privat. Somit wird verhindert, dass eine Instanz
	// der Klasse erzeugt wird und dass der Konstruktor in der JavaDoc
	// erscheint.
	public AccessCustomerDAO() {
	}

	/**
	 * initialisiert den internen Zustand von <tt>CustomerDao</tt>.
	 * 
	 * <p>
	 * Diese Implementierung benutzt eine Textdatei als Datenbank. Sie liest
	 * s�mtliche Datens�tze der Datenbank aus der Datei und speichert sie intern
	 * ab. Der Name der Datei wird als Parameter angegeben und ebenfalls
	 * gespeichert.
	 * </p>
	 * 
	 * <p>
	 * Beim Programmende muss die {@see #terminate()} Methode aufgerufen werden,
	 * um die Daten in die Datei zur�ckzuschreiben; sonst gehen sie verloren.
	 * 
	 * @param db
	 *            Name der Datenbank, momentan der Name der Textdatei, in dem
	 *            die Datens�tze gespeichert sind.
	 */
	public void init(String db) {
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
			// von einem Admin angelegt werden muss, oder die Anwendung dar�ber
			// entscheidet.
			/*
			 * preparedStatement = connect .prepareStatement("CREATE TABLE " +
			 * TABLE +
			 * " (customerid INT NOT NULL AUTO_INCREMENT, lastname VARCHAR(30) NOT NULL, firstname VARCHAR(30), age INT NOT NULL, adress VARCHAR(30) , postalcode VARCHAR(30), email VARCHAR(30), updateid BIGINT UNSIGNED NOT NULL DEFAULT '0' ,PRIMARY KEY (customerid));"
			 * ); try { preparedStatement.executeUpdate(); } catch (Exception e)
			 * { }
			 */
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery(SELECT + TABLE + ";");
			internalCustomers = new ArrayList<Customer>();
			while (resultSet.next()) {
				Customer c = new Customer(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getDate(4), resultSet.getString(5),
						resultSet.getString(6), resultSet.getString(7));
				internalCustomers.add(c);
			}
		} catch (Exception e) {
		}
		CloseCurrentConnection();
	}

	public void CloseCurrentConnection() {
		try {
			if (resultSet != null) {
				// resultSet.close();
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
	 * schreibt alle intern gespeicherten Datens�tze zur�ck in die Textdatei,
	 * aus der sie urspr�nglich stammen.
	 * 
	 * <p>
	 * Der Name der Textdatei ist derjenige, der von der {@see #init(String)}
	 * Methode gespeichert wurde.
	 * </p>
	 */
	public void terminate() {
		internalCustomers.clear();
		CloseCurrentConnection();
	}

	/**
	 * gibt eine Kopie der <tt>internalCustomers</tt> Liste die alle Datens�tze
	 * der Datenbank enth�lt zur�ck.
	 * 
	 * @return Kopie der <tt>internalCustomers</tt> Liste
	 */
	public List<Customer> findAll() {
		terminate();
		init(FILE);
		List<Customer> result = new ArrayList<Customer>();
		for (Customer customer : internalCustomers) {
			result.add(customer.clone());
		}
		return result;
	}

	/**
	 * F�gt den gegebenen <tt>Customer</tt> der Datenbank hinzu.
	 * 
	 * <p>
	 * Der <tt>Customer</tt> darf noch nicht in der Datenbank enthalten sein,
	 * was mittels der <tt>equals</tt> Methode �berpr�ft wird.
	 * </p>
	 * 
	 * @param customer
	 *            das <tt>Customer</tt> Objekt, welches der Datenbank
	 *            hinzugef�gt wird.
	 * @throws <tt>CustomerDaoException</tt> wenn das gegebene <tt>Customer</tt>
	 *         Objekt schon in der Datenbank vorhanden ist.
	 */
	public void create(Customer customer) throws CustomerDaoException {
		OpenConnection();
		getExisting(customer);
		try {
			statement = connect.createStatement();
			int customerid = 0;
			preparedStatement = connect.prepareStatement(INSERT + FILE + "."
					+ TABLE + FIELDS + VALUES);
			preparedStatement.setString(1, customer.getLastName());
			preparedStatement.setString(2, customer.getFirstName());
			preparedStatement.setDate(3, new java.sql.Date(customer
					.getBirthdate().getTime()));
			preparedStatement.setString(4, customer.getAdress());
			preparedStatement.setString(5, customer.getPostalcode());
			preparedStatement.setString(6, customer.getEmail());
			preparedStatement.executeUpdate();
			customerid = createNewId();
			Customer c = new Customer(customerid, customer.getLastName(),
					customer.getFirstName(), customer.getBirthdate(),
					customer.getAdress(), customer.getPostalcode(),
					customer.getEmail());
			internalCustomers.add(c);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		CloseCurrentConnection();
	}

	public int createNewId() {
		int id = 0;
		try {
			resultSet = statement.executeQuery(SELECT + TABLE + ";");
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
	 * <tt>id</tt> zur�ck.
	 * 
	 * @param id
	 *            die <tt>Id</tt>.
	 * @return Kopie des <tt>Customer</tt> Objekts mit der gegebenen <tt>id</tt>
	 *         oder <tt>null</tt>, wenn kein solches Objekt existiert.
	 */
	public Customer findById(int id) {
		init(FILE);
		OpenConnection();
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery(SELECT + FILE + "." + TABLE
					+ WHERECUSTOMERID + id + ";");
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
	 * �ndert die Attribute des gegebenen <tt>Customer</tt> der Datenbank.
	 * 
	 * <p>
	 * Der <tt>Customer</tt> darf noch nicht in der Datenbank enthalten sein,
	 * was mittels der <tt>equals</tt> Methode �berpr�ft wird.
	 * </p>
	 * 
	 * @param customer
	 *            das <tt>Customer</tt> Objekt, welches in der Datenbank
	 *            ge�ndert wird.
	 * @throws <tt>CustomerDaoException</tt> wenn das gegebene <tt>Customer</tt>
	 *         Objekt schon in der Datenbank vorhanden ist.
	 */
	public void update(Customer customer) {
		OpenConnection();
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery(SELECT + TABLE + WHERECUSTOMERID
					+ customer.getId() + ";");
			resultSet.next();
			if (resultSet.getRow() == 0) {
				System.err
						.println("Customer has been deleted by another user.");
				return;
			}
			if (resultSet.getInt(8) == localupdateid) {
				preparedStatement = connect.prepareStatement("UPDATE " + TABLE
						+ UPDATEATTRIBUTES);
				preparedStatement.setString(1, customer.getLastName());
				preparedStatement.setString(2, customer.getFirstName());
				preparedStatement.setDate(3, new java.sql.Date(customer
						.getBirthdate().getTime()));
				preparedStatement.setString(4, customer.getAdress());
				preparedStatement.setString(5, customer.getPostalcode());
				preparedStatement.setString(6, customer.getEmail());
				preparedStatement.setInt(7, (resultSet.getInt(8) + 1));
				preparedStatement.setInt(8, customer.getId());
				preparedStatement.executeUpdate();
			} else {
				System.err
						.println("Customer has been changed by another user.");
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
	 *         Objekt nicht gel�scht werden kann.
	 */
	public void delete(Customer customer) {
		int id = customer.getId();
		OpenConnection();
		for (Customer c : internalCustomers) {
			if (c.getId() == id) {
				try {
					preparedStatement = connect.prepareStatement(DELETE + TABLE
							+ WHERECUSTOMERID + "? ;");
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

	public void OpenConnection() {
		connect = AccessConnection.getInstance();
	}

	/**
	 * Diese Methode pr�ft ob ein Customer-Objekt bereits in der Datenbank
	 * vorhanden ist. Wenn das Customer-Objekt bereits vorhanden ist dann wird
	 * true zur�ckgegeben, wenn nicht false
	 * 
	 * @param customer
	 * 
	 * @throws CustomerDaoException
	 */

	// TODO: Besseren Namen finden!!!
	public Customer getExisting(Customer customer) throws CustomerDaoException {

		for (Customer c : internalCustomers) {
			if (c.equals(customer)) {
				throw new CustomerDaoException("ExistErr", c);
			}
		}
		return null;
	}

	/**
	 * Diese Methode ist daf�r verantwortlich, die alte Datenbank speichern und
	 * leeren zu lassen, um dann zeilenweise eine CSV Datei einzulesen und jedes
	 * geparste Customerobjekt durch die Methode {@see parseCSV} der internen
	 * Datenbank hinzuzuf�gen.
	 * 
	 * @param name
	 *            Name der Datei.
	 * @throws IOException
	 *             Dieser Fehler tritt auf, wenn die Datei nicht vorhanden oder
	 *             schreibgesch�tzt ist.
	 */
	public void importCSV(String name) throws IOException {
		terminate();
		// Import ersetzt aktuell nur die vorhandene CustomerListe, nicht jedoch
		// die Tabelle der Datenbank aus Sicherheitsgr�nden.
		// Implementierung von Import ist im Konzept (Umstellung auf MySQL) z.Z.
		// nicht ber�cksichtig.
		System.out.println("Hinweis: Ersetzt nur die lokale Liste.");

		FileReader fr = new FileReader(name);
		BufferedReader br = new BufferedReader(fr);

		// Erste Zeile �berspringen, in der die Spaltennamen stehen.
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
