package experiment.javafx.travelbasys.dialog.customer.create;

import javafx.scene.layout.BorderPane;
import de.travelbasys.training.framework.Dialog;

public class CustomerCreateDialogGUI implements Dialog {

	private CustomerCreateModelGUI model;
	private CustomerCreateViewGUI view;
	private CustomerCreateControlGUI control;

	public CustomerCreateDialogGUI(BorderPane root) {
		model = new CustomerCreateModelGUI(root);
		view = new CustomerCreateViewGUI(model);
		control = new CustomerCreateControlGUI(model);
	}

	@Override
	public void run() {
		view.run();
		control.buildEventHandler();
		view.show();
	}

}
