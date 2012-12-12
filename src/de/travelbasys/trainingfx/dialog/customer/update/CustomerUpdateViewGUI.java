package de.travelbasys.trainingfx.dialog.customer.update;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Configuration;
import de.travelbasys.training.util.ConfigurationEvent;
import de.travelbasys.training.util.ConfigurationListener;

public class CustomerUpdateViewGUI implements View, ConfigurationListener {

	private CustomerUpdateModelGUI model;
	private Button searchButton;
	private Button newSearchButton;
	private TextField customerIDField;
	private Button sendButton;
	private TextField lastNameField;
	private TextField firstNameField;
	private TextField ageField;
	private TextField adressField;
	private TextField postalcodeField;
	private TextField emailField;
	private BorderPane root;
	private GridPane grid;
	private Label lbl_age_hint;
	private Label lbl_postalcode_hint;
	private Label lbl_customerid;
	private Label lbl_lastname;
	private Label lbl_firstname;
	private Label lbl_age;
	private Label lbl_adress;
	private Label lbl_postalcode;
	private Label lbl_email;
	private Label lbl_menu;

	public CustomerUpdateViewGUI(Model model, BorderPane root) {
		this.model = (CustomerUpdateModelGUI) model;
		this.root = root;
	}

	public void updateSearchButton() {
		searchButton.setDisable(model.searchIsInvalid());
		
	}

	public void updateSendButton() {
		sendButton.setDisable(model.sendIsInvalid() || model.hasNotChanged());
	
	}

	public void init() {
		
		Configuration.addConfigurationListener(this);

		customerIDField = new TextField();

		lastNameField = new TextField();
		lastNameField.setEditable(false);

		firstNameField = new TextField();
		firstNameField.setEditable(false);

		ageField = new TextField();
		ageField.setEditable(false);

		adressField = new TextField();
		adressField.setEditable(false);

		postalcodeField = new TextField();
		postalcodeField.setEditable(false);

		emailField = new TextField();
		emailField.setEditable(false);

		lbl_menu = new Label();
lbl_menu.setId("header2");
		lbl_customerid = new Label();
		lbl_lastname = new Label();
		lbl_firstname = new Label();
		lbl_age = new Label();
		lbl_adress = new Label();
		lbl_postalcode = new Label();
		lbl_email = new Label();
		lbl_age_hint = new Label();
		lbl_postalcode_hint = new Label();

		grid = new GridPane();
		sendButton = new Button();
		sendButton.setDisable(true);
		searchButton = new Button();
		searchButton.setDisable(true);
		newSearchButton = new Button();
		newSearchButton.setDisable(true);
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);
		GridPane.setConstraints(lbl_menu, 0, 0);
		GridPane.setConstraints(lbl_customerid, 0, 1);
		GridPane.setConstraints(lbl_lastname, 0, 3);
		GridPane.setConstraints(lbl_firstname, 0, 4);
		GridPane.setConstraints(lbl_age, 0, 5);
		GridPane.setConstraints(lbl_adress, 0, 6);
		GridPane.setConstraints(lbl_postalcode, 0, 7);
		GridPane.setConstraints(lbl_email, 0, 8);
		GridPane.setConstraints(customerIDField, 1, 1);
		GridPane.setConstraints(lastNameField, 1, 3);
		GridPane.setConstraints(firstNameField, 1, 4);
		GridPane.setConstraints(ageField, 1, 5);
		GridPane.setConstraints(adressField, 1, 6);
		GridPane.setConstraints(postalcodeField, 1, 7);
		GridPane.setConstraints(emailField, 1, 8);
		GridPane.setConstraints(lbl_age_hint, 3, 5);
		GridPane.setConstraints(lbl_postalcode_hint, 3, 7);
		GridPane.setConstraints(sendButton, 3, 10);
		GridPane.setConstraints(searchButton, 3, 1);
		GridPane.setConstraints(newSearchButton, 4, 1);
		grid.getChildren().addAll(lbl_menu, lbl_customerid, lbl_lastname,
				lbl_firstname, lbl_age, lbl_adress, lbl_postalcode, lbl_email,
				lbl_age_hint, lbl_postalcode_hint, customerIDField,
				lastNameField, firstNameField, ageField, adressField,
				postalcodeField, emailField, sendButton, searchButton,
				newSearchButton);
		
		handleConfigurationEvent(null);

	}

	public void run() {
		root.setCenter(grid);
	}

	public Label getAgeHintLabel() {
		return lbl_age_hint;
	}

	public Label getPostalcodeHintLabel() {
		return lbl_postalcode_hint;
	}

	public Button getSearchButton() {
		return searchButton;
	}

	public Button getNewSearchButton() {
		return newSearchButton;
	}

	public TextField getCustomerIDField() {
		return customerIDField;
	}

	public Button getSendButton() {
		return sendButton;
	}

	public TextField getLastNameField() {
		return lastNameField;
	}

	public TextField getFirstNameField() {
		return firstNameField;
	}

	public TextField getAgeField() {
		return ageField;
	}

	public TextField getAdressField() {
		return adressField;
	}

	public TextField getPostalcodeField() {
		return postalcodeField;
	}

	public TextField getEmailField() {
		return emailField;
	}

	public BorderPane getRoot() {
		return root;
	}

	@Override
	public void handleConfigurationEvent(ConfigurationEvent e) {
		lbl_menu.setText(AppContext.getMessage("CustomerEdit"));
		lbl_customerid.setText(AppContext.getMessage("CustomerID"));
		lbl_lastname.setText(AppContext.getMessage("Lastname"));
		lbl_firstname.setText(AppContext.getMessage("Firstname"));
		lbl_age.setText(AppContext.getMessage("Age"));
		lbl_adress.setText(AppContext.getMessage("Adress"));
		lbl_postalcode.setText(AppContext.getMessage("Postalcode"));
		lbl_email.setText(AppContext.getMessage("Email"));
		lbl_age_hint.setText(AppContext.getMessage("ValidAge"));
		lbl_postalcode_hint.setText(AppContext.getMessage("ValidPostalcode"));
		sendButton.setText(AppContext.getMessage("SendButton"));
		searchButton.setText(AppContext.getMessage("Search"));
		newSearchButton.setText(AppContext.getMessage("NewSearch"));
	}
}
