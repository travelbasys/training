package experiment.javafx.travelbasys.dialog.other.ChangeConfiguration;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Configuration;
import de.travelbasys.training.util.ConfigurationEvent;
import de.travelbasys.training.util.ConfigurationListener;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ChangeConfigurationViewGUI implements View, ConfigurationListener {

	private ChangeConfigurationModelGUI model;
	private Stage ChangeConfigurationWindow;
	private Tab databaseTab;
	private Tab languageTab;
	private Tab stylesheetTab;
	private ComboBox databaseTypeComboBox;
	private ComboBox languageComboBox;
	private ComboBox stylesheetComboBox;
	private TextField databaseNameField;
	private Label databaseTypeLabel;
	private Label databaseNameLabel;
	private Label languageLabel;
	private Label stylesheetLabel;
	private BorderPane root;
	private TabPane tabPane;
	private Scene scene;
	private BorderPane bottomPane;
	private Button saveButton;
	private Button abortButton;
	private Text german;
	private Text english;
	private Text dbtype1;
	private Text dbtype2;
	private Text dbtype3;

	public ChangeConfigurationViewGUI(Model model) {
		this.model = (ChangeConfigurationModelGUI) model;
	}

	public void init() {

		Configuration.addConfigurationListener(this);

		abortButton = new Button();
		saveButton = new Button();
		saveButton.setDisable(true);
		bottomPane = new BorderPane();
		bottomPane.setPadding(new Insets(10, 10, 10, 10));
		bottomPane.setCenter(abortButton);
		bottomPane.setRight(saveButton);

		german = new Text();
		english = new Text();
		dbtype1 = new Text();
		dbtype2 = new Text();
		dbtype3 = new Text();

		databaseTypeComboBox = new ComboBox();
		databaseTypeComboBox.getItems().addAll(dbtype1, dbtype2, dbtype3);

		languageComboBox = new ComboBox();
		languageComboBox.getItems().addAll(english, german);

		stylesheetComboBox = new ComboBox();
		stylesheetComboBox.setPrefWidth(100);
		stylesheetComboBox.getItems().addAll();

		databaseNameField = new TextField();

		databaseTypeLabel = new Label();
		databaseNameLabel = new Label();
		languageLabel = new Label();
		stylesheetLabel = new Label();

		// Create Language & Database -Tabs
		GridPane databaseTabContent = new GridPane();
		GridPane languageTabContent = new GridPane();
		GridPane stylesheetTabContent = new GridPane();

		// Stylesheet-Tab
		stylesheetTabContent.setPadding(new Insets(10, 10, 10, 10));
		stylesheetTabContent.setVgap(5);
		stylesheetTabContent.setHgap(5);

		// Database-Tab
		databaseTabContent.setPadding(new Insets(10, 10, 10, 10));
		databaseTabContent.setVgap(5);
		databaseTabContent.setHgap(5);

		// Language-Tab
		languageTabContent.setPadding(new Insets(10, 10, 10, 10));
		languageTabContent.setVgap(5);
		languageTabContent.setHgap(5);

		// Stylesheet-Tab
		GridPane.setConstraints(stylesheetLabel, 0, 0);
		GridPane.setValignment(stylesheetLabel, VPos.CENTER);
		GridPane.setHalignment(stylesheetLabel, HPos.RIGHT);
		GridPane.setConstraints(stylesheetComboBox, 1, 0);

		// Database-Tab
		GridPane.setConstraints(databaseTypeLabel, 0, 0);
		GridPane.setValignment(databaseTypeLabel, VPos.CENTER);
		GridPane.setHalignment(databaseTypeLabel, HPos.RIGHT);
		GridPane.setConstraints(databaseNameLabel, 0, 1);
		GridPane.setConstraints(databaseTypeComboBox, 1, 0);
		GridPane.setConstraints(databaseNameField, 1, 1);

		// Language-Tab
		GridPane.setConstraints(languageLabel, 0, 0);
		GridPane.setValignment(languageLabel, VPos.CENTER);
		GridPane.setHalignment(languageLabel, HPos.RIGHT);
		GridPane.setConstraints(languageComboBox, 1, 0);

		databaseTabContent.getChildren().addAll(databaseNameLabel,
				databaseNameField, databaseTypeLabel, databaseTypeComboBox);
		languageTabContent.getChildren()
				.addAll(languageLabel, languageComboBox);
		stylesheetTabContent.getChildren().addAll(stylesheetLabel,
				stylesheetComboBox);

		ChangeConfigurationWindow = new Stage();
		root = new BorderPane();
		tabPane = new TabPane();
		databaseTab = new Tab();
		languageTab = new Tab();
		stylesheetTab = new Tab();
		databaseTab.setClosable(false);
		languageTab.setClosable(false);
		stylesheetTab.setClosable(false);

		databaseTab.setContent(databaseTabContent);
		languageTab.setContent(languageTabContent);
		stylesheetTab.setContent(stylesheetTabContent);
		tabPane.getTabs().addAll(databaseTab, languageTab, stylesheetTab);
		root.setCenter(tabPane);
		root.setBottom(bottomPane);
		scene = new Scene(root, 400, 400);
		ChangeConfigurationWindow.setScene(scene);

		handleConfigurationEvent(null);
	}

	public Stage getStage() {
		return ChangeConfigurationWindow;
	}

	public Button getAbortButton() {
		return abortButton;
	}

	public Button getSaveButton() {
		return saveButton;
	}

	public TextField getDatabaseNameField() {
		return databaseNameField;
	}

	public ComboBox getDatabaseTypeComboBox() {
		return databaseTypeComboBox;
	}

	public ComboBox getLanguageComboBox() {
		return languageComboBox;
	}

	public void run() {
		ChangeConfigurationWindow.show();
	}

	public void updateSaveButton() {
		saveButton.setDisable(model.saveIsInvalid());
	}

	public ComboBox getStylesheetComboBox() {
		return stylesheetComboBox;
	}

	@Override
	public void handleConfigurationEvent(ConfigurationEvent e) {
		abortButton.setText("Abort");
		saveButton.setText("Save");
		databaseTab.setText("Database");
		languageTab.setText("Language");
		stylesheetTab.setText("Stylesheet");
		ChangeConfigurationWindow.setTitle("ChangeConfiguration");
		databaseTypeLabel.setText("Datenbanktyp:");
		databaseNameLabel.setText("Datenbankname:");
		languageLabel.setText("Sprache:");
		stylesheetLabel.setText("Stylesheeet:");
		german.setText(AppContext.getMessage("German"));
		english.setText(AppContext.getMessage("English"));
		dbtype1.setText(AppContext.getMessage("DatabaseType1"));
		dbtype2.setText(AppContext.getMessage("DatabaseType2"));
		dbtype3.setText(AppContext.getMessage("DatabaseType3"));
	}

}
