package de.travelbasys.training.dao.access;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.CustomerDAO;
import de.travelbasys.training.dao.CustomerDaoException;
import de.travelbasys.training.db.AccessConnection;
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
 * 
 */
public class AccessCustomerDAO implements CustomerDAO {

	private static String FILE;
	private static String TABLE;
	private static List<Customer> internalCustomers;
	private static List<String> tables;

	private static Connection connect = null;
	private static Connection importCon = null;
	private static String importAbsolutePath = null;
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	private static ResultSet importResultSet = null;
	private static int localupdateid = 0;
	private static int localimportcounter = 0;
	private final String INSERT = "INSERT INTO ";
	private final String VALUES = " VALUES (?, ?, ?, ?, ?, ?);";
	private final String SELECT = "SELECT * FROM ";
	private final String WHERECUSTOMERID = " WHERE customerid = ";
	private final String UPDATEATTRIBUTES = " SET lastname = ?, firstname = ?, birthdate = ?, adress = ?, postalcode = ?, email = ?, updateid = ? WHERE customerid = ?;";
	private final String DELETE = "DELETE FROM ";
	private final String FIELDS = "(lastname, firstname, birthdate, adress, postalcode, email)";

	public AccessCustomerDAO() {
	}

	/**
	 * initialisiert den internen Zustand von <tt>CustomerDao</tt>.
	 * 
	 * <p>
	 * Diese Implementierung benutzt eine MDB-Datei(.mdb) als Datenbank. Sie
	 * liest sämtliche Datensätze der Datenbank aus der Datei und speichert sie
	 * intern ab. Der Name der Datei wird als Parameter angegeben und ebenfalls
	 * gespeichert.
	 * </p>
	 * 
	 * @param db
	 *            Name der Datenbank, momentan der Name der MDB-Datei, in dem
	 *            die Datensätze gespeichert sind.
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

	/**
	 * Diese Methode ist für das schließen der Verbindung zur MDB-Datei
	 * zuständig.
	 */
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
	 * Diese Methode leert die Interne Liste vom Typ Customer und schließt die
	 * Verbindung mit der MDB-Datei.
	 */
	public void terminate() {
		internalCustomers.clear();
		CloseCurrentConnection();
	}

	/**
	 * gibt eine Kopie der <tt>internalCustomers</tt> Liste die alle Datensätze
	 * der Datenbank enthält zurück.
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
	public void create(Customer customer) throws CustomerDaoException {
		init(FILE);
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

	/**
	 * Diese Methode erzeut eine neue Customer ID indem der letzte Datensatz der
	 * Datenbank gesucht wird und dessen ID zurück gegeben wird.
	 */
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
	 * <tt>id</tt> zurück.
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
			resultSet = statement.executeQuery(SELECT + TABLE + WHERECUSTOMERID
					+ id + ";");
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
	public void update(Customer customer) throws CustomerDaoException {
		OpenConnection();
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery(SELECT + FILE + "." + TABLE
					+ WHERECUSTOMERID + customer.getId() + ";");
			resultSet.next();
			if (resultSet.getRow() == 0) {
				System.err
						.println("Customer has been deleted by another user.");
				return;
			}
			int updateid = resultSet.getInt(8);
			if (updateid == localupdateid) {
				preparedStatement = connect.prepareStatement("UPDATE " + FILE
						+ "." + TABLE + UPDATEATTRIBUTES);
				preparedStatement.setString(1, customer.getLastName());
				preparedStatement.setString(2, customer.getFirstName());
				preparedStatement.setDate(3, new java.sql.Date(customer
						.getBirthdate().getTime()));
				preparedStatement.setString(4, customer.getAdress());
				preparedStatement.setString(5, customer.getPostalcode());
				preparedStatement.setString(6, customer.getEmail());
				preparedStatement.setInt(7, updateid++);
				preparedStatement.setInt(8, customer.getId());
				preparedStatement.executeUpdate();
			} else {
				CloseCurrentConnection();
				throw new CustomerDaoException(
						"Customer has been changed by another user.");
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

	/**
	 * Diese Methode stellt die Verbindung zur MDB-Datei her.
	 */
	public void OpenConnection() {
		connect = AccessConnection.getInstance();
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
	public Customer getExisting(Customer customer) throws CustomerDaoException {
		for (Customer c : internalCustomers) {
			if (c.equals(customer)) {
				throw new CustomerDaoException("ExistErr", c);
			}
		}
		return null;
	}

	/**
	 * Diese Methode ließt zeilenweise eine CSV Datei ein und parst den Inhalt
	 * zu Customerobjekten, durch die Methode {@see create} werden diese der
	 * Datenbank hinzugefügt.
	 * 
	 * @param name
	 *            Name der Datei.
	 * @throws IOException
	 *             Dieser Fehler tritt auf, wenn die Datei nicht vorhanden oder
	 *             schreibgeschützt ist.
	 * @throws CustomerDaoException
	 */
	public void importCSV(String name) throws IOException, CustomerDaoException {
		localimportcounter = 0;
		FileReader fr = new FileReader(name);
		BufferedReader br = new BufferedReader(fr);

		// Erste Zeile überspringen, in der die Spaltennamen stehen.
		br.readLine();
		String s;
		while ((s = br.readLine()) != null) {
			try {
				create(Customer.parseCSV(s));
				localimportcounter++;
			} catch (CustomerDaoException e) {
				continue;
			}
		}
		fr.close();
	}
/**
 * Ist für das einlesen einer MDB-Datei (.mdb), anhand des Absoluten Pfads verantwortlich und 
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
			e.printStackTrace();
		}
	}

	@Override
	public int getImportedCustomersNumber() {
		return localimportcounter;
	}

	@Override
	public ResultSet getImportResultSet() {
		return importResultSet;
	}
}
