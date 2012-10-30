package de.travelbasys.training.dialog.customer.delete.action;

import de.travelbasys.training.framework.Model;

/**
 * hat die Aufgabe, ein Model für den Customer Delete Dialog zu verwalten, und
 * beinhaltet die Customer ID des Customer Objekts das aus der Datenbank
 * entfernt werden soll.
 */
public class CustomerDeleteActionModel implements Model {
	private boolean success;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	

}
