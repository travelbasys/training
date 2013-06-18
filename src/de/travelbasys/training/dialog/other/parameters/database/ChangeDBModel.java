package de.travelbasys.training.dialog.other.parameters.database;

import java.util.ArrayList;

import de.travelbasys.training.framework.Model;

/**
 * erzeugt eine Instanz der Klasse ChangeDBModel und verwaltet Daten
 * 
 * @author
 */
public class ChangeDBModel extends ArrayList<String> implements Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String DBkey = "";

	public String getDBKey() {
		return DBkey;
	}

	public void setDBkey(String key) {
		this.DBkey = key;
	}
}