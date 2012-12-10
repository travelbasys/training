package de.travelbasys.training.dao;

import de.travelbasys.training.dao.access.AccessCustomerDAO;
import de.travelbasys.training.dao.mysql.MySQLCustomerDAO;
import de.travelbasys.training.dao.text.TxtCustomerDAO;

public class Dao {

	private static CustomerDAO dao;

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
