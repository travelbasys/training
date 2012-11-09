package de.travelbasys.training.dao;

public class Dao {

	private static CustomerDAO dao;

	public static void setDAO(CustomerDAO daoclass) {
		dao = daoclass;
	}

	public static CustomerDAO getDAO() {
		return dao;
	}
}
