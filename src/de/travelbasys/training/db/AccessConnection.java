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
			e.printStackTrace();
		}
	}

	public static Connection getInstance() {
		new AccessConnection();
		return conn;
	}

}
