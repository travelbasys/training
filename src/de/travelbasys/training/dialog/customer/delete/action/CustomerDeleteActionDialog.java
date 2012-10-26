package de.travelbasys.training.dialog.customer.delete.action;

import de.travelbasys.training.framework.Dialog;

/**
 * hat die Aufgabe ein vorhandenes Customer Objekt aus der Datenbank zu löschen.
 * Gibt Rückmeldung über den Erfolg des Löschvorgangs.
 */
public class CustomerDeleteActionDialog implements Dialog {
	private CustomerDeleteActionModel model;
	@SuppressWarnings("unused")
	private CustomerDeleteActionControl control;
	private CustomerDeleteActionView view;

	public CustomerDeleteActionDialog(boolean success) {
		model = new CustomerDeleteActionModel();
		model.setSuccess(success);

		view = new CustomerDeleteActionView(model);
	}

	/**
	 * Löscht den Customer. Führt den Dialog aus.
	 */
	@Override
	public void run() {
		view.run();
	}

}
