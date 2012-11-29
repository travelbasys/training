package experiment.javafx.travelbasys;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import de.travelbasys.training.framework.Model;

public class MainModel implements Model {

	private Stage primaryStage;
	private Pane pane;

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public Pane getPane() {
		return pane;
	}

	public void setPane(Pane pane) {
		this.pane = pane;
	}

}
