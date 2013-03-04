package de.travelbasys.trainingfx.dialog.customer.delete2;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.util.Config;

public class CustomerDelete2DialogGUI implements Dialog {

	private BorderPane root;
	private String PATH = "/de/travelbasys/trainingfx/dialog/customer/delete2/";
	private String FILE = "CustomerDelete2Frame.fxml";

	public CustomerDelete2DialogGUI(BorderPane root) {
		this.root = root;
	}
	/**
	 * Diese Methode lädt eine FXML Datei die die Oberfläche enthält die für das
	 * löschen eines Customers erforderlich ist und setzt diese im Hauptfenseter.
	 */
	@Override
	public void run() {
		try {
			BorderPane deletePane = FXMLLoader.load(
					getClass().getResource(PATH + FILE), Config.BUNDLE);
			root.setCenter(deletePane);
		} catch (Exception e) {
		}
	}
}
