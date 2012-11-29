package experiment.javafx.travelbasys;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
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
		final Menu menu2 = new Menu("Customer");
		final Menu menu3 = new Menu("Edit");
		final Menu menu4 = new Menu("Options");
		final Menu menu5 = new Menu("Help");

		// Erstelle File-Menu-Items

		MenuItem exporting = new MenuItem("Exportieren nach...");
		exporting.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
			}
		});
		MenuItem importing = new MenuItem("Importieren nach...");
		importing.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
			}
		});

		MenuItem exit = new MenuItem("Exit");
		exit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.exit(0);
			}
		});

		// Erstelle Customer-Menu-Items

		MenuItem newcustomer = new MenuItem("New Customer");
		newcustomer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
			}
		});

		MenuItem showcustomer = new MenuItem("Show Customer");
		showcustomer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
			}
		});

		MenuItem editcustomer = new MenuItem("Edit Customer");
		editcustomer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
			}
		});

		MenuItem deletecustomer = new MenuItem("Delete Customer");
		deletecustomer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
			}
		});

		MenuItem showallcustomers = new MenuItem("Show all Customers");
		showallcustomers.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
			}
		});

		// Erstelle Help-Menü-Items

		MenuItem about = new MenuItem("About");

		// Behandelt einen Klick auf das About-Item
		// Legt ein neues Fenster an, in welchem Name & Jahr innerhalb einer
		// (unsichtbaren) Tabelle angezeigt
		// werden.

		about.setOnAction(new EventHandler<ActionEvent>() {

			private Stage buildabout() {
				Stage aboutwindow = new Stage();
				aboutwindow.setTitle("About");

				Pane root = new Pane();

				Label name = new Label("Name: Daniel Rowlin");
				Label year = new Label("Year: 2012");

				GridPane grid = new GridPane();
				grid.setPadding(new Insets(10, 10, 10, 10));
				grid.setVgap(5);
				grid.setHgap(5);
				GridPane.setConstraints(name, 0, 0);
				GridPane.setConstraints(year, 0, 1);

				grid.getChildren().addAll(name, year);

				root.getChildren().addAll(grid);

				aboutwindow.setScene(new Scene(root, 320, 240));
				aboutwindow.setResizable(false);
				return aboutwindow;
			}

			// Zeigt das Fenster

			@Override
			public void handle(ActionEvent e) {
				buildabout().show();
			}

		});

		// Dem Exit-Menüpunkt wird eine Grafik zugewiesen

		// exit.setGraphic(new ImageView(new Image("exit.png")));

		// Füge Items den Menüpunkten hinzu.

		menu1.getItems().addAll(exporting, importing, exit);
		menu2.getItems().addAll(newcustomer, showcustomer, editcustomer,
				deletecustomer, showallcustomers);
		menu5.getItems().addAll(about);

		// MenuBar erstellen
		MenuBar menuBar = new MenuBar();

		// Der MenuBar eine Collection von Menu-Objekten hinzufügen
		menuBar.getMenus().addAll(menu1, menu2, menu3, menu4, menu5);

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