package experiment.javafx.travelbasys.dialog.customer.create;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

public class CustomerCreateViewGUI implements View {

	private CustomerCreateModelGUI model;

	public CustomerCreateViewGUI(Model model) {
		this.model = (CustomerCreateModelGUI) model;
	}

	@Override
	public void run() {

		final TextField txt_lastname = new TextField();
		final TextField txt_firstname = new TextField();
		final TextField txt_age = new TextField();
		final TextField txt_adress = new TextField();
		final TextField txt_postalcode = new TextField();
		final TextField txt_email = new TextField();

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

		GridPane grid = new GridPane();
		Button btn = new Button("Send");

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
		GridPane.setConstraints(txt_lastname, 1, 1);
		GridPane.setConstraints(txt_firstname, 1, 2);
		GridPane.setConstraints(txt_age, 1, 3);
		GridPane.setConstraints(txt_adress, 1, 4);
		GridPane.setConstraints(txt_postalcode, 1, 5);
		GridPane.setConstraints(txt_email, 1, 6);
		GridPane.setConstraints(lbl_age_hint, 2, 3);
		GridPane.setConstraints(lbl_postalcode_hint, 2, 5);
		GridPane.setConstraints(btn, 10, 10);

		grid.getChildren().addAll(lbl_menu, lbl_lastname, lbl_firstname,
				lbl_age, lbl_adress, lbl_postalcode, lbl_email, lbl_age_hint,
				lbl_postalcode_hint, txt_lastname, txt_firstname, txt_age,
				txt_adress, txt_postalcode, txt_email, btn);

		model.setTxt_lastname(txt_lastname);
		model.setTxt_firstname(txt_firstname);
		model.setTxt_age(txt_age);
		model.setTxt_adress(txt_adress);
		model.setTxt_postalcode(txt_postalcode);
		model.setTxt_email(txt_email);
		model.setBtn(btn);
		model.setWindow(grid);
	}

	public void show() {
		model.getRoot().setCenter(model.getWindow());
	}

}
