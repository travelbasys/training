package experiment.javafx.travelbasys.dialog.customer.delete;

import javafx.scene.layout.BorderPane;
import de.travelbasys.training.framework.Dialog;

public class CustomerDeleteDialogGUI implements Dialog {

	private CustomerDeleteModelGUI model;
	private CustomerDeleteViewGUI view;
	private CustomerDeleteControlGUI control;

	public CustomerDeleteDialogGUI(BorderPane root) {
		model = new CustomerDeleteModelGUI(root);
		view = new CustomerDeleteViewGUI(model);
		control = new CustomerDeleteControlGUI(model);
	}

	@Override
	public void run() {
		view.run();
		control.buildEventHandler();
		view.show();
	}

}