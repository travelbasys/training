package experiment.javafx.travelbasys.dialog.about;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import de.travelbasys.training.framework.Model;

public class AboutViewGUI {

	private AboutModelGUI model;

	public AboutViewGUI(Model model) {
		this.model = (AboutModelGUI) model;
	}

	public void init() {
		Stage aboutwindow = new Stage();
		aboutwindow.setTitle("About");

		Label name = new Label("Name: Daniel Rowlin");
		Label year = new Label("Year: 2012");

		// Erzeugt ein TabellenPanel.
		GridPane grid = new GridPane();
		// Setzt alle Ränder auf 10 Pixel.
		grid.setPadding(new Insets(10, 10, 10, 10));
		// Setzt den Abstand innerhalb der Tabelle auf 5 Pixel.
		grid.setVgap(5);
		grid.setHgap(5);
		// Setzt Zeilen/Spaltenposition der Elemente fest.
		// (Objekt, Spalte, Zeile)
		GridPane.setConstraints(name, 0, 0);
		GridPane.setConstraints(year, 0, 1);

		grid.getChildren().addAll(name, year);

		aboutwindow.setScene(new Scene(grid, 320, 240));
		aboutwindow.setResizable(false);

		model.setWindow(aboutwindow);
	}

	public void run() {
		model.getWindow().show();
	}

}
