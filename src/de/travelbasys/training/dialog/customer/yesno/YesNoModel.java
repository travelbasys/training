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
	private int decision;
	private boolean qFlag = false;
	private boolean EndFlag = false;

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

	public int getDecision() {
		return decision;
	}

	public void setDecision(int decision) {
		this.decision = decision;
	}

	/**
	 * Setze die vom Benutzer getroffene Entscheidung.
	 * 
	 * @param qFlag
	 */
	public void setFlag(boolean deleteFlag) {
		this.qFlag = deleteFlag;
	}

	/**
	 * Hole die vom Benutzer getroffene Entscheidung.
	 * 
	 * @return dito.
	 */
	public boolean getFlag() {
		return qFlag;
	}

	public boolean getEndFlag() {
		return EndFlag;
	}

	public void setEndFlag() {
		EndFlag = true;
	}
}