package experiment.javafx.travelbasys.dialog.customer.create;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import de.travelbasys.training.framework.Model;

public class CustomerCreateModelGUI implements Model {

	private BorderPane root;
	private GridPane grid;
	private TextField txt_lastname;
	private TextField txt_firstname;
	private TextField txt_age;
	private TextField txt_adress;
	private TextField txt_postalcode;
	private TextField txt_email;
	private Button btn;

	public CustomerCreateModelGUI(BorderPane root) {
		this.root = root;
	}

	public BorderPane getRoot() {
		return root;
	}

	public void setWindow(GridPane grid) {
		this.grid = grid;
	}

	public GridPane getWindow() {
		return grid;
	}

	public TextField getTxt_lastname() {
		return txt_lastname;
	}

	public void setTxt_lastname(TextField txt_lastname) {
		this.txt_lastname = txt_lastname;
	}

	public TextField getTxt_firstname() {
		return txt_firstname;
	}

	public void setTxt_firstname(TextField txt_firstname) {
		this.txt_firstname = txt_firstname;
	}

	public TextField getTxt_age() {
		return txt_age;
	}

	public void setTxt_age(TextField txt_age) {
		this.txt_age = txt_age;
	}

	public TextField getTxt_adress() {
		return txt_adress;
	}

	public void setTxt_adress(TextField txt_adress) {
		this.txt_adress = txt_adress;
	}

	public TextField getTxt_postalcode() {
		return txt_postalcode;
	}

	public void setTxt_postalcode(TextField txt_postalcode) {
		this.txt_postalcode = txt_postalcode;
	}

	public TextField getTxt_email() {
		return txt_email;
	}

	public void setTxt_email(TextField txt_email) {
		this.txt_email = txt_email;
	}

	public void setBtn(Button btn) {
		this.btn = btn;
	}

	public Button getBtn() {
		return btn;
	}

}
