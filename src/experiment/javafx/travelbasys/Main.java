package experiment.javafx.travelbasys;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(final Stage primaryStage) {

		// Titel festlegen
		primaryStage.setTitle("Travelbasys Customer Manager");

		final Menu menu1 = new Menu("File");
		final Menu menu2 = new Menu("Edit");
		final Menu menu3 = new Menu("Options");
		final Menu menu4 = new Menu("Help");

		// MenuBar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(menu1, menu2, menu3, menu4);

		// Hauptpanel erstellen
		Pane root = new Pane();

		// Dem Hauptpanel alle MenuBar-Objekte hinzufügen
		root.getChildren().addAll(menuBar);

		// Größe des Hauptfensters festlegen
		primaryStage.setScene(new Scene(root, 640, 480));
		
		//Größe der MenuBar auf die Länge des Hauptfensters anpassen
		menuBar.prefWidthProperty().setValue(primaryStage.getScene().getWidth());

		// Fenster anzeigen
		primaryStage.show();
	}
}