package de.travelbasys.training.dialog.customer.update.menu;

import java.util.ArrayList;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.util.AppContext;

/**
 * repräsentiert ein Menü aus einzelnen Menüpunkten (Strings) und besitzt
 * zusätzlich ein Integer Attribut namens "Index", welches den vom Benutzer
 * gewünschten Menüpunkt auswählt.
 */
public class CustomerUpdateMenuModel extends ArrayList<String> implements Model {

	private static final long serialVersionUID = 1L;
	private int index;

	/**
	 * Erzeugt eine Liste welche ein Auswahlmenü ausgibt.
	 */
	public CustomerUpdateMenuModel() {
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

	/**
	 * Hole den Index des vom Benutzer gewünschten Menüpunktes.
	 * 
	 * @return dito.
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Setze den Index des vom Benutzer gewünschten Menüpunktes.
	 * 
	 * @param index
	 */
	public void setIndex(int index) {
		this.index = index;
	}
}