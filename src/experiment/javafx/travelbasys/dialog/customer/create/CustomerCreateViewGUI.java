package experiment.javafx.travelbasys.dialog.customer.create;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

public class CustomerCreateViewGUI implements View {

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

	public CustomerCreateViewGUI(Model model, BorderPane root) {
		this.model = (CustomerCreateModelGUI) model;
		this.root = root;
	}

	@Override
	public void run() {

		lastNameField = new TextField();
		firstNameField = new TextField();
		ageField = new TextField();
		adressField = new TextField();
		postalcodeField = new TextField();
		emailField = new TextField();

		Label lbl_menu = new Label("Customer Create");
		lbl_menu.setFont(new Font("Arial", 30));
		Label lbl_lastname = new Label("Lastname:");
		Label lbl_firstname = new Label("Firstname:");
		Label lbl_age = new Label("Age:");
		Label lbl_adress = new Label("Adress:");
		Label lbl_postalcode = new Label("Postalcode:");
		Label lbl_email = new Label("EMail:");
		Label lbl_age_hint = new Label("Valid age: 1-150");
		Label lbl_postalcode_hint = new Label(
				"Valid Postalcode: Must contain 5 digits");

		grid = new GridPane();
		sendButton = new Button("Send");

		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);
		GridPane.setConstraints(lbl_menu, 0, 0);
		GridPane.setConstraints(lbl_lastname, 0, 1);
		GridPane.setConstraints(lbl_firstname, 0, 2);
		GridPane.setConstraints(lbl_age, 0, 3);
		GridPane.setConstraints(lbl_adress, 0, 4);
		GridPane.setConstraints(lbl_postalcode, 0, 5);
		GridPane.setConstraints(lbl_email, 0, 6);
		GridPane.setConstraints(lastNameField, 1, 1);
		GridPane.setConstraints(firstNameField, 1, 2);
		GridPane.setConstraints(ageField, 1, 3);
		GridPane.setConstraints(adressField, 1, 4);
		GridPane.setConstraints(postalcodeField, 1, 5);
		GridPane.setConstraints(emailField, 1, 6);
		GridPane.setConstraints(lbl_age_hint, 2, 3);
		GridPane.setConstraints(lbl_postalcode_hint, 2, 5);
		GridPane.setConstraints(sendButton, 10, 10);

		grid.getChildren().addAll(lbl_menu, lbl_lastname, lbl_firstname,
				lbl_age, lbl_adress, lbl_postalcode, lbl_email, lbl_age_hint,
				lbl_postalcode_hint, lastNameField, firstNameField, ageField,
				adressField, postalcodeField, emailField, sendButton);
	}

	public void show() {
		root.setCenter(grid);
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

}
