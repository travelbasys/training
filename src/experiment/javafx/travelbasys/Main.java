package experiment.javafx.travelbasys;

import javafx.application.Application;
import javafx.stage.Stage;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.util.CommandLine;
import de.travelbasys.training.util.Configuration;

/**
 * Hat die Aufgabe eine grafische Oberfläche bereitzustellen, welche Zugriff auf
 * Datenbankfunktionen bietet, um ein Customer-Objekt zu verwalten.
 * 
 * @author tba
 * 
 */

public class Main extends Application {

	/**
	 * Dieses Objekt repräsentiert ein BorderPane Objekt (Panel), welches in der
	 * aktuellen Implementierung von der Applikation beim Start gesetzt wird &
	 * durch Menüpunkte verändert werden kann. TODO: Implementierung verändern,
	 * auslagern in andere Methoden & Klassen. Zurzeit ein großer Haufen
	 * zusammengewürfelter Aktionen. Absolut nicht zufriedenstellend.
	 * 
	 * @pane Ein BorderPane Objekt.
	 */

	public static void main(String[] args) {
		// lädt Konfiguration
		CommandLine.parse(args);
		Configuration.init(CommandLine.getOptions());

		// Starte die grafische Oberfläche
		launch(args);

	}

	// Startmethode der GUI.
	@Override
	public void start(final Stage primaryStage) {

		// Hauptmenü erzeugen...
		Dialog main = new MainDialog(primaryStage);
		main.run();

		// Zeigt das Fenster
		// primaryStage.show();
	}
}