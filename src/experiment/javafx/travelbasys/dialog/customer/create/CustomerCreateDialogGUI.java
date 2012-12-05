package experiment.javafx.travelbasys.dialog.customer.create;

import javafx.scene.layout.BorderPane;
import de.travelbasys.training.framework.Dialog;

public class CustomerCreateDialogGUI implements Dialog {

	private CustomerCreateModelGUI model;
	private CustomerCreateViewGUI view;
	private CustomerCreateControlGUI control;

	public CustomerCreateDialogGUI(BorderPane root) {
		model = new CustomerCreateModelGUI();
		view = new CustomerCreateViewGUI(model, root);
		control = new CustomerCreateControlGUI();
	}

	@Override
	public void run() {
		view.run();
		control.init(model, view);
		view.show();
	}

}
