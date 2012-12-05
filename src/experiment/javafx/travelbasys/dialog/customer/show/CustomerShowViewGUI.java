package experiment.javafx.travelbasys.dialog.customer.show;

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
import experiment.javafx.travelbasys.dialog.customer.update.CustomerUpdateControlGUI;

public class CustomerShowViewGUI implements View {

	public void setSearchButton(Button searchButton) {
		this.searchButton = searchButton;
	}

	@SuppressWarnings("unused")
	private CustomerShowModelGUI model;

	public CustomerShowViewGUI(Model model, BorderPane root) {
		this.model = (CustomerShowModelGUI) model;
		this.root = root;
	}

	private BorderPane root;
	private GridPane grid;
	private TextField customerIDField;
	private Button searchButton;

	public void run() {

		customerIDField = new TextField();
		Label lbl_customerid = new Label(AppContext.getMessage("CustomerID"));
		Label lbl_menu = new Label(AppContext.getMessage("CustomerShow"));
		lbl_menu.setFont(new Font("Arial", 30));

		grid = new GridPane();
		searchButton = new Button(AppContext.getMessage("Search"));

		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);
		GridPane.setConstraints(lbl_menu, 0, 0);
		GridPane.setConstraints(lbl_customerid, 2, 2);
		GridPane.setConstraints(customerIDField, 3, 2);
		GridPane.setConstraints(searchButton, 10, 10);
		grid.getChildren().addAll(lbl_menu, lbl_customerid, customerIDField,
				searchButton);

	}
	protected void clear() {
		customerIDField
				.clear();}
	public void show() {
		root.setCenter(grid);
	}

	public BorderPane getRoot() {
		return root;
	}

	public GridPane getWindow() {
		return grid;
	}

	public TextField getCustomerIDField() {
		return customerIDField;
	}

	public Button getSearchButton() {
		return searchButton;
	}

}
