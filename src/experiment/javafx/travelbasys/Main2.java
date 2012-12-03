package experiment.javafx.travelbasys;

import javafx.application.Application;
import javafx.scene.control.Dialogs;
import javafx.stage.Stage;

/**
 * Hat die Aufgabe eine grafische Oberfl�che bereitzustellen, welche Zugriff auf
 * Datenbankfunktionen bietet, um ein Customer-Objekt zu verwalten.
 * 
 * @author tba
 * 
 */

public class Main2 extends Application {

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
		// Starte die grafische Oberfl�che
		launch(args);
	}

	// Startmethode der GUI.
	@Override
	public void start(final Stage primaryStage) {
		Dialogs.showInformationDialog(primaryStage, "Test");
	}
}