package de.travelbasys.training.dialog.customer.delete.action;

import de.travelbasys.training.framework.Dialog;

/**
 * hat die Aufgabe ein vorhandenes Customer Objekt aus der Datenbank zu l�schen.
 * Gibt R�ckmeldung �ber den Erfolg des L�schvorgangs.
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
	 * L�scht den Customer. F�hrt den Dialog aus.
	 */
	@Override
	public void run() {
		view.run();
	}

}
