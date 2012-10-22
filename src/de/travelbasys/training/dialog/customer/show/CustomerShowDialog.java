package de.travelbasys.training.dialog.customer.show;

import de.travelbasys.training.framework.Dialog;

/**
 */
public class CustomerShowDialog implements Dialog {
	private CustomerShowModel model;
	private CustomerShowView view;
	private CustomerShowControl control;

	@Override
	public void run() {
		model = new CustomerShowModel();
		control = new CustomerShowControl();
		view = new CustomerShowView();

		view.init(model);
		control.init(model, view);

		view.run();
	}

}
