package experiment.javafx.travelbasys.dialog.customer.update;

import javafx.scene.layout.BorderPane;
import de.travelbasys.training.framework.Dialog;

public class CustomerUpdateDialogGUI implements Dialog {

	private CustomerUpdateModelGUI model;
	private CustomerUpdateViewGUI view;
	private CustomerUpdateControlGUI control;

	public CustomerUpdateDialogGUI(BorderPane root) {
		model = new CustomerUpdateModelGUI(root);
		view = new CustomerUpdateViewGUI(model);
		control = new CustomerUpdateControlGUI(model);
	}

	@Override
	public void run() {
		view.run();
		control.buildEventHandler();
		view.show();
	}

}
