package de.travelbasys.trainingfx.rbsjavafx.main;

import javafx.application.Application;
import javafx.stage.Stage;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.util.CommandLine;
import de.travelbasys.training.util.Configuration;
import de.travelbasys.trainingfx.MainWindow.MainWindowDialog;

/**
 * Hat die Aufgabe eine grafische Oberfl�che bereitzustellen, welche Zugriff auf
 * Datenbankfunktionen bietet, um ein Customer-Objekt zu verwalten.
 * 
 * @author tba
 * 
 */

public class Main extends Application {

	public static void main(String[] args) {
		// l�dt Konfiguration
		CommandLine.parse(args);
		Configuration.init(CommandLine.getOptions());

		// Starte die grafische Oberfl�che
		launch(args);

	}

	// Startmethode der GUI.
	@Override
	public void start(final Stage primaryStage) {

		// Hauptmen� erzeugen...
		Dialog main = new MainWindowDialog(primaryStage);
		main.run();

		// Zeigt das Fenster
		// primaryStage.show();
	}
}