package de.travelbasys.training.dialog.other.configuration.manager;

import java.util.ArrayList;

import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.util.AppContext;

/**
 * erzeugt eine Instanz der Klasse ChangeConfigurationDialog und verwaltet Strings f�r
 * Ausgaben.
 */
public class ChangeConfigurationModel extends ArrayList<String> implements Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Dialog d;

	/**
	 * Erzeugt eine Instanz der Klasse...
	 */
	public ChangeConfigurationModel() {
		super();
		add(AppContext.getMessage("Choose"));
		add(AppContext.getMessage("Back"));
		add(AppContext.getMessage("Param1"));
		add(AppContext.getMessage("Param2"));
	}

	public Dialog getDialog() {
		return d;
	}

	public void setDialog(Dialog d) {
		this.d = d;
	}
}
