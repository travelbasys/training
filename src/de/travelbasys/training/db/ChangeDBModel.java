package de.travelbasys.training.db;

import java.util.ArrayList;

import de.travelbasys.training.framework.Model;

/**
 * erzeugt eine Instanz der Klasse CustomerDeleteDialog und verwaltet Daten
 * 
 * @author
 */
public class ChangeDBModel extends ArrayList<String> implements Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String DBkey = "";
	public ChangeDBModel() {
		super();
	}
	public String getDBkey() {
		return DBkey;
	}
	public void setDBkey(String key) {
		this.DBkey = key;
	}
}