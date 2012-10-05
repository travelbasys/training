package de.travelbasys.training.dialog.customer.Delete;

import de.travelbasys.training.dialog.Control;
import de.travelbasys.training.dialog.Dialog;

public class CustomerDeleteDialog implements Dialog {
	private CustomerDeleteModel model;
	private CustomerDeleteView view;
	private Control control;

	@Override
	public void run() {
		model = new CustomerDeleteModel();
		control = new CustomerDeleteControl(model);
		view = new CustomerDeleteView(model, control);

		view.run();
	}
}
