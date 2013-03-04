package de.travelbasys.trainingfx.dialog.other.Import;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Dialogs;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import de.travelbasys.training.dao.CustomerDaoException;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Configuration;
import de.travelbasys.training.util.ConfigurationEvent;
import de.travelbasys.training.util.ConfigurationListener;

public class ImportControllerGUI implements Initializable,
		ConfigurationListener {

	private ResourceBundle resources;
	@FXML
	private static Label tableHeader;
	@FXML
	private static Button importButton;
	@FXML
	private static ListView<String> tableView;
	@FXML
	private static AnchorPane root;
	private static List<String> tables;

	/**
	 * Diese Methode Initialisiert den Controller der Import Klasse, indem Sie
	 * listener für die Informationen, die für das Importieren einer csv-Datei
	 * oder mdb-Datei(Access Datenbank) benötigt werden.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			tables = Dao.getDAO().getSelectedImportMDBTables();
			tableView.getItems().setAll(tables);
		} catch (NullPointerException e) {
			Dialogs.showErrorDialog(
					null,
					AppContext.getMessage("NoTablesFound"),
					AppContext.getMessage("Error")
							+ AppContext.getMessage("TransactionFail"),
					AppContext.getMessage("TravelbasysManager"));
		}
		tableView.getSelectionModel().selectedItemProperty()
				.addListener(new ChangeListener<String>() {

					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						if (newValue != oldValue) {
							importButton.setDisable(false);
						}
					}
				});

		this.resources = resources;
		Configuration.addConfigurationListener(this);
	}

	// TODO: Sinnvolle Fehlermeldungen.
	@FXML
	public void handleImportButton() {
		try {
			Dao.getDAO().batchUpdateSelectedMDBTable(
					tableView.getSelectionModel().getSelectedItem());
			int importedCustomers = Dao.getDAO().getImportedCustomersNumber();
			if (importedCustomers >= 1) {
				Dialogs.showInformationDialog(null, importedCustomers + " "
						+ resources.getString("CustomerImport"),
						resources.getString("ImportOK"),
						resources.getString("TravelbasysManager"));
			} else {
				Dialogs.showInformationDialog(null,
						AppContext.getMessage("NoNewData"));
			}
		} catch (CustomerDaoException e) {
			Dialogs.showErrorDialog(null, AppContext.getMessage("TableIsEmpty"));
		} catch (IllegalArgumentException e) {
			try {
				Dialogs.showErrorDialog(null, AppContext.getMessage("Record")
						+ " " + Dao.getDAO().getImportResultSet().getRow()
						+ AppContext.getMessage("Damage") + ".");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		Stage stage = (Stage) root.getScene().getWindow();
		stage.close();
	}

	@Override
	public void handleConfigurationEvent(ConfigurationEvent e) {
		resources = e.getResources();
		tableHeader.setText(resources.getString("CustomerShow"));
		importButton.setText(resources.getString("Search"));

	}
}
