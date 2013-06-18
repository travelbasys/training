package de.travelbasys.trainingfx.dialog.customer.delete;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Configuration;
import de.travelbasys.training.util.ConfigurationEvent;
import de.travelbasys.training.util.ConfigurationListener;

/**
 * Diese Klasse ist für den Dialog auf dem Bildschirm verantwortlich um
 * Benutzereingaben abzufragen (INPUT/OUTPUT)
 **/
public class CustomerDeleteViewGUI implements View, ConfigurationListener {

	private CustomerDeleteModelGUI model;
	private Button searchButton;
	private TextField customerIDField;
	private BorderPane root;
	private GridPane grid;
	private Label lbl_customerid;
	private Label lbl_menu;

	public CustomerDeleteViewGUI(CustomerDeleteModelGUI model, BorderPane root) {
		this.model = (CustomerDeleteModelGUI) model;
		this.root = root;
	}

	public void init() {

		Configuration.addConfigurationListener(this);

		customerIDField = new TextField();
		lbl_customerid = new Label();
		lbl_menu = new Label();
		lbl_menu.setId("header2");

		grid = new GridPane();
		searchButton = new Button();
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

		handleConfigurationEvent(null);

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

	@Override
	public void handleConfigurationEvent(ConfigurationEvent e) {
		lbl_menu.setText(AppContext.getMessage("CustomerDelete"));
		lbl_customerid.setText(AppContext.getMessage("CustomerID"));
		searchButton.setText(AppContext.getMessage("Search"));
	}
}
