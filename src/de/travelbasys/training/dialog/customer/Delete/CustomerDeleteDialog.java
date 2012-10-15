package de.travelbasys.training.dialog.customer.Delete;

import de.travelbasys.training.dialog.Dialog;

/**
 * ist verantwortlich für das löschen eines Benutzers aus der Datenbank
 * 
 * @author tba
 * 
 */
public class CustomerDeleteDialog implements Dialog {
	private CustomerDeleteModel model;
	private CustomerDeleteView view;
	private CustomerDeleteControl control;

	@Override
	public void run(){
		model = new CustomerDeleteModel();
		control = new CustomerDeleteControl(model, view);
		view = new CustomerDeleteView(model, control);

		view.run();

	}
}
