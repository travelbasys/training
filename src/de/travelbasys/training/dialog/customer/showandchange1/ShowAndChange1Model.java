package de.travelbasys.training.dialog.customer.showandchange1;

import java.util.ArrayList;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.util.AppContext;

/**
 * hat die Aufgabe, ein Model für den ShowAndChange1 Dialog zu verwalten.
 * 
 * Die aktuelle Implementierung enthält alle Daten um eine abrage der
 * gewünschten Funktion auszuführen.
 */
public class ShowAndChange1Model extends ArrayList<String> implements Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int index;

	public ShowAndChange1Model() {
		super();
		add(AppContext.getMessage("Choose"));
		add(AppContext.getMessage("EndScndApp"));
		add(AppContext.getMessage("Update1"));
		add(AppContext.getMessage("Update2"));
		add(AppContext.getMessage("Update3"));
		add(AppContext.getMessage("Update4"));
		add(AppContext.getMessage("Update5"));
		add(AppContext.getMessage("Update6"));
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}