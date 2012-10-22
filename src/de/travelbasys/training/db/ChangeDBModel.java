package de.travelbasys.training.db;

import java.util.HashMap;

import de.travelbasys.training.dialog.Model;
import de.travelbasys.training.util.AppContext;

public class ChangeDBModel extends HashMap<String, String> implements Model{

	/**
	 * erzeugt eine Instanz der Klasse ChangeDBDialog
	 * und verwaltet Strings für Ausgaben
	 */
	private static final long serialVersionUID = 1L;

	public ChangeDBModel() {
		super();

		put("promptChangeDB", AppContext.getMessage("ChangeDB"));
	}

	public String getPrompt(String fieldName) {
		return get("prompt" + fieldName);
	}

}
