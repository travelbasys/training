package de.travelbasys.trainingfx.dialog.customer.list;

import javafx.scene.layout.BorderPane;
import de.travelbasys.training.framework.Dialog;

public class CustomerListDialogGUI implements Dialog {
	private CustomerListModelGUI model;
	private CustomerListViewGUI view;
	private CustomerListControlGUI control;

	public CustomerListDialogGUI(BorderPane root) {
		model = new CustomerListModelGUI();
		view = new CustomerListViewGUI(model, root);
		control = new CustomerListControlGUI();
	}

	/**
	 * Initialisiert die Komponenten des List-Dialoges
	 */
	@Override
	public void run() {
		view.init();
		control.init(model, view);
		view.run();
	}

}
