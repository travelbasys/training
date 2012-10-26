package de.travelbasys.training.dialog.customer.delete1;

import de.travelbasys.training.framework.Model;

/**
 * hat die Aufgabe, ein Model für den Customer Delete Dialog zu verwalten, und
 * beinhaltet die Customer ID des Customer Objekts das aus der Datenbank
 * entfernt werden soll.
 */
public class CustomerDelete1Model implements Model {
	private boolean success;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	

}
