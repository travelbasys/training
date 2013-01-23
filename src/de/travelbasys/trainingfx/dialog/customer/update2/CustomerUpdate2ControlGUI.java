package de.travelbasys.trainingfx.dialog.customer.update2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import de.travelbasys.training.util.Configuration;
import de.travelbasys.training.util.ConfigurationEvent;
import de.travelbasys.training.util.ConfigurationListener;

public class CustomerUpdate2ControlGUI implements Initializable,
		ConfigurationListener {

	ResourceBundle resources;
	@FXML
	private static Label headerLabel;
	@FXML
	private static Label CustomerIDLabel;
	@FXML
	private static Label LastnameLabel;
	@FXML
	private static Label FirstnameLabel;
	@FXML
	private static Label AgeLabel;
	@FXML
	private static Label AdressLabel;
	@FXML
	private static Label PostalcodeLabel;
	@FXML
	private static Label EmailLabel;
	@FXML
	private static TextField CustomerIDField;
	@FXML
	private static TextField LastnameField;
	@FXML
	private static TextField FirstnameField;
	@FXML
	private static TextField AgeField;
	@FXML
	private static TextField AdressField;
	@FXML
	private static TextField PostalcodeField;
	@FXML
	private static TextField EmailField;
	@FXML
	private static Button sendButton;
	@FXML
	private static Button searchButton;
	@FXML
	private static Button newSearchButton;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.resources = resources;
		Configuration.addConfigurationListener(this);
	}

	@Override
	public void handleConfigurationEvent(ConfigurationEvent e) {
		this.resources = e.getResources();

		
		headerLabel.setText(resources.getString("CustomerEdit"));
		CustomerIDLabel.setText(resources.getString("CustomerID"));
		LastnameLabel.setText(resources.getString("Lastname"));
		FirstnameLabel.setText(resources.getString("Firstname"));
		AgeLabel.setText(resources.getString("Age"));
		AdressLabel.setText(resources.getString("Adress"));
		PostalcodeLabel.setText(resources.getString("Postalcode"));
		EmailLabel.setText(resources.getString("Email"));

		CustomerIDField.setPromptText(resources.getString("Customeridfield"));
		LastnameField.setPromptText(resources.getString("Lastnamefield"));
		FirstnameField.setPromptText(resources.getString("Firstnamefield"));
		AgeField.setPromptText(resources.getString("Agefield"));
		AdressField.setPromptText(resources.getString("Adressfield"));
		PostalcodeField.setPromptText(resources.getString("Postalcodefield"));
		EmailField.setPromptText(resources.getString("Emailfield"));

		searchButton.setText(resources.getString("Search"));
		sendButton.setText(resources.getString("SendButton"));
		newSearchButton.setText(resources.getString("NewSearch"));
		
	}
}