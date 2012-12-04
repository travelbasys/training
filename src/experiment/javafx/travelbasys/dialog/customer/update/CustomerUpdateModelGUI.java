package experiment.javafx.travelbasys.dialog.customer.update;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Model;

public class CustomerUpdateModelGUI implements Model {

	private BorderPane root;
	private GridPane grid;
	private TextField txt_customerid;
	private ObservableList<Customer> data;
	private Button btn;
	private TextField txt_email;
	private TextField txt_postalcode;
	private TextField txt_adress;
	private TextField txt_age;
	private TextField txt_firstname;
	private TextField txt_lastname;
	private Button btn3;
	private Button btn2;

	public CustomerUpdateModelGUI(BorderPane root) {
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

	public TextField getTxt_customerid() {
		return txt_customerid;
	}

	public void setTxt_customerid(TextField txt_customerid) {
		this.txt_customerid = txt_customerid;
	}

	public ObservableList<Customer> getData() {
		return data;
	}

	public void setData(ObservableList<Customer> data) {
		this.data = data;
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

	public void setBtn2(Button btn2) {
		this.btn2 = btn2;
	}

	public Button getBtn2() {
		return btn2;
	}

	public void setBtn3(Button btn3) {
		this.btn3 = btn3;
	}

	public Button getBtn3() {
		return btn3;
	}

}
