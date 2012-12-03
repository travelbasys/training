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
	private MenuItem changeDB1Item;
	private MenuItem changeDB2Item;
	private MenuItem changeDB3Item;
	private MenuItem configurationItem;
	private MenuItem changeLanguage1Item;
	private MenuItem changeLanguage2Item;
	private MenuItem lotteryItem;

	public MenuItem getChangeLanguage1Item() {
		return changeLanguage1Item;
	}

	public MenuItem getChangeLanguage2Item() {
		return changeLanguage2Item;
	}

	public MenuItem getChangeDB1Item() {
		return changeDB1Item;
	}

	public MenuItem getChangeDB2Item() {
		return changeDB2Item;
	}

	public MenuItem getChangeDB3Item() {
		return changeDB3Item;
	}

	public MenuItem getLotteryItem() {
		return lotteryItem;
	}

	public MenuItem getConfigurationItem() {
		return configurationItem;
	}

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

		// Erstelle einzelne Men�s
		final Menu menu1 = new Menu("File");
		final Menu menu2 = new Menu("Edit");
		final Menu menu3 = new Menu("Customer");
		final Menu menu4 = new Menu("Options");
		final Menu menu5 = new Menu("Extras");
		final Menu menu6 = new Menu("Help");

		// Submen�

		final Menu changeDB = new Menu("Change Database");
		final Menu changeLanguage = new Menu("Change Language");

		// Erstelle Menu-Items

		exportingItem = new MenuItem("Exportieren nach...");
		importingItem = new MenuItem("Importieren nach...");
		exitItem = new MenuItem("Exit");
		customerCreateItem = new MenuItem("New Customer");
		customerShowItem = new MenuItem("Show Customer");
		customerEditItem = new MenuItem("Edit Customer");
		customerDeleteItem = new MenuItem("Delete Customer");
		customerShowAllItem = new MenuItem("Show all Customers");
		configurationItem = new MenuItem("Configuration...");
		lotteryItem = new MenuItem("Determine Lottery Numbers...");
		aboutItem = new MenuItem("About");

		changeDB1Item = new MenuItem("Access database");
		changeDB2Item = new MenuItem("MySQl database");
		changeDB3Item = new MenuItem("Text database");

		changeLanguage1Item = new MenuItem("Deutsch");
		changeLanguage2Item = new MenuItem("English");

		// Dem Exit-Men�punkt wird eine Grafik zugewiesen

		exitItem.setGraphic(new ImageView(new Image("./resources./exit.png")));

		// Dem Submen� Items hinzuf�gen

		changeLanguage.getItems().addAll(changeLanguage1Item,
				changeLanguage2Item);
		changeDB.getItems().addAll(changeDB1Item, changeDB2Item, changeDB3Item);

		// F�ge Items (auch Submen�s) den Men�punkten hinzu.

		menu1.getItems().addAll(exportingItem, importingItem, exitItem);
		menu3.getItems().addAll(customerCreateItem, customerShowItem,
				customerEditItem, customerDeleteItem, customerShowAllItem);
		menu4.getItems().addAll(changeLanguage, changeDB, configurationItem);
		menu5.getItems().addAll(lotteryItem);
		menu6.getItems().addAll(aboutItem);

		// MenuBar erstellen
		MenuBar menuBar = new MenuBar();

		// Der MenuBar eine Collection von Menu-Objekten hinzuf�gen
		menuBar.getMenus().addAll(menu1, menu2, menu3, menu4, menu5, menu6);

		// Hauptpanel erstellen
		root = new BorderPane();

		// Label mit Willkommensnachricht anlegen
		Label welcome = new Label("Willkommen zum Travelbasys Customer Manager");

		// Dem Hauptpanel die Elemente hinzuf�gen
		root.setTop(menuBar);
		root.setCenter(welcome);

		// Gr��e des Hauptfensters festlegen
		Scene mainframe = new Scene(root, 800, 600);
		primaryStage.setScene(mainframe);

		// Gr��e der MenuBar auf die L�nge des Hauptfensters anpassen
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
