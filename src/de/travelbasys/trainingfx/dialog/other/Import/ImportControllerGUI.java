package de.travelbasys.trainingfx.dialog.other.Import;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// TODO: NullPointerException beheben / siehe ImportTablesDialog

		this.resources = resources;
		Configuration.addConfigurationListener(this);

	}

	@Override
	public void handleConfigurationEvent(ConfigurationEvent e) {
		resources = e.getResources();
		tableHeader.setText(resources.getString("CustomerShow"));
		importButton.setText(resources.getString("Search"));

	}
}
