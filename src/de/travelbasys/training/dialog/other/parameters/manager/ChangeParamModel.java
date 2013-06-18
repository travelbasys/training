package de.travelbasys.training.dialog.other.parameters.manager;

import java.util.ArrayList;

import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.util.AppContext;

/**
 * erzeugt eine Instanz der Klasse ChangeParamModel und verwaltet Strings für
 * Ausgaben.
 */
public class ChangeParamModel extends ArrayList<String> implements Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Dialog d;

	/**
	 * Erzeugt eine Instanz der Klasse...
	 */
	public ChangeParamModel() {
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
