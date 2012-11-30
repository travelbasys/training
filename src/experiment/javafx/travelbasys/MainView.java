package experiment.javafx.travelbasys;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

public class MainView implements View {

	private Stage primaryStage;
	private BorderPane root;
	@SuppressWarnings("unused")
	private MainModel model;

	private MenuItem exitItem;
	private MenuItem exportingItem;
	private MenuItem importingItem;
	private MenuItem customerCreateItem;
	private MenuItem customerShowItem;
	private MenuItem customerEditItem;
	private MenuItem customerShowAllItem;
	private MenuItem customerDeleteItem;
	private MenuItem aboutItem;

	public MenuItem getExportingItem() {
		return exportingItem;
	}

	public MenuItem getImportingItem() {
		return importingItem;
	}

	public MenuItem getExitItem() {
		return exitItem;
	}

	public MenuItem getCustomerCreateItem() {
		return customerCreateItem;
	}

	public MenuItem getCustomerShowItem() {
		return customerShowItem;
	}

	public MenuItem getCustomerEditItem() {
		return customerEditItem;
	}

	public MenuItem getCustomerShowAllItem() {
		return customerShowAllItem;
	}

	public MenuItem getCustomerDeleteItem() {
		return customerDeleteItem;
	}

	public MenuItem getAboutItem() {
		return aboutItem;
	}

	public MainView(Model model, Stage stage) {
		this.model = (MainModel) model;
		primaryStage = stage;

		// Titel festlegen
		primaryStage.setTitle("Travelbasys Customer Manager");

		// Erstelle einzelne Menüs
		final Menu menu1 = new Menu("File");
		final Menu menu2 = new Menu("Customer");
		final Menu menu3 = new Menu("Edit");
		final Menu menu4 = new Menu("Options");
		final Menu menu5 = new Menu("Help");

		// Erstelle File-Menu-Items

		exportingItem = new MenuItem("Exportieren nach...");
		importingItem = new MenuItem("Importieren nach...");
		exitItem = new MenuItem("Exit");
		customerCreateItem = new MenuItem("New Customer");
		customerShowItem = new MenuItem("Show Customer");
		customerEditItem = new MenuItem("Edit Customer");
		customerDeleteItem = new MenuItem("Delete Customer");
		customerShowAllItem = new MenuItem("Show all Customers");
		aboutItem = new MenuItem("About");

		// Dem Exit-Menüpunkt wird eine Grafik zugewiesen

		exitItem.setGraphic(new ImageView(new Image("./resources./exit.png")));

		// Füge Items den Menüpunkten hinzu.

		menu1.getItems().addAll(exportingItem, importingItem, exitItem);
		menu2.getItems().addAll(customerCreateItem, customerShowItem,
				customerEditItem, customerDeleteItem, customerShowAllItem);
		menu5.getItems().addAll(aboutItem);

		// MenuBar erstellen
		MenuBar menuBar = new MenuBar();

		// Der MenuBar eine Collection von Menu-Objekten hinzufügen
		menuBar.getMenus().addAll(menu1, menu2, menu3, menu4, menu5);

		// Hauptpanel erstellen
		root = new BorderPane();

		// Label mit Willkommensnachricht anlegen
		Label welcome = new Label("Willkommen zum Travelbasys Customer Manager");

		// Dem Hauptpanel die MenuBar & das Label hinzufügen
		root.setTop(menuBar);
		root.setCenter(welcome);

		// Größe des Hauptfensters festlegen
		Scene mainframe = new Scene(root, 640, 480);
		primaryStage.setScene(mainframe);

		// Größe der MenuBar auf die Länge des Hauptfensters anpassen
		menuBar.prefWidthProperty()
				.setValue(primaryStage.getScene().getWidth());
	}

	@Override
	public void run() {
		primaryStage.show();
	}

	public BorderPane getRoot() {
		return root;
	}
}
