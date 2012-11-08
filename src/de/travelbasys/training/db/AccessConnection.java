package de.travelbasys.training.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class AccessConnection {

	public static Connection conn = null;
	@SuppressWarnings("unused")
	private static String dbUser = "sqluser";
	@SuppressWarnings("unused")
	private static String dbPassword = "sqluserpw";
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
