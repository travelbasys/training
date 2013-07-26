package de.travelbasys.training.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class MDBConnection {

	public static Connection conn = null;

	private MDBConnection(String path) {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn = DriverManager
					.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="
							+ path);
		} catch (Exception e) {
			System.err.println("Could not connect to database.");
		}
	}

	/**
	 * Diese Methode erzeugt eine Verbindung zu einer MDB-Datei (.mdb), anhand
	 * des absoluten Pfads der Datei.
	 * 
	 * @param path
	 *            Der absolute Dateipfad
	 * @return Eine Instanz der Verbindung
	 */
	public static Connection getInstance(String path) {
		new MDBConnection(path);
		return conn;
	}

}
