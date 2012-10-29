package de.travelbasys.training.dialog.other;

import java.util.ArrayList;

import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.util.AppContext;

/**
 * erzeugt eine Instanz der Klasse ChangeConfigurationDialog und verwaltet Strings für
 * Ausgaben.
 */
public class ChangeConfigurationModel extends ArrayList<String> implements Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean end = false;
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
