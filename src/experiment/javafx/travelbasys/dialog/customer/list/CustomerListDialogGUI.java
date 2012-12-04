package experiment.javafx.travelbasys.dialog.customer.list;

import javafx.scene.layout.BorderPane;
import de.travelbasys.training.framework.Dialog;

public class CustomerListDialogGUI implements Dialog {
	private CustomerListModelGUI model;
	private CustomerListViewGUI view;
	private CustomerListControlGUI control;

	public CustomerListDialogGUI(BorderPane root) {
		model = new CustomerListModelGUI(root);
		view = new CustomerListViewGUI(model);
		control = new CustomerListControlGUI(model);
	}

	@Override
	public void run() {
		view.run();
		control.buildEventHandler();
		view.show();
	}

}
