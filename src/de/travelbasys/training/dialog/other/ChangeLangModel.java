package de.travelbasys.training.dialog.other;

import java.util.ArrayList;

import de.travelbasys.training.util.AppContext;


public class ChangeLangModel extends ArrayList<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Erzeugt eine Instanz der Klasse...
	 */
	public ChangeLangModel() {
		super();
		add(AppContext.getMessage("Choose"));
		add(AppContext.getMessage("Back"));
		add(AppContext.getMessage("Lang1"));
		add(AppContext.getMessage("Lang2"));
	}

}