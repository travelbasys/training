package de.travelbasys.training.dialog.other;

import java.util.ArrayList;

import de.travelbasys.training.dialog.Dialog;
import de.travelbasys.training.util.AppContext;

/**
 * erzeugt eine Instanz der Klasse ExportDialog
 * und verwaltet Strings für Ausgaben.
 */
public class ExportModel extends ArrayList<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String choice;
	private boolean check = true;
	private Dialog d;
	private static final String ABORT = "Abgebrochen.";

	/**
	 * Erzeugt eine Instanz der Klasse...
	 */
	public ExportModel() {
		super();
		add(AppContext.getMessage("Choose"));
		add(AppContext.getMessage("Back"));
		add(AppContext.getMessage("Export1"));
		add(AppContext.getMessage("Export2"));
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice_str) {
		this.choice = choice_str;
	}

	public boolean getCheck() {
		return check;
	}

	public void setCheckFalse() {
		check = false;
	}

	public Dialog getDialog() {
		return d;
	}

	public void setDialog(Dialog d) {
		this.d = d;
	}

	public Object getAbort() {
		return ABORT;
	}

}
