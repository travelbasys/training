package de.travelbasys.trainingfx.MainWindow;

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
import de.travelbasys.training.util.Configuration;
import de.travelbasys.training.util.ConfigurationEvent;
import de.travelbasys.training.util.ConfigurationListener;

/**
 * Diese Klasse repr�sentiert den View des MainWindow's(Des Haupt Fenster's)
 * 
 * @author tba
 * 
 */
public class MainWindowView implements View, ConfigurationListener {

	private Stage primaryStage;
	private BorderPane root;
	@SuppressWarnings("unused")
	private MainWindowModel model;

	private Menu changeDB;
	private Menu changeLanguage;
	private Menu menu1;
	private Menu menu2;
	private Menu menu3;
	private Menu menu4;
	private Menu menu5;
	private Menu menu6;

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
	private Label welcome;
	private MenuBar menuBar;

	public MainWindowView(MainWindowModel model, Stage stage) {
		this.model = (MainWindowModel) model;
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

	/**
	 * Diese Methode erzeugt alle n�tigen Elemente, die f�r das Hauptfenster der
	 * Anwendung ben�tigt werden
	 */
	public void init() {

		Configuration.addConfigurationListener(this);

		// Erstelle Hauptpanel
		root = new BorderPane();

		// MenuBar erstellen
		menuBar = new MenuBar();

		// Erstelle einzelne Men�s
		menu1 = new Menu();
		menu2 = new Menu();
		menu3 = new Menu();
		menu4 = new Menu();
		menu5 = new Menu();
		menu6 = new Menu();

		// Submen�

		changeDB = new Menu();
		changeLanguage = new Menu();

		// Erstelle Menu-Items

		exportingItem = new MenuItem();
		importingItem = new MenuItem();
		exitItem = new MenuItem();
		customerCreateItem = new MenuItem();
		customerShowItem = new MenuItem();
		customerEditItem = new MenuItem();
		customerDeleteItem = new MenuItem();
		customerShowAllItem = new MenuItem();
		configurationItem = new MenuItem();
		lotteryItem = new MenuItem();
		aboutItem = new MenuItem();

		changeDB1Item = new MenuItem();
		changeDB2Item = new MenuItem();
		changeDB3Item = new MenuItem();

		changeLanguage1Item = new MenuItem();
		changeLanguage2Item = new MenuItem();

		welcome = new Label();

		exitItem.setGraphic(new ImageView(new Image("./resources./exit.png")));

		handleConfigurationEvent(null);

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

		// Der MenuBar eine Collection von Menu-Objekten hinzuf�gen
		menuBar.getMenus().addAll(menu1, menu2, menu3, menu4, menu5, menu6);

		// Label mit Willkommensnachricht anlegen
		welcome.getStyleClass().add("header1");

		// Dem Hauptpanel die Elemente hinzuf�gen
		root.setTop(menuBar);
		root.setCenter(welcome);
		// root.getStylesheets().add("./resources/Windows7.css");

		// Gr��e des Hauptfensters festlegen
		mainframe = new Scene(root, 800, 600);
		primaryStage.setScene(mainframe);

		// Gr��e der MenuBar auf die L�nge des Hauptfensters anpassen
		menuBar.prefWidthProperty()
				.setValue(primaryStage.getScene().getWidth());
	}

	/**
	 * Diese Methode zeigt Das Hauptfenster, welches nun dem Benutzer zur
	 * verf�gung steht
	 */
	@Override
	public void run() {
		primaryStage.show();
	}

	public BorderPane getRoot() {
		return root;
	}

	/**
	 * Diese Methode ist f�r das setzen der Internationalen Ausgabe Texte
	 * zust�ndig wenn der Benutzer die Sprache �ndert.
	 */
	@Override
	public void handleConfigurationEvent(ConfigurationEvent e) {

		root.getStylesheets()
				.setAll(((String) Configuration.get("stylesheet")));

		primaryStage.setTitle(AppContext.getMessage("TravelbasysManager"));
		welcome.setText(AppContext.getMessage("Welcome"));

		menu1.setText(AppContext.getMessage("File"));
		menu2.setText(AppContext.getMessage("Edit"));
		menu3.setText(AppContext.getMessage("Customer"));
		menu4.setText(AppContext.getMessage("Options"));
		menu5.setText(AppContext.getMessage("Extras"));
		menu6.setText(AppContext.getMessage("Help"));

		exportingItem.setText(AppContext.getMessage("ExportTo"));
		importingItem.setText(AppContext.getMessage("ImportFrom"));
		exitItem.setText(AppContext.getMessage("Exit"));
		customerCreateItem.setText(AppContext.getMessage("CustomerCreate"));
		customerShowItem.setText(AppContext.getMessage("ShowCustomer"));
		customerEditItem.setText(AppContext.getMessage("EditCustomer"));
		customerDeleteItem.setText(AppContext.getMessage("DeleteCustomer"));
		customerShowAllItem.setText(AppContext.getMessage("ShowAllCustomers"));
		changeDB.setText(AppContext.getMessage("ChangeDatabase"));
		changeLanguage.setText(AppContext.getMessage("ChangeLanguage"));
		configurationItem.setText(AppContext.getMessage("Configuration"));
		lotteryItem.setText(AppContext.getMessage("DetermineLotteryNumbers"));
		aboutItem.setText(AppContext.getMessage("About"));

		changeDB1Item.setText(AppContext.getMessage("DatabaseType1"));
		changeDB2Item.setText(AppContext.getMessage("DatabaseType2"));
		changeDB3Item.setText(AppContext.getMessage("DatabaseType3"));

		changeLanguage1Item.setText(AppContext.getMessage("German"));
		changeLanguage2Item.setText(AppContext.getMessage("English"));

	}
}
