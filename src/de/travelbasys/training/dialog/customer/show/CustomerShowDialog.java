package de.travelbasys.training.dialog.customer.show;

import de.travelbasys.training.dialog.Dialog;
import de.travelbasys.training.framework.Control;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

/**
 */
public class CustomerShowDialog implements Dialog {
	private Model model;
	private View view;
	private Control control;

	@Override
	public void run() {
		model = new CustomerShowModel();
		control = new CustomerShowControl();
		view = new CustomerShowView();
		
		view.init(model);
		control.init(model,view);
		
		view.run();
	}

}
