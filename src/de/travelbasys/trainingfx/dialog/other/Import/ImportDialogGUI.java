package de.travelbasys.trainingfx.dialog.other.Import;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.util.Config;

public class ImportDialogGUI implements Dialog {

	private String PATH = "/de/travelbasys/trainingfx/dialog/other/Import/";
	private String FILE = "ImportFrame.fxml";

	private ObservableList<String> tables;

	public ImportDialogGUI(ObservableList<String> tables) {
		this.tables = tables;
	}

	@Override
	public void run() {
		try {

			// TODO: NullPointerException beheben.
			// Grund: Model wird nicht korrekt initialisiert.
			// Model wartet auf Initialisierung durch ImportTablesController,
			// welches vom Dialog befüllt werden soll (Mit Table oder this)
			// Überlegung: Abgucken bei den anderen Klassen, vielleicht
			// Controller Instanz aufrufen und Parameter abfragen? Siehe Update
			// o.ä.

			AnchorPane showPane = FXMLLoader.load(
					getClass().getResource(PATH + FILE), Config.BUNDLE);
			Stage stage = new Stage();
			Scene scene = new Scene(showPane);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ObservableList<String> getTables() {
		return tables;
	}
}
