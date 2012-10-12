package de.travelbasys.training.dialog.customer.Show;

import de.travelbasys.training.dialog.Dialog;

/**
 * ist verantwortlich für den Dialog mit dem Benutzer, um alle Daten für ein
 * Customer Objekt abzufragen und das Objekt dann zu erzeugen.
 * 
 * @author tba
 */

public class CustomerShowDialog implements Dialog {

	private CustomerShowModel model;
	private CustomerShowView view;
	private CustomerShowControl control;

	public void run() {
		model = new CustomerShowModel();
		control = new CustomerShowControl(model, view);
		view = new CustomerShowView(model, control);

		// Here plays the music!
		view.run();

		// Do something with the input!

	}

}
