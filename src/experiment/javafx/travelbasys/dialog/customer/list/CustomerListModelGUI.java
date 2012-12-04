package experiment.javafx.travelbasys.dialog.customer.list;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Model;

@SuppressWarnings("rawtypes")
public class CustomerListModelGUI implements Model {
	private ObservableList<Customer> data;
	private BorderPane root;
	private VBox vbox;
	private TableView table;

	public CustomerListModelGUI(BorderPane root) {
		this.root = root;
	}

	public BorderPane getRoot() {
		return root;
	}

	public void setWindow(VBox vbox) {
		this.vbox = vbox;
	}

	public VBox getWindow() {
		return vbox;
	}

	public ObservableList<Customer> getData() {
		return data;
	}

	public void setData(ObservableList<Customer> data) {
		this.data = data;
	}

	public void setTable(TableView table) {
		this.table = table;
	}

	public TableView getTable() {
		return table;
	}
}
