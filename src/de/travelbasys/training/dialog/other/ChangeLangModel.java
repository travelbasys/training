package de.travelbasys.training.dialog.other;

import java.util.ArrayList;
import java.util.Locale;

import de.travelbasys.training.util.AppContext;

public class ChangeLangModel extends ArrayList<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String choice;
	private Locale locale;
	private boolean check;

	private static final String ABORT = "Abgebrochen.";

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

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice_str) {
		this.choice = choice_str;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public String getAbort() {
		return ABORT;
	}



}