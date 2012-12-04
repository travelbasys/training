package experiment.javafx.travelbasys.dialog.about;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import de.travelbasys.training.framework.Model;

public class AboutModelGUI implements Model{
	private GridPane grid;
	private Stage aboutwindow;
	public AboutModelGUI() {
		
	}
	public GridPane getGrid() {
		return grid;
	}
	public void setGrid(GridPane grid) {
		this.grid = grid;
	}
	public Stage getWindow() {
		return aboutwindow;
	}
	public void setWindow(Stage aboutwindow) {
		this.aboutwindow = aboutwindow;
	}

}
