package de.travelbasys.trainingfx.dialog.customer.show;

import javafx.scene.layout.BorderPane;
import de.travelbasys.training.framework.Dialog;

public class CustomerShowDialogGUI implements Dialog {

	private CustomerShowModelGUI model;
	private CustomerShowViewGUI view;
	private CustomerShowControlGUI control;

	public CustomerShowDialogGUI(BorderPane root) {
		model = new CustomerShowModelGUI();
		view = new CustomerShowViewGUI(model, root);
		control = new CustomerShowControlGUI();
	}

	@Override
	public void run() {
		view.init();
		control.init(model, view);
		view.run();
	}

}
