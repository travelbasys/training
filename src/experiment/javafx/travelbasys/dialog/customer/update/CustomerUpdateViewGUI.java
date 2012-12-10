package experiment.javafx.travelbasys.dialog.customer.update;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;

public class CustomerUpdateViewGUI implements View {

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

		Label lbl_menu = new Label(AppContext.getMessage("CustomerEdit"));

		Label lbl_customerid = new Label(AppContext.getMessage("CustomerID"));
		Label lbl_lastname = new Label(AppContext.getMessage("Lastname"));
		Label lbl_firstname = new Label(AppContext.getMessage("Firstname"));
		Label lbl_age = new Label(AppContext.getMessage("Age"));
		Label lbl_adress = new Label(AppContext.getMessage("Adress"));
		Label lbl_postalcode = new Label(AppContext.getMessage("Postalcode"));
		Label lbl_email = new Label(AppContext.getMessage("Email"));
		lbl_age_hint = new Label(AppContext.getMessage("ValidAge"));
		lbl_postalcode_hint = new Label(
				AppContext.getMessage("ValidPostalcode"));

		grid = new GridPane();
		sendButton = new Button(AppContext.getMessage("Send"));
		sendButton.setDisable(true);
		searchButton = new Button(AppContext.getMessage("Search"));
		searchButton.setId("search-button");
		searchButton.setDisable(true);
		newSearchButton = new Button(AppContext.getMessage("NewSearch"));
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
}
