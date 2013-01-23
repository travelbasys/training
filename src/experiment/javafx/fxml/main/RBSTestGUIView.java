package experiment.javafx.fxml.main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import de.travelbasys.training.framework.View;

public class RBSTestGUIView implements View {

	@FXML
	private static BorderPane bp;

	private @FXML
	static Button changeButton;

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

}
