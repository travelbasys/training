package de.travelbasys.training.dialog.customer.show;

import de.travelbasys.training.dialog.Dialog;

/**
 * ist verantwortlich für den Dialog mit dem Benutzer, um alle Daten für ein
 * Customer Objekt abzufragen und das Objekt dann zu erzeugen.
 * 
 * @author tba
 */

public class CustomerShowDialog implements Dialog {
	private CustomerShowModel model;
	private static CustomerShowView view;
	private CustomerShowControl control;

	@Override
	public void run() {
		model = new CustomerShowModel();
		control = new CustomerShowControl(model);
		view = new CustomerShowView(model, control);

		view.run();
		if (model.isEnd() == false) {
			return;
		}
		view.found();

	}

	public static void end() {
		view.abort();

	}
}
