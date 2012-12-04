package experiment.javafx.travelbasys.dialog.customer.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.framework.Model;

public class CustomerListModelGUI implements Model{
	private ObservableList<Customer> data;
	private BorderPane root;
	private GridPane grid;
	
	
	public CustomerListModelGUI(BorderPane root2) {
		// TODO Auto-generated constructor stub
	}


	public BorderPane getRoot() {
		return root;
	}


	public void setRoot(BorderPane root) {
		this.root = root;
	}


	public void setWindow(GridPane grid) {
		this.grid = grid;
	}

	public GridPane getWindow() {
		return grid;
	}


	public ObservableList<Customer> getData() {
		data = FXCollections.observableArrayList(Dao.getDAO()
				.findAll());
		return data;
	}
}
