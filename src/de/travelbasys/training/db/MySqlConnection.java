package de.travelbasys.training.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {

	public static Connection conn = null;
	private static String dbHost = "localhost";
	private static String dbPort = "3306";
	private static String dbUser = "root";
	private static String dbPassword = "root";

	private static String dbName = "testdb";

	private MySqlConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":"
					+ dbPort + "/" + dbName + "?" + "user=" + dbUser + "&"
					+ "password=" + dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Diese Methode erzeugt eine Verbindung zu einer MySQL-Datenbank.
	 * 
	 * @return Eine Instanz der Verbindung
	 */
	public static Connection getNewInstance() {
		new MySqlConnection();
		return conn;
	}

}
