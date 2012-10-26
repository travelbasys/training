package de.travelbasys.training.dialog.customer.delete1;

import de.travelbasys.training.framework.Dialog;

/**
 * hat die Aufgabe ein vorhandenes Customer Objekt aus der Datenbank zu l�schen.
 * Gibt R�ckmeldung �ber den Erfolg des L�schvorgangs.
 */
public class CustomerDelete1Dialog implements Dialog {
	private CustomerDelete1Model model;
	@SuppressWarnings("unused")
	private CustomerDelete1Control control;
	private CustomerDelete1View view;

	public CustomerDelete1Dialog(boolean success) {
		model = new CustomerDelete1Model();
		model.setSuccess(success);

		view = new CustomerDelete1View(model);
	}

	/**
	 * L�scht den Customer. F�hrt den Dialog aus.
	 */
	@Override
	public void run() {
		view.run();
	}

}
