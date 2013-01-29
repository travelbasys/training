package experiment.javafx.fxml.main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import de.travelbasys.training.framework.View;

public class RBSTestGUIView implements View {

	@FXML
	private static BorderPane bp;

	private @FXML
	static Button changeButton;
	@FXML
	private static BorderPane calbp;
	@FXML
	private static TextField dateField;

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public static BorderPane getBP() {
		return bp;
	}

	public static Button getButton() {
		return changeButton;
	}

	public static BorderPane getCalbp() {
		return calbp;
	}

	public static void setCalbp(BorderPane calbp) {
		RBSTestGUIView.calbp = calbp;
	}

	public static TextField getDateField() {
		return dateField;
	}

	public static void setDateField(TextField dateField) {
		RBSTestGUIView.dateField = dateField;
	}

}
