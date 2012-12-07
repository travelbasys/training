package de.travelbasys.training.dao;

import de.travelbasys.training.dao.access.AccessCustomerDAO;
import de.travelbasys.training.dao.mysql.MySQLCustomerDAO;
import de.travelbasys.training.dao.text.TxtCustomerDAO;

public class Dao {

	private static CustomerDAO dao;
	private static String dbtype1 = "txt";
	private static String dbtype2 = "access";
	private static String dbtype3 = "mysql";

	public static void setDAO(String dbtype) {
		dao = null;
		if (dbtype.equals(dbtype1)) {
			dao = new TxtCustomerDAO();
		} else if (dbtype.equals(dbtype2)) {
			dao = new AccessCustomerDAO();
		} else if (dbtype.equals(dbtype3)) {
			dao = new MySQLCustomerDAO();
		} else {
			System.err
					.println("Datenbanktyp nicht angegeben, setze auf Default.");
			dao = new TxtCustomerDAO();
		}
	}

	public static CustomerDAO getDAO() {
		return dao;
	}
}
