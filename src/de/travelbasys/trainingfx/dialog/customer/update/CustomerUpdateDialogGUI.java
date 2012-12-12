package de.travelbasys.trainingfx.dialog.customer.update;

import javafx.scene.layout.BorderPane;
import de.travelbasys.training.framework.Dialog;

public class CustomerUpdateDialogGUI implements Dialog {

	private CustomerUpdateModelGUI model;
	private CustomerUpdateViewGUI view;
	private CustomerUpdateControlGUI control;

	public CustomerUpdateDialogGUI(BorderPane root) {
		model = new CustomerUpdateModelGUI();
		view = new CustomerUpdateViewGUI(model, root);
		control = new CustomerUpdateControlGUI();
	}

	@Override
	public void run() {
		view.init();
		control.init(model, view);
		view.run();
	}

}
