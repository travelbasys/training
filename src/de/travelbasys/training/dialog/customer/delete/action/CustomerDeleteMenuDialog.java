package de.travelbasys.training.dialog.customer.delete.action;

import de.travelbasys.training.framework.Dialog;

/**
 * hat die Aufgabe ein vorhandenes Customer Objekt aus der Datenbank zu l�schen.
 * Gibt R�ckmeldung �ber den Erfolg des L�schvorgangs.
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
	 * L�scht den Customer. F�hrt den Dialog aus.
	 */
	@Override
	public void run() {
		view.run();
	}

}
