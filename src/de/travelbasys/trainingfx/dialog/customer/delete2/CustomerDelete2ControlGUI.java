package de.travelbasys.trainingfx.dialog.customer.delete2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Dialogs;
import javafx.scene.control.Dialogs.DialogOptions;
import javafx.scene.control.Dialogs.DialogResponse;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Configuration;
import de.travelbasys.training.util.ConfigurationEvent;
import de.travelbasys.training.util.ConfigurationListener;

public class CustomerDelete2ControlGUI implements Initializable,
		ConfigurationListener {

	private CustomerDelete2ModelGUI model;
	private ResourceBundle resources;

	@FXML
	private BorderPane root;

	@FXML
	private static Label headerLabel;
	@FXML
	private static Label customerIDLabel;
	@FXML
	private static TextField customerIDField;
	@FXML
	private static Button searchButton;

	/**
	 * Diese Methode Initialisiert den Controller der Delete Klasse, indem Sie
	 * listener für die Atribute eines Customer Objekts anlegt
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = new CustomerDelete2ModelGUI();

		this.resources = resources;
		// this.root = (BorderPane)location.getClass();

		Configuration.addConfigurationListener(this);

		customerIDField.textProperty().addListener(
				new ChangeListener<String>() {
					/**
					 * Dies ist der listener für das Feld der Customer ID der
					 * prüft ob dieser gültig ist, sich ändert und setzt diesen
					 * im Model.
					 * 
					 */
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						TextField field = customerIDField;
						try {
							int id = Integer.parseInt(field.getText().trim());
							CustomerDelete2ControlGUI.this.model
									.setCustomerid(id);
						} catch (NumberFormatException e) {
							CustomerDelete2ControlGUI.this.model
									.setCustomerid(0);
						}

					}
				});

	}

	@FXML
	private void handleSearchButton(ActionEvent e) {
		try {
			ObservableList<Customer> data = FXCollections
					.observableArrayList(Dao.getDAO().findById(
							Integer.parseInt(customerIDField.getText())));
			CustomerDelete2ControlGUI.this.model.setData(data);

			if (CustomerDelete2ControlGUI.this.model.getData().get(0) != null) {
				DialogOptions options = DialogOptions.YES_NO;
				DialogResponse response = Dialogs.showConfirmDialog(
						(Stage) root.getScene().getWindow(),
						CustomerDelete2ControlGUI.this.resources
								.getString("Lastname")
								+ CustomerDelete2ControlGUI.this.model
										.getData().get(0).getLastName()
								+ "\n"
								+ CustomerDelete2ControlGUI.this.resources
										.getString("Firstname")
								+ CustomerDelete2ControlGUI.this.model
										.getData().get(0).getFirstName()
								+ "\n"
								+ CustomerDelete2ControlGUI.this.resources
										.getString("Birthdate")
								+ CustomerDelete2ControlGUI.this.model
										.getData().get(0).getBirthdate()
								+ "\n"
								+ CustomerDelete2ControlGUI.this.resources
										.getString("Adress")
								+ CustomerDelete2ControlGUI.this.model
										.getData().get(0).getAdress()
								+ "\n"
								+ CustomerDelete2ControlGUI.this.resources
										.getString("Postalcode")
								+ CustomerDelete2ControlGUI.this.model
										.getData().get(0).getPostalcode()
								+ "\n"
								+ CustomerDelete2ControlGUI.this.resources
										.getString("Email")
								+ CustomerDelete2ControlGUI.this.model
										.getData().get(0).getEmail()
								+ "\n\n"
								+ CustomerDelete2ControlGUI.this.resources
										.getString("DeleteQuestion"),
						CustomerDelete2ControlGUI.this.resources
								.getString("CustomerWithID")
								+ customerIDField.getText()
								+ " "
								+ CustomerDelete2ControlGUI.this.resources
										.getString("Found"),
						CustomerDelete2ControlGUI.this.resources
								.getString("TravelbasysManager"), options);
				switch (response) {
				case YES:
					try {
						Dao.getDAO().delete(data.get(0));
						Dialogs.showInformationDialog((Stage) root.getScene()
								.getWindow(),

						AppContext.getMessage("DeleteSuccess"), AppContext
								.getMessage("ProcessSuccess"), AppContext
								.getMessage("TravelbasysManager"));
					} catch (Exception f) {
						Dialogs.showErrorDialog((Stage) root.getScene()
								.getWindow(), AppContext
								.getMessage("UnknownError"), AppContext
								.getMessage("Error"), AppContext
								.getMessage("TravelbasysManager"));
					}
				case NO:
					break;
				default:
					break;
				}
			} else {
				Dialogs.showErrorDialog(
						(Stage) root.getScene().getWindow(),
						CustomerDelete2ControlGUI.this.resources
								.getString("CustomerWithID")
								+ customerIDField.getText()
								+ " "
								+ CustomerDelete2ControlGUI.this.resources
										.getString("NotFound"),
						CustomerDelete2ControlGUI.this.resources
								.getString("Error"),
						CustomerDelete2ControlGUI.this.resources
								.getString("TravelbasysManager"));
			}
		} catch (NumberFormatException d) {
			Dialogs.showErrorDialog(
					(Stage) root.getScene().getWindow(),
					CustomerDelete2ControlGUI.this.resources
							.getString("SyntaxError")
							+ customerIDField.getText()
							+ "\n"
							+ CustomerDelete2ControlGUI.this.resources
									.getString("CustomerIDError"),
					CustomerDelete2ControlGUI.this.resources.getString("Error"),
					CustomerDelete2ControlGUI.this.resources
							.getString("TravelbasysManager"));
		}

	}

	/**
	 * Diese Methode ist für das setzen der Internationalen Ausgabe Texte
	 * zuständig wenn der Benutzer die Sprache ändert.
	 */
	@Override
	public void handleConfigurationEvent(ConfigurationEvent e) {

		resources = e.getResources();

		headerLabel.setText(resources.getString("CustomerEdit"));
		customerIDLabel.setText(resources.getString("CustomerID"));

		customerIDField.setPromptText(resources.getString("Customeridfield"));

		searchButton.setText(resources.getString("Search"));

	}
}