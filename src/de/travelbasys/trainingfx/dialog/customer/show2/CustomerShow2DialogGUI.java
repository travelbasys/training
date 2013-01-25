package de.travelbasys.trainingfx.dialog.customer.show2;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.util.Config;

public class CustomerShow2DialogGUI implements Dialog {

	private BorderPane root;
	private String PATH = "/de/travelbasys/trainingfx/dialog/customer/show2/";
	private String FILE = "CustomerShow2Frame.fxml";

	public CustomerShow2DialogGUI(BorderPane root) {
		this.root = root;
	}

	@Override
	public void run() {
		try {
			BorderPane showPane = FXMLLoader.load(
					getClass().getResource(PATH + FILE), Config.BUNDLE);
			root.setCenter(showPane);
		} catch (Exception e) {
		}
	}
}
