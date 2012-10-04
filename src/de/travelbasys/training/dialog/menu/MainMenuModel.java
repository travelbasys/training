package de.travelbasys.training.dialog.menu;

import java.util.ArrayList;

import de.travelbasys.training.util.AppContext;

public class MainMenuModel extends ArrayList<String> {

	/**
	 * Erzeugt eine Instanz der Klasse...
	 */
	public MainMenuModel() {
		super();
		
		add(AppContext.getMessage("Choose"));
		add(AppContext.getMessage("ExitApp"));
		add(AppContext.getMessage("App1"));
		add(AppContext.getMessage("App2a"));
		add(AppContext.getMessage("App2b"));
		add(AppContext.getMessage("App3"));
		add(AppContext.getMessage("App4"));
		add(AppContext.getMessage("App5"));
		add(AppContext.getMessage("App6"));
		add(AppContext.getMessage("App7"));
		add(AppContext.getMessage("App8"));
		add(AppContext.getMessage("App9"));
	}

}
