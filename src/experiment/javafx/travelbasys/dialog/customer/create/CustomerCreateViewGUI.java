package experiment.javafx.travelbasys.dialog.customer.create;

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

public class CustomerCreateViewGUI implements View, ConfigurationListener {

	private CustomerCreateModelGUI model;
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

	private Label lbl_menu;
	private Label lbl_lastname;
	private Label lbl_firstname;
	private Label lbl_age;
	private Label lbl_adress;
	private Label lbl_postalcode;
	private Label lbl_email;

	public CustomerCreateViewGUI(Model model, BorderPane root) {
		this.model = (CustomerCreateModelGUI) model;
		this.root = root;
	}

	public void update() {
		sendButton.setDisable(model.isInvalid());
	}

	public void init() {

		Configuration.addConfigurationListener(this);

		lastNameField = new TextField();
		firstNameField = new TextField();
		ageField = new TextField();
		adressField = new TextField();
		postalcodeField = new TextField();
		emailField = new TextField();

		lbl_menu = new Label();
		lbl_menu.setId("header2");
		
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

		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);
		GridPane.setConstraints(lbl_menu, 0, 0);
		GridPane.setConstraints(lbl_lastname, 1, 1);
		GridPane.setConstraints(lbl_firstname, 1, 2);
		GridPane.setConstraints(lbl_age, 1, 3);
		GridPane.setConstraints(lbl_adress, 1, 4);
		GridPane.setConstraints(lbl_postalcode, 1, 5);
		GridPane.setConstraints(lbl_email, 1, 6);
		GridPane.setConstraints(lastNameField, 2, 1);
		GridPane.setConstraints(firstNameField, 2, 2);
		GridPane.setConstraints(ageField, 2, 3);
		GridPane.setConstraints(adressField, 2, 4);
		GridPane.setConstraints(postalcodeField, 2, 5);
		GridPane.setConstraints(emailField, 2, 6);
		GridPane.setConstraints(lbl_age_hint, 3, 3);
		GridPane.setConstraints(lbl_postalcode_hint, 3, 5);
		GridPane.setConstraints(sendButton, 3, 10);

		grid.getChildren().addAll(lbl_menu, lbl_lastname, lbl_firstname,
				lbl_age, lbl_adress, lbl_postalcode, lbl_email, lbl_age_hint,
				lbl_postalcode_hint, lastNameField, firstNameField, ageField,
				adressField, postalcodeField, emailField, sendButton);

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

	public void handleConfigurationEvent(ConfigurationEvent e) {
		lbl_menu.setText(AppContext.getMessage("CustomerCreate"));
		lbl_lastname.setText(AppContext.getMessage("Lastname"));
		lbl_firstname.setText(AppContext.getMessage("Firstname"));
		lbl_age.setText(AppContext.getMessage("Age"));
		lbl_adress.setText(AppContext.getMessage("Adress"));
		lbl_postalcode.setText(AppContext.getMessage("Postalcode"));
		lbl_email.setText(AppContext.getMessage("Email"));
		lbl_age_hint.setText(AppContext.getMessage("ValidAge"));
		lbl_postalcode_hint.setText(AppContext.getMessage("ValidPostalcode"));
		sendButton.setText("Send");
	}

}
