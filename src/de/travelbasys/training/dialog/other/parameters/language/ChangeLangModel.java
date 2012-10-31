package de.travelbasys.training.dialog.other.parameters.language;

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

	public Locale getLocale() {
		return locale;
	}

	public String getLangKey() {
		return Locale.getDefault().toString();
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
}
