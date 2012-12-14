package experiment.javafx.helloworld.fxml.main;

import javafx.application.Application;
import javafx.stage.Stage;
import de.travelbasys.training.framework.Dialog;
import experiment.javafx.helloworld.fxml.mainmvc.HelloWorldGUIDialog;

/*
 * MainApplication der Experiment HelloWorld-Klasse:
 * Diese Klasse hat die Aufgabe unseren Dialog zu starten, welcher eine GUI anzeigen soll.
 * Implementierung: Overridet die start-Methode von Application und gibt die Stage weiter an einen Dialog.
 */
public class HelloWorld extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Dialog d = new HelloWorldGUIDialog(stage);
		d.run();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
