package de.travelbasys.trainingfx.dialog.customer.create2;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.util.Config;

public class CustomerCreate2DialogGUI implements Dialog {

	private BorderPane root;
	private String PATH = "/de/travelbasys/trainingfx/dialog/customer/create2/";
	private String FILE = "CustomerCreate2Frame.fxml";

	public CustomerCreate2DialogGUI(BorderPane root) {
		this.root = root;
	}

	/**
	 * Diese Methode lädt eine FXML Datei die die Oberfläche enthält die für das
	 * anlegen eines Nutzers erforderlich ist und setzt diese im Hauptfenseter.
	 */
	@Override
	public void run() {
		try {
			BorderPane createPane = FXMLLoader.load(
					getClass().getResource(PATH + FILE), Config.BUNDLE);
			root.setCenter(createPane);
		} catch (Exception e) {
		}
	}
}
