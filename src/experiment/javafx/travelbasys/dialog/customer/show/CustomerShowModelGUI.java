package experiment.javafx.travelbasys.dialog.customer.show;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Model;

public class CustomerShowModelGUI implements Model {

	private BorderPane root;
	private GridPane grid;
	private TextField txt_customerid;
	private ObservableList<Customer> data;
	private Button btn;

	public CustomerShowModelGUI(BorderPane root) {
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

	public void setBtn(Button btn) {
		this.btn = btn;
	}

	public Button getBtn() {
		return btn;
	}

	public void setData(ObservableList<Customer> data) {
		this.data = data;
	}

}
