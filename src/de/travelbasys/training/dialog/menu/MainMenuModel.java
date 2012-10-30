package de.travelbasys.training.dialog.menu;

import java.util.ArrayList;

import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.util.AppContext;

/**
 * erzeugt eine Instanz der Klasse MainMenuDialog und verwaltet Strings für
 * Ausgaben.
 */
public class MainMenuModel extends ArrayList<String> implements Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean end = false;
	Dialog d;

	/**
	 * Erzeugt eine Instanz der Klasse...
	 */
	public MainMenuModel() {
		super();
		add(AppContext.getMessage("Choose"));
		add(AppContext.getMessage("ExitApp"));
		add(AppContext.getMessage("App1"));
		add(AppContext.getMessage("App2"));
		add(AppContext.getMessage("App3"));
		add(AppContext.getMessage("App4"));
		add(AppContext.getMessage("App5"));
		add(AppContext.getMessage("App6"));
		add(AppContext.getMessage("App7"));
		add(AppContext.getMessage("App8"));
		add(AppContext.getMessage("App9"));
	}

	public void setEnd() {
		end = true;
	}

	public boolean getEnd() {
		return end;
	}

	public Dialog getDialog() {
		return d;
	}

	public void setDialog(Dialog d) {
		this.d = d;
	}
}
