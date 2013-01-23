package de.travelbasys.trainingfx.dialog.customer.update2;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.util.Config;

public class CustomerUpdate2DialogGUI implements Dialog {

	private BorderPane root;
	private String PATH = "/de/travelbasys/trainingfx/dialog/customer/update2/";
	private String FILE = "CustomerUpdate2Frame.fxml";

	public CustomerUpdate2DialogGUI(BorderPane root) {
		this.root = root;
	}

	@Override
	public void run() {
		try {
			BorderPane updatePane = FXMLLoader.load(
					getClass().getResource(PATH + FILE), Config.BUNDLE);
			root.setCenter(updatePane);
		} catch (Exception e) {
		}
	}
}
