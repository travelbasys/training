package experiment.javafx.travelbasys;

import javafx.application.Application;
import javafx.stage.Stage;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.util.CommandLine;
import de.travelbasys.training.util.Configuration;

/**
 * Hat die Aufgabe eine grafische Oberfl�che bereitzustellen, welche Zugriff auf
 * Datenbankfunktionen bietet, um ein Customer-Objekt zu verwalten.
 * 
 * @author tba
 * 
 */

public class Main extends Application {

	/**
	 * Dieses Objekt repr�sentiert ein BorderPane Objekt (Panel), welches in der
	 * aktuellen Implementierung von der Applikation beim Start gesetzt wird &
	 * durch Men�punkte ver�ndert werden kann. TODO: Implementierung ver�ndern,
	 * auslagern in andere Methoden & Klassen. Zurzeit ein gro�er Haufen
	 * zusammengew�rfelter Aktionen. Absolut nicht zufriedenstellend.
	 * 
	 * @pane Ein BorderPane Objekt.
	 */

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
		Dialog main = new MainDialog(primaryStage);
		main.run();

		// Zeigt das Fenster
		// primaryStage.show();
	}
}