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
import de.travelbasys.training.util.AppContext;

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
	
	public void update(){
		sendButton.setDisable(model.isInvalid());
	}

	@Override
	public void run() {

		lastNameField = new TextField();
		firstNameField = new TextField();
		ageField = new TextField();
		adressField = new TextField();
		postalcodeField = new TextField();
		emailField = new TextField();

		Label lbl_menu = new Label(AppContext.getMessage("CustomerCreate"));
		lbl_menu.setFont(new Font("Arial", 30));
		Label lbl_lastname = new Label(AppContext.getMessage("Lastname"));
		Label lbl_firstname = new Label(AppContext.getMessage("Firstname"));
		Label lbl_age = new Label(AppContext.getMessage("Age"));
		Label lbl_adress = new Label(AppContext.getMessage("Adress"));
		Label lbl_postalcode = new Label(AppContext.getMessage("Postalcode"));
		Label lbl_email = new Label(AppContext.getMessage("Email"));
		Label lbl_age_hint = new Label(AppContext.getMessage("ValidAge"));
		Label lbl_postalcode_hint = new Label(
				AppContext.getMessage("ValidPostalcode"));

		grid = new GridPane();
		sendButton = new Button("Send");

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
	}

	public void show() {
		root.setCenter(grid);
		// Wenn alles gesetzt ist, dann SendButton an(Schleife Listener??)
		// Experimentell
//		while (!(model.getLastname() == null)
//				&& !(model.getFirstname() == null) && model.getAge() != 0
//				&& !(model.getAdress() == null)
//				&& !(model.getPostalcode() == null)
//				&& !(model.getEmail() == null)) {
//			System.out.println("Keks");
//
//		}
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
