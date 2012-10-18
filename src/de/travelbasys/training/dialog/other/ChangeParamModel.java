package de.travelbasys.training.dialog.other;

import java.util.ArrayList;

import de.travelbasys.training.dialog.Dialog;
import de.travelbasys.training.util.AppContext;

/**
 * erzeugt eine Instanz der Klasse ChangeParamDialog und verwaltet Strings für
 * Ausgaben.
 */

public class ChangeParamModel extends ArrayList<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String choice;
	private boolean check;
	private Dialog d;
	private boolean EndFlag = false;

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

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice_str) {
		this.choice = choice_str;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheckFalse() {
		check = false;
	}

	public void setCheckTrue() {
		check = true;
	}

	public Dialog getDialog() {
		return d;
	}

	public void setDialog(Dialog d) {
		this.d = d;
	}

	public boolean getEndFlag() {
		return EndFlag;
	}

	public void setEndFlag() {
		EndFlag = true;
	}
}
