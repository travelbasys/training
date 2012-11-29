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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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
	private BorderPane pane;

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

				// (Experimentell) Erstellen einer Tabelle in welcher Labels &
				// Textfelder angelegt werden für das Anlegen eines neuen
				// Customers

				TextField txt_lastname = new TextField();
				TextField txt_firstname = new TextField();
				TextField txt_age = new TextField();
				TextField txt_adress = new TextField();
				TextField txt_postalcode = new TextField();
				TextField txt_email = new TextField();

				Label lbl_lastname = new Label("Lastname:");
				Label lbl_firstname = new Label("Firstname:");
				Label lbl_age = new Label("Age:");
				Label lbl_adress = new Label("Adress:");
				Label lbl_postalcode = new Label("Postalcode:");
				Label lbl_email = new Label("EMail:");

				GridPane grid = new GridPane();
				grid.setPadding(new Insets(10, 10, 10, 10));
				grid.setVgap(5);
				grid.setHgap(5);
				GridPane.setConstraints(lbl_lastname, 0, 0);
				GridPane.setConstraints(lbl_firstname, 0, 1);
				GridPane.setConstraints(lbl_age, 0, 2);
				GridPane.setConstraints(lbl_adress, 0, 3);
				GridPane.setConstraints(lbl_postalcode, 0, 4);
				GridPane.setConstraints(lbl_email, 0, 5);
				GridPane.setConstraints(txt_lastname, 1, 0);
				GridPane.setConstraints(txt_firstname, 1, 1);
				GridPane.setConstraints(txt_age, 1, 2);
				GridPane.setConstraints(txt_adress, 1, 3);
				GridPane.setConstraints(txt_postalcode, 1, 4);
				GridPane.setConstraints(txt_email, 1, 5);
				grid.getChildren().addAll(lbl_lastname, lbl_firstname, lbl_age,
						lbl_adress, lbl_postalcode, lbl_email, txt_lastname,
						txt_firstname, txt_age, txt_adress, txt_postalcode,
						txt_email);

				pane.setCenter(grid);
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

				Label name = new Label("Name: Daniel Rowlin");
				Label year = new Label("Year: 2012");

				// Erzeugt ein TabellenPanel.
				GridPane grid = new GridPane();
				// Setzt alle Ränder auf 10 Pixel.
				grid.setPadding(new Insets(10, 10, 10, 10));
				// Setzt den Abstand innerhalb der Tabelle auf 5 Pixel.
				grid.setVgap(5);
				grid.setHgap(5);
				// Setzt Zeilen/Spaltenposition der Elemente fest.
				// (Objekt, Spalte, Zeile)
				GridPane.setConstraints(name, 0, 0);
				GridPane.setConstraints(year, 0, 1);

				grid.getChildren().addAll(name, year);

				aboutwindow.setScene(new Scene(grid, 320, 240));
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

		exit.setGraphic(new ImageView(new Image("./resources./exit.png")));

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
		BorderPane root = new BorderPane();

		// Label mit Willkommensnachricht anlegen
		Label welcome = new Label("Willkommen zum Travelbasys Customer Manager");

		// Dem Hauptpanel die MenuBar & das Label hinzufügen
		root.setTop(menuBar);
		root.setCenter(welcome);

		// Unser Hauptpanel den Events verfügbar machen
		pane = root;

		// Größe des Hauptfensters festlegen
		Scene mainframe = new Scene(root, 640, 480);
		primaryStage.setScene(mainframe);

		// Größe der MenuBar auf die Länge des Hauptfensters anpassen
		menuBar.prefWidthProperty()
				.setValue(primaryStage.getScene().getWidth());

		// Zeigt das Fenster
		primaryStage.show();
	}
}