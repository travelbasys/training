package de.travelbasys.training.dao.mysql;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.CustomerDaoException;

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
 * <p>
 * TODO: Behandlung von eindeutigen Id's und Verhalten beim L�schen.
 * </p>
 */
public class MySqlCustomerDAO {

	private static String FILE;
	private static String TABLE;
	private static List<Customer> internalCustomers;

	private static Connection connect = null;
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	// Der Konstruktor ist privat. Somit wird verhindert, dass eine Instanz
	// der Klasse erzeugt wird und dass der Konstruktor in der JavaDoc
	// erscheint.
	private MySqlCustomerDAO() {
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
	public static void init(String db) {
		FILE = db;
		TABLE = "tb_customer";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost:8080/" + db + "?"
							+ "user=sqluser&password=sqluserpw");
			statement = connect.createStatement();
			preparedStatement = connect
					.prepareStatement("CREATE TABLE "
							+ TABLE
							+ " (customerid INT NOT NULL AUTO_INCREMENT, lastname VARCHAR(30) NOT NULL, firstname VARCHAR(30), age INT NOT NULL, adress VARCHAR(30) , postalcode VARCHAR(30), email VARCHAR(30),PRIMARY KEY (customerid));");
			try {
				preparedStatement.executeUpdate();
			} catch (Exception e) {
			}
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select * from " + db + "."
					+ TABLE);
			internalCustomers = new ArrayList<Customer>();
			while (resultSet.next()) {
				Customer c = new Customer(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getInt(4), resultSet.getString(5),
						resultSet.getString(6), resultSet.getString(7));
				System.out.println(c);
				internalCustomers.add(c);
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
	public static void terminate() {
		internalCustomers.clear();
	}

	/**
	 * gibt eine Kopie der <tt>internalCustomers</tt> Liste die alle Datens�tze
	 * der Datenbank enth�lt zur�ck.
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
	public static void create(Customer customer) throws CustomerDaoException {
		getExisting(customer);
		try {
			int customerid = 0;
			preparedStatement = connect.prepareStatement("INSERT INTO " + FILE
					+ "." + TABLE + " VALUES (default, ?, ?, ?, ? , ?, ?);");
			preparedStatement.setString(1, customer.getLastName());
			preparedStatement.setString(2, customer.getFirstName());
			preparedStatement.setInt(3, customer.getAge());
			preparedStatement.setString(4, customer.getAdress());
			preparedStatement.setString(5, customer.getPostalcode());
			preparedStatement.setString(6, customer.getEmail());
			preparedStatement.executeUpdate();
			// Neu �ber ResultSet iterieren??
			customerid = createNewId();
			Customer c = new Customer(customerid, customer.getLastName(),
					customer.getFirstName(), customer.getAge(),
					customer.getAdress(), customer.getPostalcode(),
					customer.getEmail());
			internalCustomers.add(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static int createNewId() {
		try {
			resultSet.beforeFirst();
			int id = 0;
			while (resultSet.next()) {
				id = resultSet.getInt(1) + 1;
			}
			return id;
		} catch (Exception e) {
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
	public static Customer findById(int id) {
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
	public static void update(Customer customer) {
		int id = customer.getId();
		for (Customer c : internalCustomers) {
			if (c.getId() == id) {
				try {
					preparedStatement = connect
							.prepareStatement("UPDATE "
									+ TABLE
									+ " SET lastname = ?, firstname = ?, age = ?, adress = ?, postalcode = ?, email = ? WHERE customerid = ?;");
					preparedStatement.setString(1, customer.getLastName());
					preparedStatement.setString(2, customer.getFirstName());
					preparedStatement.setInt(3, customer.getAge());
					preparedStatement.setString(4, customer.getAdress());
					preparedStatement.setString(5, customer.getPostalcode());
					preparedStatement.setString(6, customer.getEmail());
					preparedStatement.setInt(7, customer.getId());
					preparedStatement.executeUpdate();
					internalCustomers.set(internalCustomers.indexOf(c),
							customer.clone());
				} catch (Exception e) {
					e.printStackTrace();
				}
				;
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
	 *         Objekt nicht gel�scht werden kann.
	 */
	public static void delete(Customer customer) {
		int id = customer.getId();
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
				return;
			}
		}
	}

	/**
	 * Diese Methode pr�ft ob ein Customer-Objekt bereits in der Datenbank
	 * vorhanden ist. Wenn das Customer-Objekt bereits vorhanden ist dann wird
	 * true zur�ckgegeben, wenn nicht false
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
	public static void importCSV(String name) throws IOException {
		// Alte Daten speichern.
		MySqlCustomerDAO.terminate();

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
