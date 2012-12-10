package experiment.javafx.travelbasys.dialog.other.ChangeConfiguration;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import de.travelbasys.training.framework.Model;

public class ChangeConfigurationViewGUI {

	private ChangeConfigurationModelGUI model;
	private Stage ChangeConfigurationWindow;

	public ChangeConfigurationViewGUI(Model model) {
		this.model = (ChangeConfigurationModelGUI) model;
	}

	public void init() {
		ChangeConfigurationWindow = new Stage();
		ChangeConfigurationWindow.setTitle("ChangeConfiguration");

		// Erzeugt ein TabellenPanel.
		GridPane grid = new GridPane();
		// Setzt alle Ränder auf 10 Pixel.
		grid.setPadding(new Insets(10, 10, 10, 10));
		// Setzt den Abstand innerhalb der Tabelle auf 5 Pixel.
		grid.setVgap(5);
		grid.setHgap(5);
		// Setzt Zeilen/Spaltenposition der Elemente fest.
		// (Objekt, Spalte, Zeile)

		grid.getChildren().addAll();

		ChangeConfigurationWindow.setScene(new Scene(grid, 320, 240));
		ChangeConfigurationWindow.setResizable(false);

	}

	public void run() {
		ChangeConfigurationWindow.show();
	}

}
