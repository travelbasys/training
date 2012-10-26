package de.travelbasys.training.dialog.customer.delete.action;

import de.travelbasys.training.framework.Dialog;

/**
 * hat die Aufgabe ein vorhandenes Customer Objekt aus der Datenbank zu löschen.
 * Gibt Rückmeldung über den Erfolg des Löschvorgangs.
 */
public class CustomerDeleteMenuDialog implements Dialog {
	private CustomerDeleteMenuModel model;
	@SuppressWarnings("unused")
	private CustomerDeleteMenuControl control;
	private CustomerDeleteMenuView view;

	public CustomerDeleteMenuDialog(boolean success) {
		model = new CustomerDeleteMenuModel();
		model.setSuccess(success);

		view = new CustomerDeleteMenuView(model);
	}

	/**
	 * Löscht den Customer. Führt den Dialog aus.
	 */
	@Override
	public void run() {
		view.run();
	}

}
