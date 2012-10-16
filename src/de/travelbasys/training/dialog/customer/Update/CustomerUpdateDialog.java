package de.travelbasys.training.dialog.customer.Update;

import de.travelbasys.training.dialog.Dialog;
import de.travelbasys.training.dialog.customer.Update.CustomerUpdateControl;
import de.travelbasys.training.dialog.customer.Update.CustomerUpdateModel;
import de.travelbasys.training.dialog.customer.Update.CustomerUpdateView;

/**
 * Diese Klasse ist für das ändern der vorhandenen Daten eines Customer
 * Objekts verantwortlich.
 * @author tba
 *
 */

public class CustomerUpdateDialog implements Dialog {
	private CustomerUpdateModel model;
	private CustomerUpdateView view;
	private CustomerUpdateControl control;

	@Override
	public void run(){
		model = new CustomerUpdateModel();
		control = new CustomerUpdateControl(model, view);
		view = new CustomerUpdateView(model, control);

		view.run();

	}
	
}