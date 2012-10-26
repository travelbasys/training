package de.travelbasys.training.dialog.customer.yesno;

import java.util.ArrayList;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.util.AppContext;

/**
 * repräsentiert ein Menü aus einzelnen Menüpunkten (Strings) und besitzt
 * zusätzlich ein Integer Attribut namens "Decision", welches die vom Benutzer
 * getroffene Entscheidung wiedergibt.
 */
public class YesNoModel extends ArrayList<String> implements Model {
	private static final long serialVersionUID = 1L;
	
	private boolean yes;

	/**
	 * Erzeugt eine Liste welche eine Frage anhand des Keys ausgibt. Die
	 * Implementierung setzt eine Ja/Nein-Frage vorraus.
	 * 
	 * @param key
	 *            Der Schlüssel für die Fragestellung.
	 */
	public YesNoModel(String key) {
		super();
		add(AppContext.getMessage(key));
		add(AppContext.getMessage("Yes"));
		add(AppContext.getMessage("No"));
	}

	public boolean isYes() {
		return yes;
	}

	public void setYes(boolean yes) {
		this.yes = yes;
	}

}