package de.travelbasys.training.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class AccessConnection {

	public static Connection conn = null;
	private static String dbHost = "localhost";
	private static String dbPort = "3306";
	private static String dbUser = "sqluser";
	private static String dbPassword = "sqluserpw";

	private static String dbName = "testdb";

	private AccessConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":"
					+ dbPort + "/" + dbName + "?" + "user=" + dbUser
					+ "&password=" + dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getNewInstance() {
		new AccessConnection();
		return conn;
	}

}
