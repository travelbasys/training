package de.travelbasys.training.dao;

import de.travelbasys.training.dao.access.AccessCustomerDAO;
import de.travelbasys.training.dao.mysql.MySQLCustomerDAO;
import de.travelbasys.training.dao.text.TxtCustomerDAO;

public class Dao {

	private static CustomerDAO dao;

	/**
	 * Diese Methode entscheidet anhand einer integer Variable welche Art von
	 * Datenbank verwendet wird. Es gibt die möglichkeiten:
	 * 
	 * <ol>
	 * <li>Text-Datei (.txt)</li>
	 * <li>Access-Datenbank (.mdb)</li>
	 * <li>MySQL-Datenbank</li>
	 * </ol>
	 * 
	 * @param dbtype
	 */
	public static void setDAO(int dbtype) {
		dao = null;
		switch (dbtype) {
		case 1:
			dao = new TxtCustomerDAO();
			break;
		case 2:
			dao = new MySQLCustomerDAO();
			break;
		case 3:
			dao = new AccessCustomerDAO();
			break;
		default:
			dao = new TxtCustomerDAO();
			break;
		}
	}

	public static CustomerDAO getDAO() {
		return dao;
	}
}
