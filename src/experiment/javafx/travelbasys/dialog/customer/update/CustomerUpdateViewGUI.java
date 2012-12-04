package experiment.javafx.travelbasys.dialog.customer.update;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

public class CustomerUpdateViewGUI implements View {

	private CustomerUpdateModelGUI model;

	public CustomerUpdateViewGUI(Model model) {
		this.model = (CustomerUpdateModelGUI) model;
	}

	public void run() {

		final TextField txt_customerid = new TextField();

		final TextField txt_lastname = new TextField();
		txt_lastname.setEditable(false);

		final TextField txt_firstname = new TextField();
		txt_firstname.setEditable(false);

		final TextField txt_age = new TextField();
		txt_age.setEditable(false);

		final TextField txt_adress = new TextField();
		txt_adress.setEditable(false);

		final TextField txt_postalcode = new TextField();
		txt_postalcode.setEditable(false);

		final TextField txt_email = new TextField();
		txt_email.setEditable(false);

		Label lbl_menu = new Label("Customer Edit");
		lbl_menu.setFont(new Font("Arial", 30));
		Label lbl_customerid = new Label("CustomerID:");
		Label lbl_lastname = new Label("Lastname:");
		Label lbl_firstname = new Label("Firstname:");
		Label lbl_age = new Label("Age:");
		Label lbl_adress = new Label("Adress:");
		Label lbl_postalcode = new Label("Postalcode:");
		Label lbl_email = new Label("EMail:");
		Label lbl_age_hint = new Label("Valid age: 1-150");
		Label lbl_postalcode_hint = new Label(
				"Valid Postalcode: Must contain 5 digits");

		GridPane grid = new GridPane();
		final Button sendButton = new Button("Send");
		sendButton.setDisable(true);
		final Button searchButton = new Button("Search");
		final Button newSearchButton = new Button("New Search");
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
		GridPane.setConstraints(txt_customerid, 1, 1);
		GridPane.setConstraints(txt_lastname, 1, 3);
		GridPane.setConstraints(txt_firstname, 1, 4);
		GridPane.setConstraints(txt_age, 1, 5);
		GridPane.setConstraints(txt_adress, 1, 6);
		GridPane.setConstraints(txt_postalcode, 1, 7);
		GridPane.setConstraints(txt_email, 1, 8);
		GridPane.setConstraints(lbl_age_hint, 3, 5);
		GridPane.setConstraints(lbl_postalcode_hint, 3, 7);
		GridPane.setConstraints(sendButton, 3, 10);
		GridPane.setConstraints(searchButton, 3, 1);
		GridPane.setConstraints(newSearchButton, 4, 1);
		grid.getChildren().addAll(lbl_menu, lbl_customerid, lbl_lastname,
				lbl_firstname, lbl_age, lbl_adress, lbl_postalcode, lbl_email,
				lbl_age_hint, lbl_postalcode_hint, txt_customerid,
				txt_lastname, txt_firstname, txt_age, txt_adress,
				txt_postalcode, txt_email, sendButton, searchButton, newSearchButton);
		model.setTxt_customerid(txt_customerid);
		model.setTxt_lastname(txt_lastname);
		model.setTxt_firstname(txt_firstname);
		model.setTxt_age(txt_age);
		model.setTxt_adress(txt_adress);
		model.setTxt_postalcode(txt_postalcode);
		model.setTxt_email(txt_email);
		model.setBtn(sendButton);
		model.setBtn2(searchButton);
		model.setBtn3(newSearchButton);
		model.setWindow(grid);

		newSearchButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				clear();
				deactivateEdit();
				deactivateNewSearch();
				activateSearch();

			}

			private void deactivateNewSearch() {
				newSearchButton.setDisable(true);
			}

			private void deactivateEdit() {
				txt_lastname.setEditable(false);
				txt_firstname.setEditable(false);
				txt_age.setEditable(false);
				txt_adress.setEditable(false);
				txt_postalcode.setEditable(false);
				txt_email.setEditable(false);
				sendButton.setDisable(true);
			}

			private void activateSearch() {
				txt_customerid.setEditable(true);
				txt_customerid.clear();
				searchButton.setDisable(false);
			}

			private void clear() {
				txt_lastname.clear();
				txt_firstname.clear();
				txt_age.clear();
				txt_adress.clear();
				txt_postalcode.clear();
				txt_email.clear();
			}

		});
	}

	public void show() {
		model.getRoot().setCenter(model.getWindow());
	}
}
