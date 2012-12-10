package experiment.javafx.travelbasys.dialog.customer.delete;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;

public class CustomerDeleteViewGUI implements View {

	private CustomerDeleteModelGUI model;
	private Button searchButton;
	private TextField customerIDField;
	private BorderPane root;
	private GridPane grid;

	public CustomerDeleteViewGUI(CustomerDeleteModelGUI model, BorderPane root) {
		this.model = (CustomerDeleteModelGUI) model;
		this.root = root;
	}

	public void init() {
		customerIDField = new TextField();
		Label lbl_customerid = new Label (AppContext.getMessage("CustomerID"));
		Label lbl_menu = new Label(AppContext.getMessage("CustomerDelete"));

		grid = new GridPane();
		searchButton = new Button(AppContext.getMessage("Search"));
		searchButton.setId("search-button");
		// searchButton.getStyleClass().add("button1");
		searchButton.setDisable(true);

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

	public void run() {
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

	public void update() {
		searchButton.setDisable(model.isInvalid());
	}
}
