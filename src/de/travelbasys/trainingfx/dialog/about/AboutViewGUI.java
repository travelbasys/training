package de.travelbasys.trainingfx.dialog.about;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.util.AppContext;

public class AboutViewGUI {

	private AboutModelGUI model;

	public AboutViewGUI(Model model) {
		this.model = (AboutModelGUI) model;
	}

	public void init() {
		Stage aboutwindow = new Stage();
		aboutwindow.setTitle("About");

		Label about1 = new Label(AppContext.getMessage("About1"));
		Label about2 = new Label(AppContext.getMessage("About2"));
		Label about3 = new Label(AppContext.getMessage("About3"));

		// Erzeugt ein TabellenPanel.
		GridPane grid = new GridPane();
		// Setzt alle Ränder auf 10 Pixel.
		grid.setPadding(new Insets(10, 10, 10, 10));
		// Setzt den Abstand innerhalb der Tabelle auf 5 Pixel.
		grid.setVgap(5);
		grid.setHgap(5);
		// Setzt Zeilen/Spaltenposition der Elemente fest.
		// (Objekt, Spalte, Zeile)
		GridPane.setConstraints(about1, 0, 0);
		GridPane.setConstraints(about2, 0, 1);
		GridPane.setConstraints(about3, 0, 2);
		grid.getChildren().addAll(about1, about2, about3);

		aboutwindow.setScene(new Scene(grid, 320, 240));
		aboutwindow.setResizable(false);

		model.setWindow(aboutwindow);
	}

	public void run() {
		model.getWindow().show();
	}

}
