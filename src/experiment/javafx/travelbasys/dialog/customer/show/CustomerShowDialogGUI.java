package experiment.javafx.travelbasys.dialog.customer.show;

import javafx.scene.layout.BorderPane;
import de.travelbasys.training.framework.Dialog;

public class CustomerShowDialogGUI implements Dialog {

	private CustomerShowModelGUI model;
	private CustomerShowViewGUI view;
	private CustomerShowControlGUI control;

	public CustomerShowDialogGUI(BorderPane root) {
		model = new CustomerShowModelGUI(root);
		view = new CustomerShowViewGUI(model);
		control = new CustomerShowControlGUI(model);
	}

	@Override
	public void run() {
		view.run();
		control.buildEventHandler();
		view.show();
	}

}
