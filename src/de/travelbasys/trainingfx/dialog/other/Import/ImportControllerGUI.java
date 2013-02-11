package de.travelbasys.trainingfx.dialog.other.Import;

import java.net.URL;
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

	@FXML
	public void handleImportButton() {
		//TODO: Etwas mit der selektierten Tabelle tun. (Daten in aktuelle DB batchen).
		System.out.println(tableView.getSelectionModel().getSelectedItem());
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
