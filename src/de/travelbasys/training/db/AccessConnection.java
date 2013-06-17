package de.travelbasys.training.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class AccessConnection {

	public static Connection conn = null;
	private static String dbName = "testdb";

	private AccessConnection() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn = DriverManager.getConnection("jdbc:odbc:" + dbName);

		} catch (Exception e) {
			System.err.println("Database not found. Please look into Help.txt");
		}
	}

	/**
	 * Diese Klasse erzeugt eine Verbindung zu einer Access-Datenbank.
	 * 
	 * @return
	 */
	public static Connection getInstance() {
		new AccessConnection();
		return conn;
	}

}
