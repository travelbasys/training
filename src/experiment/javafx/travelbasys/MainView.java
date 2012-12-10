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
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;

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
	private Scene mainframe;

	public MainView(MainModel model, Stage stage) {
		this.model = (MainModel) model;
		primaryStage = stage;
	}

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

	public MenuItem getCustomerListItem() {
		return customerShowAllItem;
	}

	public MenuItem getCustomerDeleteItem() {
		return customerDeleteItem;
	}

	public MenuItem getAboutItem() {
		return aboutItem;
	}

	public void init() {

		// Titel festlegen
		primaryStage.setTitle(AppContext.getMessage("TravelbasysManager"));

		// Erstelle einzelne Menüs
		final Menu menu1 = new Menu(AppContext.getMessage("File"));
		final Menu menu2 = new Menu(AppContext.getMessage("Edit"));
		final Menu menu3 = new Menu(AppContext.getMessage("Customer"));
		final Menu menu4 = new Menu(AppContext.getMessage("Options"));
		final Menu menu5 = new Menu(AppContext.getMessage("Extras"));
		final Menu menu6 = new Menu(AppContext.getMessage("Help"));

		// Submenü

		final Menu changeDB = new Menu(AppContext.getMessage("ChangeDatabase"));
		final Menu changeLanguage = new Menu(
				AppContext.getMessage("ChangeLanguage"));

		// Erstelle Menu-Items

		exportingItem = new MenuItem(AppContext.getMessage("ExportTo"));
		exportingItem.setId("export-item");
		importingItem = new MenuItem(AppContext.getMessage("ImportFrom"));
		exitItem = new MenuItem(AppContext.getMessage("Exit"));
		customerCreateItem = new MenuItem(AppContext.getMessage("NewCustomer"));
		customerShowItem = new MenuItem(AppContext.getMessage("ShowCustomer"));
		customerEditItem = new MenuItem(AppContext.getMessage("EditCustomer"));
		customerDeleteItem = new MenuItem(
				AppContext.getMessage("DeleteCustomer"));
		customerShowAllItem = new MenuItem(
				AppContext.getMessage("ShowAllCustomers"));
		configurationItem = new MenuItem(AppContext.getMessage("Configuration"));
		lotteryItem = new MenuItem(
				AppContext.getMessage("DetermineLotteryNumbers"));
		aboutItem = new MenuItem(AppContext.getMessage("About"));

		changeDB1Item = new MenuItem(AppContext.getMessage("DatabaseType1"));
		changeDB2Item = new MenuItem(AppContext.getMessage("DatabaseType2"));
		changeDB3Item = new MenuItem(AppContext.getMessage("DatabaseType3"));

		changeLanguage1Item = new MenuItem(AppContext.getMessage("German"));
		changeLanguage2Item = new MenuItem(AppContext.getMessage("English"));

		exitItem.setGraphic(new ImageView(new Image("./resources./exit.png")));

		// Dem Submenü Items hinzufügen

		changeLanguage.getItems().addAll(changeLanguage1Item,
				changeLanguage2Item);
		changeDB.getItems().addAll(changeDB1Item, changeDB2Item, changeDB3Item);

		// Füge Items (auch Submenüs) den Menüpunkten hinzu.

		menu1.getItems().addAll(exportingItem, importingItem, exitItem);
		menu3.getItems().addAll(customerCreateItem, customerShowItem,
				customerEditItem, customerDeleteItem, customerShowAllItem);
		menu4.getItems().addAll(changeLanguage, changeDB, configurationItem);
		menu5.getItems().addAll(lotteryItem);
		menu6.getItems().addAll(aboutItem);

		// MenuBar erstellen
		MenuBar menuBar = new MenuBar();

		// Der MenuBar eine Collection von Menu-Objekten hinzufügen
		menuBar.getMenus().addAll(menu1, menu2, menu3, menu4, menu5, menu6);

		// Hauptpanel erstellen
		root = new BorderPane();

		// Label mit Willkommensnachricht anlegen
		Label welcome = new Label(AppContext.getMessage("Welcome"));
		welcome.getStyleClass().add("header1");

		// Dem Hauptpanel die Elemente hinzufügen
		root.setTop(menuBar);
		root.setCenter(welcome);
		root.getStylesheets().add("./resources/stylesheet.css");

		// Größe des Hauptfensters festlegen
		mainframe = new Scene(root, 800, 600);
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

	public void dbtypeswitch(int dbtype) {
		switch (dbtype) {
		case 1:
			changeDB1Item.setGraphic(new ImageView(new Image(
					"./resources./haken.png")));
			changeDB2Item.setGraphic(new ImageView(new Image(
					"./resources./kreuz.png")));
			changeDB3Item.setGraphic(new ImageView(new Image(
					"./resources./kreuz.png")));
			break;
		case 2:
			changeDB2Item.setGraphic(new ImageView(new Image(
					"./resources./haken.png")));
			changeDB3Item.setGraphic(new ImageView(new Image(
					"./resources./kreuz.png")));
			changeDB1Item.setGraphic(new ImageView(new Image(
					"./resources./kreuz.png")));
			break;
		case 3:
			changeDB3Item.setGraphic(new ImageView(new Image(
					"./resources./haken.png")));
			changeDB2Item.setGraphic(new ImageView(new Image(
					"./resources./kreuz.png")));
			changeDB1Item.setGraphic(new ImageView(new Image(
					"./resources./kreuz.png")));
			break;
		default:
			changeDB1Item.setGraphic(new ImageView(new Image(
					"./resources./haken.png")));
			changeDB2Item.setGraphic(new ImageView(new Image(
					"./resources./kreuz.png")));
			changeDB3Item.setGraphic(new ImageView(new Image(
					"./resources./kreuz.png")));
			break;
		}
	}
}
