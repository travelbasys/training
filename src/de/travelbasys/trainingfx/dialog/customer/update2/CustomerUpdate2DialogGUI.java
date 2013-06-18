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

	/**
	 * Diese Methode lädt eine FXML Datei die die Oberfläche enthält die für das
	 * ändern eines Customers erforderlich ist und setzt diese im Hauptfenseter.
	 */
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
