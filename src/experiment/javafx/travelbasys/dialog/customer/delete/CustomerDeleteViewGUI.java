package experiment.javafx.travelbasys.dialog.customer.delete;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import de.travelbasys.training.framework.View;

public class CustomerDeleteViewGUI implements View {

	@SuppressWarnings("unused")
	private CustomerDeleteModelGUI model;
	private Button searchButton;
	private TextField customerIDField;
	private BorderPane root;
	private GridPane grid;

	public CustomerDeleteViewGUI(CustomerDeleteModelGUI model, BorderPane root) {
		this.model = (CustomerDeleteModelGUI) model;
		this.root = root;
	}

	public void run() {
		customerIDField = new TextField();
		Label lbl_customerid = new Label("CustomerID:");
		Label lbl_menu = new Label("Customer Delete");
		lbl_menu.setFont(new Font("Arial", 30));

		grid = new GridPane();
		searchButton = new Button("Search");

		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);
		GridPane.setConstraints(lbl_menu, 0, 0);
		GridPane.setConstraints(lbl_customerid, 0, 1);
		GridPane.setConstraints(customerIDField, 3, 1);
		GridPane.setConstraints(searchButton, 10, 10);
		grid.getChildren().addAll(lbl_menu, lbl_customerid, customerIDField,
				searchButton);
	}

	public void show() {
		root.setCenter(grid);
	}

	public Button getSearchButton() {
		return searchButton;
	}

	public TextField getCustomerIDField() {
		return customerIDField;
	}

	public BorderPane getRoot() {
		return root;
	}
	
	
}
