package de.travelbasys.training.db;

import java.sql.DriverManager;

import java.sql.Connection;

public class MySqlConnection {
	public static Connection conn;

	private static String dbHost = "localhost";
	private static String dbPort = "8080";
	private static String dbUser = "sqluser";
	private static String dbPassword = "sqluserpw";

	private static String dbName = "testdb";

	private MySqlConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection("jdbc:mysql://"+dbHost+":"+dbPort+"/" + dbName + "?"
							+ "user="+dbUser+"&password="+dbPassword);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getInstance() {
		if (conn == null)
			new MySqlConnection();
		return conn;
	}
}
