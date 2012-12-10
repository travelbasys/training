package experiment.javafx.travelbasys.dialog.customer.list;

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

	@Override
	public void run() {
		view.init();
		control.init(model, view);
		view.show();
	}

}
