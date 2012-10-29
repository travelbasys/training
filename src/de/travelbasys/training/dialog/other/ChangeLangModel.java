package de.travelbasys.training.dialog.other;

import java.util.ArrayList;
import java.util.Locale;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.util.AppContext;

/**
 * erzeugt eine Instanz der Klasse ChangeLangDialog und verwaltet Strings für
 * Ausgaben.
 */
public class ChangeLangModel extends ArrayList<String> implements Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean end = false;
	private Locale locale;

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

	public void setEnd() {
		end = true;
	}

	public boolean getEnd() {
		return end;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
}
