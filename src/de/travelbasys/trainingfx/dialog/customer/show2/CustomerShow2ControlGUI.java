package de.travelbasys.trainingfx.dialog.customer.show2;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.util.Configuration;
import de.travelbasys.training.util.ConfigurationEvent;
import de.travelbasys.training.util.ConfigurationListener;

public class CustomerShow2ControlGUI implements Initializable,
		ConfigurationListener {

	private CustomerShow2ModelGUI model;
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = new CustomerShow2ModelGUI();

		this.resources = resources;
		// this.root = (BorderPane)location.getClass();

		Configuration.addConfigurationListener(this);

		customerIDField.textProperty().addListener(
				new ChangeListener<String>() {

					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						TextField field = customerIDField;
						try {
							int id = Integer.parseInt(field.getText().trim());
							CustomerShow2ControlGUI.this.model
									.setCustomerid(id);
						} catch (NumberFormatException e) {
							CustomerShow2ControlGUI.this.model.setCustomerid(0);
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
			CustomerShow2ControlGUI.this.model.setData(data);

			if (CustomerShow2ControlGUI.this.model.getData().get(0) != null) {
				Dialogs.showInformationDialog(
						(Stage) root.getScene().getWindow(),
						CustomerShow2ControlGUI.this.resources
								.getString("Lastname")
								+ CustomerShow2ControlGUI.this.model.getData()
										.get(0).getLastName()
								+ "\n"
								+ CustomerShow2ControlGUI.this.resources
										.getString("Firstname")
								+ CustomerShow2ControlGUI.this.model.getData()
										.get(0).getFirstName()
								+ "\n"
								+ CustomerShow2ControlGUI.this.resources
										.getString("Birthdate")
								+ CustomerShow2ControlGUI.this.model.getData()
										.get(0).getBirthdate()
								+ "\n"
								+ CustomerShow2ControlGUI.this.resources
										.getString("Adress")
								+ CustomerShow2ControlGUI.this.model.getData()
										.get(0).getAdress()
								+ "\n"
								+ CustomerShow2ControlGUI.this.resources
										.getString("Postalcode")
								+ CustomerShow2ControlGUI.this.model.getData()
										.get(0).getPostalcode()
								+ "\n"
								+ CustomerShow2ControlGUI.this.resources
										.getString("Email")
								+ CustomerShow2ControlGUI.this.model.getData()
										.get(0).getEmail() + "\n\n",
						CustomerShow2ControlGUI.this.resources
								.getString("CustomerWithID")
								+ customerIDField.getText()
								+ " "
								+ CustomerShow2ControlGUI.this.resources
										.getString("Found"),
						CustomerShow2ControlGUI.this.resources
								.getString("TravelbasysManager"));

			} else {
				Dialogs.showErrorDialog(
						(Stage) root.getScene().getWindow(),
						CustomerShow2ControlGUI.this.resources
								.getString("CustomerWithID")
								+ customerIDField.getText()
								+ " "
								+ CustomerShow2ControlGUI.this.resources
										.getString("NotFound"),
						CustomerShow2ControlGUI.this.resources
								.getString("Error"),
						CustomerShow2ControlGUI.this.resources
								.getString("TravelbasysManager"));
			}
		} catch (NumberFormatException d) {
			Dialogs.showErrorDialog(
					(Stage) root.getScene().getWindow(),
					CustomerShow2ControlGUI.this.resources
							.getString("SyntaxError")
							+ customerIDField.getText()
							+ "\n"
							+ CustomerShow2ControlGUI.this.resources
									.getString("CustomerIDError"),
					CustomerShow2ControlGUI.this.resources.getString("Error"),
					CustomerShow2ControlGUI.this.resources
							.getString("TravelbasysManager"));
		}

	}

	@Override
	public void handleConfigurationEvent(ConfigurationEvent e) {

		resources = e.getResources();
		headerLabel.setText(resources.getString("CustomerShow"));
		customerIDLabel.setText(resources.getString("CustomerID"));
		customerIDField.setPromptText(resources.getString("Customeridfield"));
		searchButton.setText(resources.getString("Search"));

	}
}