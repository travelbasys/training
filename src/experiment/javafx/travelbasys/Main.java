package experiment.javafx.travelbasys;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		// Starte die grafische Oberfläche
		launch(args);
	}

	// Startmethode der GUI.
	@Override
	public void start(final Stage primaryStage) {

		// Titel festlegen
		primaryStage.setTitle("Travelbasys Customer Manager");

		// Erstelle einzelne Menüs
		final Menu menu1 = new Menu("File");
		final Menu menu2 = new Menu("Edit");
		final Menu menu3 = new Menu("Options");
		final Menu menu4 = new Menu("Help");

		// MenuBar erstellen
		MenuBar menuBar = new MenuBar();

		// Der MenuBar eine Collection von Menu-Objekten hinzufügen
		menuBar.getMenus().addAll(menu1, menu2, menu3, menu4);

		// Hauptpanel erstellen
		Pane root = new Pane();

		// Dem Hauptpanel die MenuBar hinzufügen
		root.getChildren().addAll(menuBar);

		// Größe des Hauptfensters festlegen
		primaryStage.setScene(new Scene(root, 640, 480));

		// Größe der MenuBar auf die Länge des Hauptfensters anpassen
		menuBar.prefWidthProperty()
				.setValue(primaryStage.getScene().getWidth());

		// Fenster anzeigen
		primaryStage.show();
	}
}