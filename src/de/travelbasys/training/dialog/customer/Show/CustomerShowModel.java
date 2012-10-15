package de.travelbasys.training.dialog.customer.Show;

import java.util.ArrayList;

import de.travelbasys.training.util.AppContext;


public class CustomerShowModel extends ArrayList<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Erzeugt eine Instanz der Klasse...
	 */
	public CustomerShowModel() {
		super();
		add(AppContext.getMessage("Choose"));
		add(AppContext.getMessage("ExitApp"));
		add(AppContext.getMessage("Show1"));
		add(AppContext.getMessage("Show2"));
	}

}