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
import javafx.stage.Stage;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ChangeConfigurationViewGUI implements View {

	private ChangeConfigurationModelGUI model;
	private Stage ChangeConfigurationWindow;
	private Tab databaseTab;
	private Tab languageTab;
	private ComboBox databaseTypeComboBox;
	private ComboBox languageComboBox;
	private TextField databaseNameField;
	private Label databaseTypeLabel;
	private Label databaseNameLabel;
	private Label languageLabel;
	private BorderPane root;
	private TabPane tabPane;
	private Scene scene;
	private BorderPane bottomPane;
	private Button saveButton;
	private Button abortButton;

	public ChangeConfigurationViewGUI(Model model) {
		this.model = (ChangeConfigurationModelGUI) model;
	}

	public void init() {

		abortButton = new Button("Abbrechen");
		saveButton = new Button("Speichern");
		saveButton.setDisable(true);
		bottomPane = new BorderPane();
		bottomPane.setPadding(new Insets(10, 10, 10, 10));
		bottomPane.setCenter(abortButton);
		bottomPane.setRight(saveButton);

		databaseTypeComboBox = new ComboBox();
		databaseTypeComboBox.getItems().addAll(
				AppContext.getMessage("DatabaseType1"),
				AppContext.getMessage("DatabaseType2"),
				AppContext.getMessage("DatabaseType3"));

		languageComboBox = new ComboBox();
		languageComboBox.getItems().addAll(AppContext.getMessage("English"),
				AppContext.getMessage("German"));

		databaseNameField = new TextField();

		databaseTypeLabel = new Label("Datenbanktyp:");
		databaseNameLabel = new Label("Datenbankname:");
		languageLabel = new Label("Sprache:");

		// Create Language & Database -Tabs
		GridPane databaseTabContent = new GridPane();
		GridPane languageTabContent = new GridPane();

		// Database-Tab
		databaseTabContent.setPadding(new Insets(10, 10, 10, 10));
		databaseTabContent.setVgap(5);
		databaseTabContent.setHgap(5);

		// Language-Tab
		languageTabContent.setPadding(new Insets(10, 10, 10, 10));
		languageTabContent.setVgap(5);
		languageTabContent.setHgap(5);

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

		ChangeConfigurationWindow = new Stage();
		ChangeConfigurationWindow.setTitle("ChangeConfiguration");
		root = new BorderPane();
		tabPane = new TabPane();
		databaseTab = new Tab("Database");
		languageTab = new Tab("Language");

		databaseTab.setClosable(false);
		languageTab.setClosable(false);

		databaseTab.setContent(databaseTabContent);
		languageTab.setContent(languageTabContent);
		tabPane.getTabs().addAll(databaseTab, languageTab);
		root.setCenter(tabPane);
		root.setBottom(bottomPane);
		scene = new Scene(root, 400, 400);
		ChangeConfigurationWindow.setScene(scene);
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

}
