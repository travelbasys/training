package experiment.javafx.fxml.main;

import javafx.application.Application;
import javafx.stage.Stage;
import de.travelbasys.training.framework.Dialog;

/*
 * MainApplication der Experiment HelloWorld-Klasse:
 * Diese Klasse hat die Aufgabe unseren Dialog zu starten, welcher eine GUI anzeigen soll.
 * Implementierung: Overridet die start-Methode von Application und gibt die Stage weiter an einen Dialog.
 */
public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Dialog d = new RBSTestGUIDialog(stage);
		d.run();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
